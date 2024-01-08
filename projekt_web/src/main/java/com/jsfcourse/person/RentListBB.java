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

import com.jsf.dao.WypozyczenieDAO;
import com.jsf.entities.Samochody;
import com.jsf.entities.Wypozyczenie;

@Named
@RequestScoped
public class RentListBB {
    private static final String PAGE_RENT_EDIT = "rentEdit?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;

    private String amount;
    private String kwota;

    @Inject
    ExternalContext extcontext;

    @Inject
    Flash flash;

    @EJB
    WypozyczenieDAO wypozyczenieDAO;

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

    public List<Wypozyczenie> getFullList() {
        return wypozyczenieDAO.getFullList();
    }

    public List<Wypozyczenie> getList() {
        List<Wypozyczenie> list = null;

        // 1. Prepare search params
        Map<String, Object> searchParams = new HashMap<String, Object>();

        if (amount != null && amount.length() > 0) {
            searchParams.put("amount", amount);
        }

        // 2. Get list
        list = wypozyczenieDAO.getList(searchParams);

        return list;
    }
    
    //Do poprawy
    public List<Wypozyczenie> getAmountList(String kwota){
    	List<Wypozyczenie> list = null;
    	
    	Map<String, Object> searchParams = new HashMap<String, Object>();
    	
    	if(kwota != null && kwota.length() > 0) {
    		searchParams.put("kwota", amount);
    	}
    	
    	
    	return list;
    }

    public String newRent() {
        Wypozyczenie wypozyczenie = new Wypozyczenie();

        // 1. Pass object through flash
        flash.put("wypozyczenie", wypozyczenie);

        return PAGE_RENT_EDIT;
    }
    
    public String newRent(Samochody samochody, Integer kwota) {
        Wypozyczenie wypozyczenie = new Wypozyczenie();

        wypozyczenie.setSamochody(samochody);
        wypozyczenie.setKwota(kwota);
        
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
}
