package com.iset.serviceoffreemploi.dao;

import com.iset.serviceoffreemploi.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OffreRepository extends JpaRepository<Offre, Long> {

}