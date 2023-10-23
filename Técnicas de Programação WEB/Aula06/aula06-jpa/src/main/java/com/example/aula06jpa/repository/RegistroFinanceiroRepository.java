package com.example.aula06jpa.repository;

import com.example.aula06jpa.entity.RegistroFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroFinanceiroRepository extends JpaRepository<RegistroFinanceiro, Integer> {

}
