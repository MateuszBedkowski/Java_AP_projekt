package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Klienci;
import com.jsf.entities.Wypozyczenie;

@Stateless
public class KlienciDAO {
    private final static String UNIT_NAME = "jsfcourse-simplePU";

    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public void create(Klienci client) {
        em.persist(client);
    }

    public Klienci merge(Klienci client) {
        return em.merge(client);
    }

    public void remove(Klienci client) {
        em.remove(em.merge(client));
    }

    public Klienci find(Integer id) {
        return em.find(Klienci.class, id);
    }
    
    public List<Klienci> getList(Map<String, Object> searchParams) {
        List<Klienci> list = null;
        String select = "SELECT k ";
        String from = "FROM Klienci k ";
        String where = "";
        String orderby = "ORDER BY k.nazwisko ASC";

        // Add conditions based on searchParams...

        Query query = em.createQuery(select + from + where + orderby);

        // Set parameters...

        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Klienci> getFullList() {
        List<Klienci> list = null;
        Query query = em.createQuery("SELECT k FROM Klienci k");
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}