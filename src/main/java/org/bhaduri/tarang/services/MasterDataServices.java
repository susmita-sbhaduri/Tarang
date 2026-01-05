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
import org.bhaduri.tarang.DTO.CallTable;

import org.bhaduri.tarang.DTO.UserDTO;
import org.bhaduri.tarang.entities.Calltable;
import org.bhaduri.tarang.entities.Users;
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
        CallTable record = new CallTable();
//        List<CallTable> recordList = new ArrayList<>();
        try {   
            List<String> emplist = calltable.listScripid();            
            return emplist;
        }
        catch (NoResultException e) {
            System.out.println("No user found with provided credentials.");           
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception + " has occurred in getCallScripIdList.");
            return null;
        }
    }
}
