package io.javacode.taxes.entities;

import java.io.Serializable;
import java.util.Collection;

public class Entreprise implements Serializable {

    private Long code;
    private String nom;
    private String email;
    private String raisonSociale;
    private Collection<Taxe> taxes;

    public Entreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Entreprise(String nom, String email, String raisonSociale) {
        super();
        this.nom = nom;
        this.email = email;
        this.raisonSociale = raisonSociale;
    }

    //--- GETTERS ---
    public Long getCode() {
        return code;
    }
    public String getNom() {
        return nom;
    }
    public String getEmail() {
        return email;
    }
    public String getRaisonSociale() {
        return raisonSociale;
    }
    public Collection<Taxe> getTaxes() {
        return taxes;
    }

    //--- SETTERS ---
    public void setCode(Long code) {
        this.code = code;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
    public void setTaxes(Collection<Taxe> taxes) {
        this.taxes = taxes;
    }

}
