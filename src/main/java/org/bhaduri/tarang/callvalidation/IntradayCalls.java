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
import org.bhaduri.tarang.services.MasterDataServices;

/**
 *
 * @author sb
 */
@Named(value = "intradayCalls")
@ViewScoped
public class IntradayCalls implements Serializable {
    List<Date> intraDateList;
    private Date dateHeading = new Date();
    private Date selectedTime;
    /**
     * Creates a new instance of IntradayCalls
     */
    public IntradayCalls() {
    }
    public void fillScripValues() throws NamingException, ParseException {
        MasterDataServices masterDataService = new MasterDataServices();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = dateOnlyFormat.parse(sdf.format(new Date()));       
                
        String todayDateString = dateOnlyFormat.format(new Date());  // e.g., "2026-02-03"
        String fullDateTimeStr = todayDateString + " 15:27:00.000";  // e.g., "2026-02-03 15:27:00.000"
        Date targetDate;
        targetDate = sdf.parse(fullDateTimeStr);
        intraDateList = masterDataService.getIntraDateList(todayDate, targetDate);
    }
    
    public String goToCallDetails() { 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String selectedTimeStr = sdf.format(selectedTime);
        String redirectUrl = "/secured/intradaycalldetails?faces-redirect=true&selectedTimeStr="+ 
                selectedTimeStr;
        return redirectUrl;
//        return "/secured/userhome";
    }

    public List<Date> getIntraDateList() {
        return intraDateList;
    }

    public void setIntraDateList(List<Date> intraDateList) {
        this.intraDateList = intraDateList;
    }

    public Date getDateHeading() {
        return dateHeading;
    }

    public void setDateHeading(Date dateHeading) {
        this.dateHeading = dateHeading;
    }

    public Date getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(Date selectedTime) {
        this.selectedTime = selectedTime;
    }
    
    
}
