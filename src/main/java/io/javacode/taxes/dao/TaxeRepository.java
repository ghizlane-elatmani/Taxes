package io.javacode.taxes.dao;

import io.javacode.taxes.entities.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxeRepository extends JpaRepository<Taxe, Long> {
}
