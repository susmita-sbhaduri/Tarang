/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package org.bhaduri.tarang.callvalidation;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.bhaduri.tarang.DTO.CallTable;
import org.bhaduri.tarang.services.MasterDataServices;

/**
 *
 * @author sb
 */
@Named(value = "dayCalls")
@ViewScoped
public class DayCalls implements Serializable {
    List<CallTable> dayCallist;
    private Date today;
    /**
     * Creates a new instance of DayCalls
     */
    public DayCalls() {
    }
    public void fillValues() throws NamingException {
        MasterDataServices masterDataService = new MasterDataServices();
        
        Calendar cal = Calendar.getInstance();        
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        today = cal.getTime();
        
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date yday = cal.getTime();
        dayCallist = masterDataService.getDayCallList(today, yday);       
        
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
