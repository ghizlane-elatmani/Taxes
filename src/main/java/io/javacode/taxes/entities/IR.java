package io.javacode.taxes.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("IR")
public class IR extends Taxe {

    public IR() {
        super();
        // TODO Auto-generated constructor stub
    }

    public IR(String titre, Date dateTaxe, double montant, Entreprise entreprise) {
        super(titre, dateTaxe, montant, entreprise);
    }

}
