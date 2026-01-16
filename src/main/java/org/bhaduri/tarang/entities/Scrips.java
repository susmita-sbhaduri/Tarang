/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bhaduri.tarang.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author sb
 */
@Entity
@Table(name = "scrips")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scrips.findAll", query = "SELECT s FROM Scrips s"),
    @NamedQuery(name = "Scrips.findByScripid", query = "SELECT s FROM Scrips s WHERE s.scripid = :scripid"),
    @NamedQuery(name = "Scrips.findByScripname", query = "SELECT s FROM Scrips s WHERE s.scripname = :scripname")})
public class Scrips implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "scripid")
    private String scripid;
    @Size(max = 100)
    @Column(name = "scripname")
    private String scripname;

    public Scrips() {
    }

    public Scrips(String scripid) {
        this.scripid = scripid;
    }

    public String getScripid() {
        return scripid;
    }

    public void setScripid(String scripid) {
        this.scripid = scripid;
    }

    public String getScripname() {
        return scripname;
    }

    public void setScripname(String scripname) {
        this.scripname = scripname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scripid != null ? scripid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scrips)) {
            return false;
        }
        Scrips other = (Scrips) object;
        if ((this.scripid == null && other.scripid != null) || (this.scripid != null && !this.scripid.equals(other.scripid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bhaduri.tarang.entities.Scrips[ scripid=" + scripid + " ]";
    }
    
}
