package com.jsfcourse.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;

import com.jsf.dao.RoleDAO;
import com.jsf.dao.KlienciDAO;
import com.jsf.dao.PracownicyDAO;
import com.jsf.dao.SamochodyDAO;
import com.jsf.dao.WypozyczenieDAO;
import com.jsf.entities.Samochody;
import com.jsf.entities.Wypozyczenie;
import com.jsf.entities.Klienci;
import com.jsf.entities.Pracownicy;
import com.jsf.entities.Role;

@Named
@RequestScoped
public class RentListBB {
    private static final String PAGE_RENT_EDIT = "rentEdit?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;

    private String amount;
    private String kwota;
    private Klienci client;
    private Pracownicy employee;
    private Role role;

    @Inject
    ExternalContext extcontext;

    @Inject
    Flash flash;

    @EJB
    WypozyczenieDAO wypozyczenieDAO;
    
    @EJB
    SamochodyDAO samochodyDAO;
    
    @EJB
    KlienciDAO klienciDAO;
    
    @EJB
    PracownicyDAO pracownicyDAO;
    
    @EJB
    RoleDAO roleDAO;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public String getKwota() {
    	return kwota;
    }
    
    public void setKwota(String kwota) {
    	this.kwota = kwota;
    }
    
    public Klienci getClient() {
    	return client;
    }
    
    public void setClient(Klienci client) {
    	this.client = client;
    }
    
    public Pracownicy getEmployee() {
    	return employee;
    }
    
    public void setEmployee(Pracownicy employee) {
    	this.employee = employee;
    }
    
    public Role getRole() {
    	return role;
    }
    
    public void setRole(Role role) {
    	this.role = role;
    }

    public List<Wypozyczenie> getFullList() {
        return wypozyczenieDAO.getFullList();
    }

    public List<Samochody> carList(){
    	return samochodyDAO.getFullList();
    }
    
    public List<Klienci> clientList(){
    	return klienciDAO.getFullList();
    }
    
    public List<Pracownicy> employeeList(){
    	return pracownicyDAO.getFullList();
    }
    
    public List<Role> roleList(){
    	return roleDAO.getFullList();
    }
    
    public Role getRolebyId(Integer id) {
    	return roleDAO.find(id);
    }
    
    public List<Wypozyczenie> getList() {
        List<Wypozyczenie> list = null;

        // 1. Prepare search params
        Map<String, Object> searchParams = new HashMap<String, Object>();

        if (kwota != null && kwota.length() > 0) {
            searchParams.put("kwota", kwota);
        }

        // 2. Get list
        list = wypozyczenieDAO.getList(searchParams);

        return list;
    }
    

    public String newRent() {
        Wypozyczenie wypozyczenie = new Wypozyczenie();

        // 1. Pass object through flash
        flash.put("wypozyczenie", wypozyczenie);

        return PAGE_RENT_EDIT;
    }
    
    public String newRent(Samochody samochody) {
        Wypozyczenie wypozyczenie = new Wypozyczenie();

        wypozyczenie.setSamochody(samochody);
        //wypozyczenie.setKwota(kwota);
        
        // 1. Pass object through flash
        flash.put("wypozyczenie", wypozyczenie);

        return PAGE_RENT_EDIT;
    }

    public String editRent(Wypozyczenie wypozyczenie) {
        // 1. Pass object through flash
        flash.put("wypozyczenie", wypozyczenie);

        return PAGE_RENT_EDIT;
    }

    public String deleteRent(Wypozyczenie wypozyczenie) {
        wypozyczenieDAO.remove(wypozyczenie);
        return PAGE_STAY_AT_THE_SAME;
    }
    
   public Role getRoleById(Integer id) {
	   return roleDAO.find(id);
   }
}
