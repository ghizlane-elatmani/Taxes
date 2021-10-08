package io.javacode.taxes.web;

import io.javacode.taxes.dao.EntrepriseRepository;
import io.javacode.taxes.entities.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaxeRestController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @RequestMapping("/listEntreprises")
    public List<Entreprise> list(){
        return entrepriseRepository.findAll();
    }

}
