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
import org.bhaduri.tarang.JPA.CalltableJpaController;
import java.sql.Timestamp;
import java.util.Date;
import org.bhaduri.tarang.entities.Calltable;

/**
 *
 * @author sb
 */
public class CalltableDAO extends CalltableJpaController{
    public CalltableDAO(UserTransaction utx, EntityManagerFactory emf) {
        super(utx, emf);
    }
    
    public List<Date> listIntradayDates(Date dateinput) {
        EntityManager em = getEntityManager();
        TypedQuery<Date> query = em.createNamedQuery("Calltable.listIntradayDates", Date.class);
        query.setParameter("cutoffdate", dateinput);
        return query.getResultList();
    }
    
    
    public List<Calltable> listIntradayCalls(Date dateinput) {
        EntityManager em = getEntityManager();
        TypedQuery<Calltable> query = em.createNamedQuery("Calltable.listIntradayCalls", Calltable.class);
        query.setParameter("lastupdateminute", dateinput);
        return query.getResultList();
    }

}
