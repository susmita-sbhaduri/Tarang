/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package org.bhaduri.tarang.callvalidation;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.bhaduri.tarang.DTO.CallTable;
import org.bhaduri.tarang.services.MasterDataServices;

/**
 *
 * @author sb
 */
@Named(value = "latestDayCalls")
@ViewScoped
public class LatestDayCalls implements Serializable {
    List<CallTable> dayCallist;
    private Date today;
    
    
    /**
     * Creates a new instance of LatestDayCalls
     */
    public LatestDayCalls() {
        
    }
    public void fillValues() throws NamingException, ParseException {

        today = new Date();
        MasterDataServices masterDataService = new MasterDataServices();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        // Step 1: Get today's date in yyyy-MM-dd format
        SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = dateOnlyFormat.format(new Date());  // e.g., "2026-02-03"

        // Step 2: Append the fixed time
        String fullDateTimeStr = todayDate + " 15:27:00.000";  // e.g., "2026-02-03 15:27:00.000"

        // Step 3: Parse to Date
        Date targetDate;
        targetDate = sdf.parse(fullDateTimeStr);

//        int scripCount = masterDataService.getCountScripId();
        dayCallist = masterDataService.getLatestDayCallList(targetDate);
    }
    
    
    public List<CallTable> getDayCallist() {
        return dayCallist;
    }

    public void setDayCallist(List<CallTable> dayCallist) {
        this.dayCallist = dayCallist;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }
}
