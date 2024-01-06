package com.jsfcourse.person;

import java.io.IOException;
import java.io.Serializable;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import com.jsf.dao.WypozyczenieDAO;
import com.jsf.entities.Samochody;
import com.jsf.entities.Wypozyczenie;

@Named
@ViewScoped
public class PersonEditBB implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String PAGE_RENT_LIST = "rentList?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;

    private Wypozyczenie wypozyczenie = new Wypozyczenie();
    private Wypozyczenie loaded = null;

    @EJB
    WypozyczenieDAO wypozyczenieDAO;

    @Inject
    FacesContext context;

    @Inject
    Flash flash;

    public Wypozyczenie getWypozyczenie() {
        return wypozyczenie;
    }

    public void onLoad() throws IOException {
        loaded = (Wypozyczenie) flash.get("wypozyczenie");

        if (loaded != null) {
            wypozyczenie = loaded;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
        }
    }
    
    public void rentCar(Wypozyczenie samochody) {
        FacesContext facesContext;
		try {
            Wypozyczenie wypozyczenie = new Wypozyczenie();
            
            
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rent created successfully!", null));
        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error creating rent", null));
        }



    public String saveData() {
        // no Wypozyczenie object passed
        if (loaded == null) {
            return PAGE_STAY_AT_THE_SAME;
        }

        try {
        	if (wypozyczenie.getIdwypozyczenie() == 0) {
                // new record
                wypozyczenieDAO.create(wypozyczenie);
            } else {
                // existing record
                wypozyczenieDAO.merge(wypozyczenie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "wystąpił błąd podczas zapisu", null));
            return PAGE_STAY_AT_THE_SAME;
        }

        return PAGE_RENT_LIST;
    }
}
