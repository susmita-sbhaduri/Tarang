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
import java.util.stream.Collectors;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.bhaduri.tarang.DA.CalltableDAO;
import org.bhaduri.tarang.DA.ScripsDA;
import org.bhaduri.tarang.DA.UserDAO;
import org.bhaduri.tarang.DA.ValidatecallDAO;
import org.bhaduri.tarang.DTO.CallTable;
import org.bhaduri.tarang.DTO.ScripDTO;

import org.bhaduri.tarang.DTO.UserDTO;
import org.bhaduri.tarang.DTO.ValidateCall;
import org.bhaduri.tarang.entities.Calltable;
import org.bhaduri.tarang.entities.CalltablePK;
import org.bhaduri.tarang.entities.Scrips;
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
    
    public List<ScripDTO> getScripsList() {
        ScripsDA scripsDA = new ScripsDA(utx,emf);
        
//        List<ScripDTO> scripsDTOList = scripses.stream().map(s -> new ScripDTO(s.getScripid(), s.getScripname())).collect(Collectors.toList());
        List<ScripDTO> scripsDTOList = new ArrayList<>();
        ScripDTO record = new ScripDTO();
        try {   
            List<Scrips> scripses = scripsDA.listScripid(); 
            for (int i = 0; i < scripses.size(); i++) {
                record.setScripId(scripses.get(i).getScripid());
                record.setScripName(scripses.get(i).getScripname());
                scripsDTOList.add(record);
                record = new ScripDTO();
            }
            return scripsDTOList;
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
    
    public int getCountScripId() {
        ScripsDA scripsDA = new ScripsDA(utx,emf);
        try {
            Long longcount = scripsDA.getScripCount();
            return longcount.intValue();
        } catch (NoResultException e) {
            System.out.println("No records in scrips table");
            return 0;
        } catch (Exception exception) {
            System.out.println(exception + " has occurred in getCountScripId().");
            return 0;
        }
    }
//    public List<ScripDTO> getCallScripIdList() {
//        CalltableDAO calltable = new CalltableDAO(utx,emf);
//        List<ScripDTO> recordList = new ArrayList<>();
//        ScripDTO record = new ScripDTO();
//        try {   
//            List<Scrips> scriplist = calltable.listScripid(); 
//            for (int i = 0; i < scriplist.size(); i++) {
//                record.setScripId(scriplist.get(i).getScripid());
//                record.setScripName(scriplist.get(i).getScripname());
//                recordList.add(record);
//                record = new ScripDTO();
//            }
//            return recordList;
//        }
//        catch (NoResultException e) {
//            System.out.println("No record found.");           
//            return null;
//        }
//        catch (Exception exception) {
//            System.out.println(exception + " has occurred in getCallScripIdList.");
//            return null;
//        }
//    }
    
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
    
    public List<Date> getIntraDateList(Date todaydate, Date todayEndDate) {
        CalltableDAO calldao = new CalltableDAO(utx,emf);
        
        List<Date> recordList = new ArrayList<>();
        try {   
            recordList = calldao.listIntradayDates(todaydate, todayEndDate);
            return recordList;
        }
        catch (NoResultException e) {
            System.out.println("No record found for this todaydate.");           
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception + " has occurred in getIntraDateList.");
            return null;
        }
    }
    
    public List<CallTable> getIntraCallList(Date datetimeinput) {
        CalltableDAO calldao = new CalltableDAO(utx,emf);
        CallTable record = new CallTable();
        List<CallTable> recordList = new ArrayList<>();
        try {  
            List<Calltable> calllist = calldao.listIntradayCalls(datetimeinput);
            for (int i = 0; i < calllist.size(); i++) {
                record.setScripId(calllist.get(i).getCalltablePK().getScripid());
                record.setCallGenerationTimeStamp(calllist.get(i).getCalltablePK()
                        .getLastupdateminute());
                record.setCallVersionOne(calllist.get(i).getCallone());
                record.setCallVersionTwo(calllist.get(i).getCalltwo());
                record.setCallVersionThree(calllist.get(i).getCallthree());
                record.setRetraceVersionOne(calllist.get(i).getRetraceone());
                record.setRetraceVersionTwo(calllist.get(i).getRetracetwo());
                record.setCallGenerationPrice(calllist.get(i).getPrice());
                recordList.add(record);
                record = new CallTable();
            }
            return recordList;
        }
        catch (NoResultException e) {
            System.out.println("No record found for this datetimeinput.");           
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception + " has occurred in getIntraCallList.");
            return null;
        }
    }
    
//    public List<CallTable> getDayCallList(Date today, Date yday) {
    public List<CallTable> getDayCallList(Date today, int scripCount) {
        CalltableDAO calldao = new CalltableDAO(utx,emf);
        CallTable record = new CallTable();
        List<CallTable> recordList = new ArrayList<>();
        try {  
//            List<Calltable> calllist = calldao.listDayCalls(today, yday);
            List<Calltable> calllist = calldao.listDayCalls(today, scripCount);
            for (int i = 0; i < calllist.size(); i++) {
                record.setScripId(calllist.get(i).getCalltablePK().getScripid());
                record.setCallGenerationTimeStamp(calllist.get(i).getCalltablePK()
                        .getLastupdateminute());
                record.setCallVersionOne(calllist.get(i).getCallone());
                record.setCallVersionTwo(calllist.get(i).getCalltwo());
                record.setCallVersionThree(calllist.get(i).getCallthree());
                record.setRetraceVersionOne(calllist.get(i).getRetraceone());
                record.setRetraceVersionTwo(calllist.get(i).getRetracetwo());
                record.setCallGenerationPrice(calllist.get(i).getPrice());
                recordList.add(record);
                record = new CallTable();
            }
            return recordList;
        }
        catch (NoResultException e) {
            System.out.println("No record found for today calls.");           
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception + " has occurred in getDayCallList.");
            return null;
        }
    }
    
     public List<CallTable> getLatestDayCallList(Date latest) {
        CalltableDAO calldao = new CalltableDAO(utx,emf);
        CallTable record = new CallTable();
        List<CallTable> recordList = new ArrayList<>();
        try {  
//            List<Calltable> calllist = calldao.listDayCalls(today, yday);
            List<Calltable> calllist = calldao.listLatestDayCalls(latest);
            for (int i = 0; i < calllist.size(); i++) {
                record.setScripId(calllist.get(i).getCalltablePK().getScripid());
                record.setCallGenerationTimeStamp(calllist.get(i).getCalltablePK()
                        .getLastupdateminute());
                record.setCallVersionOne(calllist.get(i).getCallone());
                record.setCallVersionTwo(calllist.get(i).getCalltwo());
                record.setCallVersionThree(calllist.get(i).getCallthree());
                record.setRetraceVersionOne(calllist.get(i).getRetraceone());
                record.setRetraceVersionTwo(calllist.get(i).getRetracetwo());
                record.setCallGenerationPrice(calllist.get(i).getPrice());
                recordList.add(record);
                record = new CallTable();
            }
            return recordList;
        }
        catch (NoResultException e) {
            System.out.println("No record found for  latest today calls.");           
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception + " has occurred in getLatestDayCallList.");
            return null;
        }
    }
}
