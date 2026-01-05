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
public class CallTable implements Serializable {
    private String scripId;
    private String callVersionOne;
    private String callVersionTwo;
    private String callVersionThree;    
    private Double retraceVersionOne;
    private Double retraceVersionTwo;
    private Date callGenerationTimeStamp;
    private Double callGenerationPrice;

    public String getScripId() {
        return scripId;
    }

    public void setScripId(String scripId) {
        this.scripId = scripId;
    }

    public String getCallVersionOne() {
        return callVersionOne;
    }

    public void setCallVersionOne(String callVersionOne) {
        this.callVersionOne = callVersionOne;
    }

    public String getCallVersionTwo() {
        return callVersionTwo;
    }

    public void setCallVersionTwo(String callVersionTwo) {
        this.callVersionTwo = callVersionTwo;
    }

    public String getCallVersionThree() {
        return callVersionThree;
    }

    public void setCallVersionThree(String callVersionThree) {
        this.callVersionThree = callVersionThree;
    }

    public Double getRetraceVersionOne() {
        return retraceVersionOne;
    }

    public void setRetraceVersionOne(Double retraceVersionOne) {
        this.retraceVersionOne = retraceVersionOne;
    }

    public Double getRetraceVersionTwo() {
        return retraceVersionTwo;
    }

    public void setRetraceVersionTwo(Double retraceVersionTwo) {
        this.retraceVersionTwo = retraceVersionTwo;
    }

    public Date getCallGenerationTimeStamp() {
        return callGenerationTimeStamp;
    }

    public void setCallGenerationTimeStamp(Date callGenerationTimeStamp) {
        this.callGenerationTimeStamp = callGenerationTimeStamp;
    }

    public Double getCallGenerationPrice() {
        return callGenerationPrice;
    }

    public void setCallGenerationPrice(Double callGenerationPrice) {
        this.callGenerationPrice = callGenerationPrice;
    }
    
    
}
