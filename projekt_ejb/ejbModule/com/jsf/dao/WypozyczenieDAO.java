package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Wypozyczenie;

@Stateless
public class WypozyczenieDAO {
    private final static String UNIT_NAME = "jsfcourse-simplePU";

    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public void create(Wypozyczenie wypozyczenie) {
        em.persist(wypozyczenie);
    }

    public Wypozyczenie merge(Wypozyczenie wypozyczenie) {
        return em.merge(wypozyczenie);
    }

    public void remove(Wypozyczenie wypozyczenie) {
        em.remove(em.merge(wypozyczenie));
    }

    public Wypozyczenie find(Integer id) {
        return em.find(Wypozyczenie.class, id);
    }

    public List<Wypozyczenie> getFullList() {
        List<Wypozyczenie> list = null;
        Query query = em.createQuery("SELECT w FROM Wypozyczenie w");
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Wypozyczenie> getList(Map<String, Object> searchParams) {
        List<Wypozyczenie> list = null;
        String select = "SELECT w ";
        String from = "FROM Wypozyczenie w ";
        String where = "";
        String orderby = "ORDER BY w.kwota ASC";

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
    
    //Do poprawy!!!
    public List<Wypozyczenie> getAmountList(Map<String, Object> searchParams) {
        List<Wypozyczenie> list = null;
        String select = "SELECT w ";
        String from = "FROM Wypozyczenie w ";
        String where = "WHERE kwota LIKE w.kwota ";
        String orderby = "ORDER BY w.poczatek ASC";

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
}
