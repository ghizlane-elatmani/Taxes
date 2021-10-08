package io.javacode.taxes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Entreprise implements Serializable {

    @Id
    @GeneratedValue
    private Long code;
    @NotNull
    @Size(min = 2, max = 20)
    private String nom;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 2, max = 30)
    private String raisonSociale;
    @OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
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
    @JsonIgnore
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
