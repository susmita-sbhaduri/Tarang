/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package org.bhaduri.tarang.callvalidation;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.bhaduri.tarang.DTO.ValidateCall;
import org.bhaduri.tarang.services.MasterDataServices;

/**
 *
 * @author sb
 */
@Named(value = "validationPerScrip")
@ViewScoped
public class ValidationPerScrip implements Serializable {
    private String selectedScrip;
    private String scripName;
    List<ValidateCall> callsperscrip;
    /**
     * Creates a new instance of ValidationPerScrip
     */
    public ValidationPerScrip() {
    }
    public void fillValues() throws NamingException {
        MasterDataServices masterDataService = new MasterDataServices();        
        callsperscrip = masterDataService.getCallsPerScrip(selectedScrip);
    }

    public String getSelectedScrip() {
        return selectedScrip;
    }

    public void setSelectedScrip(String selectedScrip) {
        this.selectedScrip = selectedScrip;
    }

    public String getScripName() {
        return scripName;
    }

    public void setScripName(String scripName) {
        this.scripName = scripName;
    }

    public List<ValidateCall> getCallsperscrip() {
        return callsperscrip;
    }

    public void setCallsperscrip(List<ValidateCall> callsperscrip) {
        this.callsperscrip = callsperscrip;
    }
    
}
