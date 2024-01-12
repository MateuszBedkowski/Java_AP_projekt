package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Pracownicy;
import com.jsf.entities.Wypozyczenie;

@Stateless
public class PracownicyDAO {
    private final static String UNIT_NAME = "jsfcourse-simplePU";

    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public void create(Pracownicy employee) {
        em.persist(employee);
    }

    public Pracownicy merge(Pracownicy employee) {
        return em.merge(employee);
    }

    public void remove(Pracownicy employee) {
        em.remove(em.merge(employee));
    }

    public Pracownicy find(Integer id) {
        return em.find(Pracownicy.class, id);
    }
    
    public List<Pracownicy> getList(Map<String, Object> searchParams) {
        List<Pracownicy> list = null;
        String select = "SELECT p ";
        String from = "FROM Pracownicy p ";
        String where = "";
        String orderby = "ORDER BY p.nazwisko ASC";

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

    public List<Pracownicy> getFullList() {
        List<Pracownicy> list = null;
        Query query = em.createQuery("SELECT p FROM Pracownicy p");
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
