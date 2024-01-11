package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Samochody;

@Stateless
public class SamochodyDAO {
    private final static String UNIT_NAME = "jsfcourse-simplePU";

    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public void create(Samochody car) {
        em.persist(car);
    }

    public Samochody merge(Samochody car) {
        return em.merge(car);
    }

    public void remove(Samochody car) {
        em.remove(em.merge(car));
    }

    public Samochody find(Integer id) {
        return em.find(Samochody.class, id);
    }

    public List<Samochody> getFullList() {
        List<Samochody> list = null;
        Query query = em.createQuery("SELECT s FROM Samochody s");
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
