/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bhaduri.tarang.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sb
 */
public class ValidateCall implements Serializable {
    private String scripId;
    private Date callGenerationTimeStamp;
    private String callOne;
    private String callTwo;  
    private String outcomeOne;
    private String outcomeTwo;  
    private Double price;
    private Double actualPriceOne;    
    private Double actualPriceTwo;

    public String getScripId() {
        return scripId;
    }

    public void setScripId(String scripId) {
        this.scripId = scripId;
    }

    public Date getCallGenerationTimeStamp() {
        return callGenerationTimeStamp;
    }

    public void setCallGenerationTimeStamp(Date callGenerationTimeStamp) {
        this.callGenerationTimeStamp = callGenerationTimeStamp;
    }

    public String getCallOne() {
        return callOne;
    }

    public void setCallOne(String callOne) {
        this.callOne = callOne;
    }

    public String getCallTwo() {
        return callTwo;
    }

    public void setCallTwo(String callTwo) {
        this.callTwo = callTwo;
    }

    public String getOutcomeOne() {
        return outcomeOne;
    }

    public void setOutcomeOne(String outcomeOne) {
        this.outcomeOne = outcomeOne;
    }

    public String getOutcomeTwo() {
        return outcomeTwo;
    }

    public void setOutcomeTwo(String outcomeTwo) {
        this.outcomeTwo = outcomeTwo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getActualPriceOne() {
        return actualPriceOne;
    }

    public void setActualPriceOne(Double actualPriceOne) {
        this.actualPriceOne = actualPriceOne;
    }

    public Double getActualPriceTwo() {
        return actualPriceTwo;
    }

    public void setActualPriceTwo(Double actualPriceTwo) {
        this.actualPriceTwo = actualPriceTwo;
    }
    
    
    
}
