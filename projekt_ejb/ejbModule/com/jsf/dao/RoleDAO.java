package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Klienci;
import com.jsf.entities.Wypozyczenie;
import com.jsf.entities.Samochody;
import com.jsf.entities.Pracownicy;
import com.jsf.entities.Role;

@Stateless
public class RoleDAO {
    private final static String UNIT_NAME = "jsfcourse-simplePU";

    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public void create(Role role) {
        em.persist(role);
    }

    public Role  merge(Role role) {
        return em.merge(role);
    }

    public void remove(Role role) {
        em.remove(em.merge(role));
    }

    public Role find(Integer id) {
        return em.find(Role.class, id);
    }
    
    public Role findByName(String nazwa) {
    	return em.find(Role.class, nazwa);
    }
    
    public List<Role> getList(Map<String, Object> searchParams) {
        List<Role> list = null;
        String select = "SELECT r ";
        String from = "FROM Role r ";
        String where = "";
        String orderby = "ORDER BY r.nazwa ASC";

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

    public List<Role> getFullList() {
        List<Role> list = null;
        Query query = em.createQuery("SELECT r FROM Role r");
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}