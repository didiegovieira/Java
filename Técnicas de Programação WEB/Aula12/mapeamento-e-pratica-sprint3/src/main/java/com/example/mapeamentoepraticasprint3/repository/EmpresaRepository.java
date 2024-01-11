package com.example.mapeamentoepraticasprint3.repository;

import com.example.mapeamentoepraticasprint3.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    Empresa findByNome(String nome);

    Empresa findByCnpj(String cnpj);

    Empresa findByEndereco(String endereco);

    Empresa findByTelefone(String telefone);

    Empresa findByEmail(String email);

    Empresa save(Empresa empresa);

    void delete(Empresa empresa);

    void deleteById(Integer id);

    Optional<Empresa> findById(Integer id);
}
