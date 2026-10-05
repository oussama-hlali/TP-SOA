package com.iset.serviceoffreemploi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iset.serviceoffreemploi.entities.Offre;
import com.iset.serviceoffreemploi.dao.OffreRepository;

public class RestOffre {
    @RestController
    @RequestMapping("/Offres")
    public static class RestOffres {

        @Autowired
        OffreRepository offreRepository;


        @GetMapping
        public List<Offre> getAll() {
            return offreRepository.findAll();
        }


        @GetMapping("/{uid}")
        public Offre getbyid(@PathVariable Long uid) {
            return offreRepository.findById(uid).get();
        }


        @PostMapping
        public Offre saveoffre(@RequestBody Offre newoffre) {
            return offreRepository.save(newoffre);
        }


        @PutMapping("/{id}")
        public Offre updateoffre(
                @PathVariable Long id,
                @RequestBody Offre offre) {

            Offre ancienneOffre = offreRepository.findById(id).get();

            ancienneOffre.setIntitulé(offre.getIntitulé());
            ancienneOffre.setSpecialité(offre.getSpecialité());
            ancienneOffre.setSociété(offre.getSociété());
            ancienneOffre.setNbpostes(offre.getNbpostes());
            ancienneOffre.setPays(offre.getPays());

            return offreRepository.save(ancienneOffre);
        }


        @DeleteMapping("/{id}")
        public void deleteoffre(@PathVariable Long id) {
            offreRepository.deleteById(id);
        }
    }
}
