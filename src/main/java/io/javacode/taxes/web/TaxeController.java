package io.javacode.taxes.web;

import io.javacode.taxes.dao.EntrepriseRepository;
import io.javacode.taxes.dao.TaxeRepository;
import io.javacode.taxes.entities.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaxeController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private TaxeRepository taxeRepository;

    @RequestMapping(value = "/entreprises", method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name="motCle", defaultValue="") String motCle,
                        @RequestParam(name="page", defaultValue="0") int page,
                        @RequestParam(name="size", defaultValue="4") int size){

        Page<Entreprise> entreprisesPage = entrepriseRepository
                .chercher("%"+motCle+"%", PageRequest.of(page, size));
        model.addAttribute("entrepriseList", entreprisesPage.getContent());

        int[] pages = new int[entreprisesPage.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", page);
        model.addAttribute("motCle", motCle);
        return "entreprises";
    }

    @RequestMapping(value = "/formEntreprise")
    public String formEntreprise(Model model){
        model.addAttribute("entreprise", new Entreprise());
        return "formEntreprise";
    }

    @RequestMapping(value = "/saveEntreprise")
    public String saveEntreprise(Model model, @Valid Entreprise e, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "formEntreprise";

        entrepriseRepository.save(e);
        return "redirect:/entreprises";
    }

    @RequestMapping(value = "/taxes")
    public String taxes(Model model, Long code){
        Entreprise e = new Entreprise();
        e.setCode(code);
        model.addAttribute("entreprises", entrepriseRepository.findAll());
        model.addAttribute("taxes", taxeRepository.findByEntreprise(e));
        return "taxes";
    }

}
