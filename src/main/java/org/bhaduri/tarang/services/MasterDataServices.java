/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bhaduri.tarang.services;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.transaction.UserTransaction;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.bhaduri.tarang.DA.CalltableDAO;
import org.bhaduri.tarang.DA.UserDAO;
import org.bhaduri.tarang.DA.ValidatecallDAO;
import org.bhaduri.tarang.DTO.CallTable;

import org.bhaduri.tarang.DTO.UserDTO;
import org.bhaduri.tarang.DTO.ValidateCall;
import org.bhaduri.tarang.entities.Calltable;
import org.bhaduri.tarang.entities.Users;
import org.bhaduri.tarang.entities.Validatecall;
/**
 *
 * @author sb
 */
public class MasterDataServices {
    private final EntityManagerFactory emf;
    private final UserTransaction utx;
    public MasterDataServices() throws NamingException {
        emf = Persistence.createEntityManagerFactory("org.tarang_persistece_unit");
        utx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
    }
    public UserDTO getUserAuthDetails(String username, String password) {
        UserDAO useraccess = new UserDAO(utx,emf);  
        UserDTO userAuthDto = new UserDTO();
        try {            
            Users userInfo = useraccess.getUserDetails(username, password);
            userAuthDto.setID(userInfo.getIdusers());
            userAuthDto.setUsername(userInfo.getUsername());
            userAuthDto.setPassword(userInfo.getPassword());
            userAuthDto.setName(userInfo.getName());
            return userAuthDto;
        }
        catch (NoResultException e) {
            System.out.println("No user found with provided credentials.");
            userAuthDto.setID("null");
            return userAuthDto;
        }
        catch (Exception exception) {
            System.out.println(exception + " has occurred in getUserAuthDetails.");
            return null;
        }
    }
    
    public List<String> getCallScripIdList() {
        CalltableDAO calltable = new CalltableDAO(utx,emf);
        try {   
            List<String> scriplist = calltable.listScripid();            
            return scriplist;
        }
        catch (NoResultException e) {
            System.out.println("No record found.");           
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception + " has occurred in getCallScripIdList.");
            return null;
        }
    }
    
    public List<ValidateCall> getCallsPerScrip(String scripid) {
        ValidatecallDAO validcalldao = new ValidatecallDAO(utx,emf);
        ValidateCall record = new ValidateCall();
        List<ValidateCall> recordList = new ArrayList<>();
        try {   
            List<Validatecall> calllist = validcalldao.listCallsForScripid(scripid);            
            for (int i = 0; i < calllist.size(); i++) {
                record.setScripId(calllist.get(i).getValidatecallPK().getScripid());
                record.setCallGenerationTimeStamp(calllist.get(i).getValidatecallPK().getLastupdateminute());
                record.setPrice(calllist.get(i).getPrice());
                record.setCallOne(calllist.get(i).getCallone());
                record.setCallTwo(calllist.get(i).getCalltwo());
                record.setActualPriceOne(calllist.get(i).getMarginone());
                record.setActualPriceTwo(calllist.get(i).getMargintwo());
                record.setOutcomeOne(calllist.get(i).getOutcomeone());
                record.setOutcomeTwo(calllist.get(i).getOutcometwo());
                recordList.add(record);
                record = new ValidateCall();
            }
            return recordList;
        }
        catch (NoResultException e) {
            System.out.println("No record found for this scripid.");           
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception + " has occurred in getCallsPerScrip(String scripid).");
            return null;
        }
    }
}
