package io.javacode.taxes.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING, length = 3)
public abstract class Taxe implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private Date dateTaxe;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_ENT")
    private Entreprise entreprise;

    public Taxe() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Taxe(String titre, Date dateTaxe, double montant, Entreprise entreprise) {
        this.titre = titre;
        this.dateTaxe = dateTaxe;
        this.montant = montant;
        this.entreprise = entreprise;
    }

    //--- GETTERS ---
    public Long getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public Date getDateTaxe() {
        return dateTaxe;
    }
    public double getMontant() {
        return montant;
    }
    public Entreprise getEntreprise() {
        return entreprise;
    }

    //--- SETTERS ---
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setDateTaxe(Date dateTaxe) {
        this.dateTaxe = dateTaxe;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

}
