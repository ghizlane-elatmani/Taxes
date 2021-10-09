package io.javacode.taxes.web;

import io.javacode.taxes.dao.EntrepriseRepository;
import io.javacode.taxes.entities.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaxeRestController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @RequestMapping("/listEntreprises")
    public Page<Entreprise> list(
            @RequestParam(name = "motCle", defaultValue = "") String motCle,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "4") int size){
        return entrepriseRepository.chercher("%"+motCle+"%", PageRequest.of(page, size));
    }

}
