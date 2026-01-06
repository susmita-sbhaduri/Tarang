/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package org.bhaduri.tarang.callvalidation;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.bhaduri.tarang.DTO.ValidateCall;
import org.bhaduri.tarang.DTO.ValidationSummaryDTO;
import org.bhaduri.tarang.services.MasterDataServices;

/**
 *
 * @author sb
 */
@Named(value = "validationSummary")
@ViewScoped
public class ValidationSummary implements Serializable {
    private String selectedScrip;
    private List<ValidationSummaryDTO> report;
    /**
     * Creates a new instance of ValidationSummary
     */
    public ValidationSummary() {
    }
    
    public void fillValues() throws NamingException {
        MasterDataServices masterDataService = new MasterDataServices();
        report = new ArrayList<>();
        List<ValidateCall> callsperscrip = masterDataService.getCallsPerScrip(selectedScrip);
        ValidationSummaryDTO reportRecord = new ValidationSummaryDTO();
        reportRecord.setHeading("0-0.2(%)");
        String callone;
        String calltwo;
        double price;
        double diff;
        int failcountone = 0;
        int nacountone = 0;
        int rangeonecountone = 0;
        int rangetwocountone = 0;
        int rangethreecountone = 0;
        
        int failcounttwo = 0;
        int nacounttwo = 0;
        int rangeonecounttwo = 0;
        int rangetwocounttwo = 0;
        int rangethreecounttwo = 0;
        for (int i = 0; i < callsperscrip.size(); i++) {
            callone = callsperscrip.get(i).getCallOne();
            calltwo = callsperscrip.get(i).getCallTwo();
            price = callsperscrip.get(i).getPrice();
            if ((callone.equals("buy") && calltwo.equals("buy"))
                    || (callone.equals("buy") && calltwo.equals("no"))
                    || (callone.equals("no") && calltwo.equals("buy"))) {
                
                if (callone.equals("buy") && calltwo.equals("buy")) {
                    diff = Math.abs(callsperscrip.get(i).getActualPriceOne() - price);
                    if (diff == price) {
                        failcountone = failcountone + 1;
                        failcounttwo = failcounttwo + 1;
                    } else {
                        if((diff/price) <= ((0.2/100)*price)){
                            rangeonecountone = rangeonecountone+1;
                            rangeonecounttwo = rangeonecounttwo +1;
                        }
                        if((((0.2/100)*price)< (diff/price)) && 
                               ((diff/price) <= ((0.4/100)*price))){
                            rangetwocountone = rangetwocountone+1;
                            rangetwocounttwo = rangetwocounttwo+1;
                        }
                        if((diff/price) > ((0.4/100)*price)){
                            rangethreecountone = rangethreecountone+1;
                            rangethreecounttwo = rangethreecounttwo +1;
                        }
                    }
                }
                
                if (callone.equals("buy") && calltwo.equals("no")) {
                    diff = callsperscrip.get(i).getActualPriceOne() - price;
                    nacounttwo = nacounttwo + 1;
                    if (diff == price) {
                        failcounttwo = failcounttwo + 1;                        
                    } else {
                        if((diff/price) <= ((0.2/100)*price)){
                            rangeonecountone = rangeonecountone+1;
                        }
                        if((((0.2/100)*price)< (diff/price)) && 
                               ((diff/price) <= ((0.4/100)*price))){
                            rangetwocountone = rangetwocountone+1;
                        }
                        if((diff/price) > ((0.4/100)*price)){
                            rangethreecountone = rangethreecountone+1;
                        }
                    }
                }
                
                if (callone.equals("no") && calltwo.equals("buy")) {
                    diff = callsperscrip.get(i).getActualPriceTwo() - price;
                    nacountone = nacountone + 1;
                    if (diff == 0) {
                        failcountone = failcountone + 1;                        
                    } else {
                        if((diff/price) <= ((0.2/100)*price)){
                            rangeonecountone = rangeonecountone+1;
                        }
                        if((((0.2/100)*price)< (diff/price)) && 
                               ((diff/price) <= ((0.4/100)*price))){
                            rangetwocountone = rangetwocountone+1;
                        }
                        if((diff/price) > ((0.4/100)*price)){
                            rangethreecountone = rangethreecountone+1;
                        }
                    }
                }
            } // buy & buy,  buy & no,  no & buy
        }
        
    }

    public String getSelectedScrip() {
        return selectedScrip;
    }

    public void setSelectedScrip(String selectedScrip) {
        this.selectedScrip = selectedScrip;
    }

    public List<ValidationSummaryDTO> getReport() {
        return report;
    }

    public void setReport(List<ValidationSummaryDTO> report) {
        this.report = report;
    }
    
    
}
