/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bhaduri.tarang.DA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.UserTransaction;
import java.util.List;
import org.bhaduri.tarang.JPA.ScripsJpaController;
import org.bhaduri.tarang.entities.Scrips;

/**
 *
 * @author sb
 */
public class ScripsDA extends ScripsJpaController{
    public ScripsDA(UserTransaction utx, EntityManagerFactory emf) {
        super(utx, emf);
    }
    public List<Scrips> listScripid() {
        EntityManager em = getEntityManager();
        TypedQuery<Scrips> query = em.createNamedQuery("Scrips.listScripid", Scrips.class);
        return query.getResultList();
    }
    //    public List<Scrips> listScripid() {
//        EntityManager em = getEntityManager();
//        TypedQuery<Scrips> query = em.createNamedQuery("Calltable.listScripid", Scrips.class);
//        List<Scrips> listofcropcat = query.getResultList();
//        return listofcropcat;
//    }
    
    public Long getScripCount() {
        EntityManager em = getEntityManager();
        TypedQuery<Long> query = em.createNamedQuery("Scrips.getScripCount", Long.class);   
         
        return query.getSingleResult();
    }
}
