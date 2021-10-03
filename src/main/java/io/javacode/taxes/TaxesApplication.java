package io.javacode.taxes;

import io.javacode.taxes.dao.EntrepriseRepository;
import io.javacode.taxes.dao.TaxeRepository;
import io.javacode.taxes.entities.Entreprise;
import io.javacode.taxes.entities.IR;
import io.javacode.taxes.entities.TVA;
import io.javacode.taxes.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TaxesApplication implements CommandLineRunner {

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxeRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaxesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Entreprise e1 = entrepriseRepository
				.save(new Entreprise("R1", "r1@gmail.com", "SARL"));

		Entreprise e2 = entrepriseRepository
				.save(new Entreprise("R2", "r2@gmail.com", "SARL"));

		taxeRepository.save(new TVA("TVA Habitation", new Date(), 900, e1));
		taxeRepository.save(new TVA("TVA Voiture", new Date(), 400, e1));
		taxeRepository.save(new IR("IR 2016", new Date(), 4500, e1));
		taxeRepository.save(new TVA("TVA Habitation", new Date(), 4000, e2));
	}
}
