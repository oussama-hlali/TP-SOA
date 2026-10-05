package com.iset.serviceoffreemploi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.serviceoffreemploi.entities.Offre;

public interface OffreRepository extends JpaRepository<Offre, Long> {

}