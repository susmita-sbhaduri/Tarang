/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package org.bhaduri.tarang.callvalidation;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.bhaduri.tarang.services.MasterDataServices;

/**
 *
 * @author sb
 */
@Named(value = "scripList")
@ViewScoped
public class ScripList implements Serializable {
    private String selectedScrip;
    List<String> scriplist;
    /**
     * Creates a new instance of ScripList
     */
    public ScripList() {
    }
    public void fillScripValues() throws NamingException {
        MasterDataServices masterDataService = new MasterDataServices();
        scriplist = masterDataService.getCallScripIdList();
        
    }
    
    public String goToScripDetails() {        
        String redirectUrl = "/secured/validationsummary?faces-redirect=true&selectedScrip="+ selectedScrip;
        return redirectUrl;
//        return "/secured/userhome";
    }
    public String getSelectedScrip() {
        return selectedScrip;
    }

    public void setSelectedScrip(String selectedScrip) {
        this.selectedScrip = selectedScrip;
    }

    public List<String> getScriplist() {
        return scriplist;
    }

    public void setScriplist(List<String> scriplist) {
        this.scriplist = scriplist;
    }
    
}
