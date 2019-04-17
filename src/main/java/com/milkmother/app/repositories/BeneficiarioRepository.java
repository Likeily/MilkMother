package com.milkmother.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milkmother.app.domain.Beneficiarios;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiarios, Integer>{

}
