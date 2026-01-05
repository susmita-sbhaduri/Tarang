/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bhaduri.tarang.DTO;

import java.io.Serializable;

/**
 *
 * @author sb
 */
public class ValidationSummary implements Serializable {
    private String heading;
    private String callOneCount;
    private String callOnePercent;
    private String callTwoCount;
    private String callTwoPercent;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getCallOneCount() {
        return callOneCount;
    }

    public void setCallOneCount(String callOneCount) {
        this.callOneCount = callOneCount;
    }

    public String getCallOnePercent() {
        return callOnePercent;
    }

    public void setCallOnePercent(String callOnePercent) {
        this.callOnePercent = callOnePercent;
    }

    public String getCallTwoCount() {
        return callTwoCount;
    }

    public void setCallTwoCount(String callTwoCount) {
        this.callTwoCount = callTwoCount;
    }

    public String getCallTwoPercent() {
        return callTwoPercent;
    }

    public void setCallTwoPercent(String callTwoPercent) {
        this.callTwoPercent = callTwoPercent;
    }
    
}
