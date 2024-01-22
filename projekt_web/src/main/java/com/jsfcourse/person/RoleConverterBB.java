package com.jsfcourse.person;

import java.io.IOException;
import java.io.Serializable;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.enterprise.inject.Any;

import com.jsf.dao.RoleDAO;
import com.jsf.dao.SamochodyDAO;
import com.jsf.dao.KlienciDAO;
import com.jsf.dao.PracownicyDAO;
import com.jsf.dao.WypozyczenieDAO;
import com.jsf.entities.Samochody;
import com.jsf.entities.Wypozyczenie;
import com.jsf.entities.Klienci;
import com.jsf.entities.Pracownicy;
import com.jsf.entities.Role;


@FacesConverter("roleConverter")
@Any
public class RoleConverterBB implements Serializable,Converter {
    private static final long serialVersionUID = 1L;


    @EJB
	RoleDAO roleDAO;
	
	@Inject
	FacesContext context;

	@Inject
	Flash flash;
	
	private Role role = new Role();
    private Role roleLoaded = null;
    
    public void roleOnLoad() throws IOException {
        roleLoaded = (Role) flash.get("role");

        if (roleLoaded != null) {
            role = roleLoaded;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne użycie systemu", null));
        }
    }

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {

        	if (value == null || value.isEmpty()) {
                return null;
            }
        	
        	if(roleDAO == null)
        		return null;

            try {
                // Use your service or DAO to find the Role based on the given value
                // For simplicity, assuming that the value represents the ID of the role
                Integer roleId = Integer.parseInt(value);
                // Replace the next line with your service or DAO call
                RentListBB list = new RentListBB();
                
//                Role role = roleDAO.find(roleId);
                Role role = list.getRolebyId(roleId);
                
                return role;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid value: " + value, e);
            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value == null || !(value instanceof Role)) {
                return null;
            }

            // Convert Role object to a string representation
            // For simplicity, using the ID of the role
            Integer roleId = ((Role) value).getIdrola();
            return (roleId != null) ? roleId.toString() : null;
        }
    }
