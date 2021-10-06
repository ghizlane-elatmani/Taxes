package io.javacode.taxes.dao;

import io.javacode.taxes.entities.Entreprise;
import io.javacode.taxes.entities.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaxeRepository extends JpaRepository<Taxe, Long> {

    public List<Taxe> findByEntreprise(Entreprise e);

}
