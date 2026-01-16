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
import org.bhaduri.tarang.DTO.ScripDTO;
import org.bhaduri.tarang.services.MasterDataServices;


/**
 *
 * @author sb
 */
@Named(value = "scripList")
@ViewScoped
public class ScripList implements Serializable {
    private ScripDTO selectedScrip;
    List<ScripDTO> scriplist;
    /**
     * Creates a new instance of ScripList
     */
    public ScripList() {
    }
    public void fillScripValues() throws NamingException {
        MasterDataServices masterDataService = new MasterDataServices();
//        scriplist = masterDataService.getCallScripIdList();
        scriplist = masterDataService.getScripsList();
    }
    
    public String goToScripDetails() {        
        String redirectUrl = "/secured/validationsummary?faces-redirect=true&selectedScrip="+ 
                selectedScrip.getScripId() + "&scripName=" + selectedScrip.getScripName();
        return redirectUrl;
//        return "/secured/userhome";
    }

    public ScripDTO getSelectedScrip() {
        return selectedScrip;
    }

    public void setSelectedScrip(ScripDTO selectedScrip) {
        this.selectedScrip = selectedScrip;
    }

    public List<ScripDTO> getScriplist() {
        return scriplist;
    }

    public void setScriplist(List<ScripDTO> scriplist) {
        this.scriplist = scriplist;
    }
    
}
