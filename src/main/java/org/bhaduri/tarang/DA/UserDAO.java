/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bhaduri.tarang.DA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.UserTransaction;
import jakarta.persistence.TypedQuery;

import org.bhaduri.tarang.JPA.UsersJpaController;
import org.bhaduri.tarang.entities.Users;
/**
 *
 * @author sb
 */
public class UserDAO extends UsersJpaController{
    public UserDAO(UserTransaction utx, EntityManagerFactory emf) {
        super(utx, emf);
    }
    public Users getUserDetails(String username, String password) {
        System.out.println("Attempting to get EntityManager...");
        EntityManager em = getEntityManager();
        TypedQuery<Users> query = em.createNamedQuery("Users.getUserDetails", Users.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        Users userdetails = query.getSingleResult();
        return userdetails;
    }
}
