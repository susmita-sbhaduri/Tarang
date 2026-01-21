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
@Named(value = "intradayCallDetails")
@ViewScoped
public class IntradayCallDetails implements Serializable {
    private String selectedTimeStr;
    private Date selectedTime;
    List<CallTable> intradayCallist;
    /**
     * Creates a new instance of IntradayCallDetails
     */
    public IntradayCallDetails() {
    }
    public void fillValues() throws NamingException, ParseException {
        MasterDataServices masterDataService = new MasterDataServices();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        selectedTime = sdf.parse(selectedTimeStr);
        intradayCallist = masterDataService.getIntraCallList(selectedTime);
    }

    public String getSelectedTimeStr() {
        return selectedTimeStr;
    }

    public void setSelectedTimeStr(String selectedTimeStr) {
        this.selectedTimeStr = selectedTimeStr;
    }

    public Date getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(Date selectedTime) {
        this.selectedTime = selectedTime;
    }

    public List<CallTable> getIntradayCallist() {
        return intradayCallist;
    }

    public void setIntradayCallist(List<CallTable> intradayCallist) {
        this.intradayCallist = intradayCallist;
    }

    
    
    
}
