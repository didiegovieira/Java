package com.example.mapeamentoepraticasprint3.service;

import com.example.mapeamentoepraticasprint3.dto.empresa.EmpresaJogoDto;
import com.example.mapeamentoepraticasprint3.dto.empresa.mapper.EmpresaMapper;
import com.example.mapeamentoepraticasprint3.entity.Empresa;
import com.example.mapeamentoepraticasprint3.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaJogoDto> findAll(){
        List<Empresa> all = empresaRepository.findAll();
        List<EmpresaJogoDto> empresaJogoDtos = all.stream()
                .map(EmpresaMapper::toEmpresaJogoDto)
                .toList();
        return empresaJogoDtos;
    }

    public Empresa findByNome(String nome){
        return empresaRepository.findByNome(nome);
    }

    public Empresa findByCnpj(String cnpj){
        return empresaRepository.findByCnpj(cnpj);
    }

    public Empresa findByEndereco(String endereco){
        return empresaRepository.findByEndereco(endereco);
    }

    public Empresa findByTelefone(String telefone){
        return empresaRepository.findByTelefone(telefone);
    }

    public Empresa findByEmail(String email){
        return empresaRepository.findByEmail(email);
    }

    public Empresa save(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public boolean delete(Empresa empresa){
        empresaRepository.delete(empresa);
        return empresaRepository.findById(empresa.getId()).isEmpty();
    }

    public boolean deleteById(Integer id){
        empresaRepository.deleteById(id);
        return empresaRepository.findById(id).isEmpty();
    }

    public Optional<Empresa> findById(Integer id){
        return empresaRepository.findById(id);
    }
}
