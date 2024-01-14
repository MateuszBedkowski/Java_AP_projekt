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

import com.jsf.dao.SamochodyDAO;
import com.jsf.dao.KlienciDAO;
import com.jsf.dao.PracownicyDAO;
import com.jsf.dao.WypozyczenieDAO;
import com.jsf.entities.Samochody;
import com.jsf.entities.Wypozyczenie;
import com.jsf.entities.Klienci;
import com.jsf.entities.Pracownicy;

@Named
@ViewScoped
public class RentEditBB implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String PAGE_RENT_LIST = "rentList?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;

    private Wypozyczenie wypozyczenie = new Wypozyczenie();
    private Wypozyczenie wypozyczenieLoaded = null;
    
    private Samochody car = new Samochody();
    private Samochody carLoaded = null;
    
    private Klienci client = new Klienci();
    private Klienci clientLoaded = null;
    
    private Pracownicy employee = new Pracownicy();
    private Pracownicy employeeLoaded = null;

    @EJB
    WypozyczenieDAO wypozyczenieDAO;
    
    @EJB
    KlienciDAO klienciDAO;
    
    @EJB
    SamochodyDAO samochodyDAO;
    
    @EJB
    PracownicyDAO pracownicyDAO;

    @Inject
    FacesContext context;

    @Inject
    Flash flash;

	private FacesContext facesContext;

    public Wypozyczenie getWypozyczenie() {
        return wypozyczenie;
    }
    
    public Samochody getSamochody() {
    	return car;
    }
    
    public Klienci getKlienci() {
    	return client;
    }
    
    public Pracownicy getPracownicy() {
    	return employee;
    }
    
//Wypozyczenie
    public void rentOnLoad() throws IOException {
        wypozyczenieLoaded = (Wypozyczenie) flash.get("wypozyczenie");

        if (wypozyczenieLoaded != null) {
            wypozyczenie = wypozyczenieLoaded;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
        }
    }
    

    public String rentSaveData() {
        // no Wypozyczenie object passed
        if (wypozyczenieLoaded == null) {
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
    
//Samochody
    public void carOnLoad() throws IOException {
        carLoaded = (Samochody) flash.get("samochod");

        if (carLoaded != null) {
            car = carLoaded;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
        }
    }
    

    public String carSaveData() {
        // no Wypozyczenie object passed
        if (carLoaded == null) {
            return PAGE_STAY_AT_THE_SAME;
        }

        try {
        	if (car.getIdsamochod() == 0) {
                // new record
                samochodyDAO.create(car);
            } else {
                // existing record
                samochodyDAO.merge(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "wystąpił błąd podczas zapisu", null));
            return PAGE_STAY_AT_THE_SAME;
        }

        return PAGE_RENT_LIST;
    }
    

//Klienci
    public void clientOnLoad() throws IOException {
        clientLoaded = (Klienci) flash.get("klienci");

        if (clientLoaded != null) {
            client = clientLoaded;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
        }
    }
    

    public String clientSaveData() {
        // no Wypozyczenie object passed
        if (clientLoaded == null) {
            return PAGE_STAY_AT_THE_SAME;
        }

        try {
        	if (client.getIdklient() == 0) {
                // new record
                klienciDAO.create(client);
            } else {
                // existing record
                klienciDAO.merge(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "wystąpił błąd podczas zapisu", null));
            return PAGE_STAY_AT_THE_SAME;
        }

        return PAGE_RENT_LIST;
    }
    
    
//Pracownicy
    public void employeeOnLoad() throws IOException {
        employeeLoaded = (Pracownicy) flash.get("pracownicy");

        if (employeeLoaded != null) {
            employee= employeeLoaded;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
        }
    }
    

    public String employeeSaveData() {
        // no Wypozyczenie object passed
        if (employeeLoaded == null) {
            return PAGE_STAY_AT_THE_SAME;
        }

        try {
        	if (employee.getIdpracownik() == null) {
                // new record
                pracownicyDAO.create(employee);
            } else {
                // existing record
                pracownicyDAO.merge(employee);
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
