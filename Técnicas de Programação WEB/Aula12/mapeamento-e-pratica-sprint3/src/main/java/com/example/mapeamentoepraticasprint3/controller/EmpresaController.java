package com.example.mapeamentoepraticasprint3.controller;

import com.example.mapeamentoepraticasprint3.dto.empresa.EmpresaJogoDto;
import com.example.mapeamentoepraticasprint3.dto.empresa.mapper.EmpresaMapper;
import com.example.mapeamentoepraticasprint3.entity.Empresa;
import com.example.mapeamentoepraticasprint3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    private EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<EmpresaJogoDto>> findAll(){
        List<EmpresaJogoDto> all = empresaService.findAll();

        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all);
    }
    //findByid
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Empresa>> findById(@RequestParam Integer id){
        Optional<Empresa> empresaResponse = empresaService.findById(id);

        if (empresaResponse.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresaResponse);
    }

    @GetMapping("/nome")
    public ResponseEntity<Empresa> findByNome(@RequestParam String nome){
        Empresa empresa = empresaService.findByNome(nome);

        if (empresa == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/cnpj")
    public ResponseEntity<Empresa> findByCnpj(@RequestParam String cnpj){
        Empresa empresa = empresaService.findByCnpj(cnpj);

        if (empresa == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/endereco")
    public ResponseEntity<Empresa> findByEndereco(@RequestParam String endereco){
        Empresa empresa = empresaService.findByEndereco(endereco);

        if (empresa == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/telefone")
    public ResponseEntity<Empresa> findByTelefone(@RequestParam String telefone){
        Empresa empresa = empresaService.findByTelefone(telefone);

        if (empresa == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/email")
    public ResponseEntity<Empresa> findByEmail(@RequestParam String email){
        Empresa empresaResponse = empresaService.findByEmail(email);

        if (empresaResponse == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<Empresa> save(@RequestParam Empresa empresa){
        Empresa empresaResponse = empresaService.save(empresa);

        if (empresaResponse == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Empresa> delete(@RequestParam Empresa empresa){
        return empresaService.delete(empresa)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Empresa> deleteById(@PathVariable Integer id){
        return empresaService.deleteById(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

}
