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
//import org.bhaduri.tarang.DTO.ScripDTO;
//import org.bhaduri.tarang.services.MasterDataServices;
import org.bhaduri.tarangdbservice.services.MasterDataServices;
import org.bhaduri.tarangdto.ScripsDTO;
import org.bhaduri.tarangcall.scrips.Scrips;

/**
 *
 * @author sb
 */
@Named(value = "scripList")
@ViewScoped
public class ScripList implements Serializable {
    private ScripsDTO selectedScrip;
    List<ScripsDTO> scriplist;
    /**
     * Creates a new instance of ScripList
     */
    public ScripList() {
    }
    public void fillScripValues() throws NamingException {
        MasterDataServices masterDataService = new MasterDataServices();
//        scriplist = masterDataService.getCallScripIdList();
        scriplist = new Scrips().getScripList();
    }
    
    public String goToScripDetails() {        
        String redirectUrl = "/secured/validationsummary?faces-redirect=true&selectedScrip="+ 
                selectedScrip.getScripId() + "&scripName=" + selectedScrip.getScripName();
        return redirectUrl;
//        return "/secured/userhome";
    }

    public ScripsDTO getSelectedScrip() {
        return selectedScrip;
    }

    public void setSelectedScrip(ScripsDTO selectedScrip) {
        this.selectedScrip = selectedScrip;
    }

    public List<ScripsDTO> getScriplist() {
        return scriplist;
    }

    public void setScriplist(List<ScripsDTO> scriplist) {
        this.scriplist = scriplist;
    }

    
    
    
}
