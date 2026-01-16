/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package org.bhaduri.tarang.callvalidation;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;

/**
 *
 * @author sb
 */
@Named(value = "validationPerScrip")
@ViewScoped
public class ValidationPerScrip implements Serializable {
    private String selectedScrip;
    private String scripName;
    /**
     * Creates a new instance of ValidationPerScrip
     */
    public ValidationPerScrip() {
    }
    
}
