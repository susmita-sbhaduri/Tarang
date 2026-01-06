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
import org.bhaduri.tarang.JPA.ValidatecallJpaController;
import org.bhaduri.tarang.entities.Validatecall;

/**
 *
 * @author sb
 */
public class ValidatecallDAO extends ValidatecallJpaController{
    public ValidatecallDAO(UserTransaction utx, EntityManagerFactory emf) {
        super(utx, emf);
    }
    public List<Validatecall> listCallsForScripid(String scripid) {
        EntityManager em = getEntityManager();
        TypedQuery<Validatecall> query = em.createNamedQuery("Validatecall.listCallsForScripid", Validatecall.class);
        query.setParameter("scripid", scripid);
        List<Validatecall> listofcropcat = query.getResultList();
        return listofcropcat;
    }
}
