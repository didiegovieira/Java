package com.example.aula06jpa.controller;

import com.example.aula06jpa.entity.RegistroFinanceiro;
import com.example.aula06jpa.repository.RegistroFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros")
public class RegistroFinanceiroController {

    @Autowired
    private RegistroFinanceiroRepository repository;

    private final List<RegistroFinanceiro> registroFinanceiroList = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<RegistroFinanceiro>> listar() {
        List<RegistroFinanceiro> registros = this.repository.findAll();

//        if (registroFinanceiroList.isEmpty()) {
//            return ResponseEntity.status(204).build();
//        }
//
//        return ResponseEntity.status(200).body(registroFinanceiroList);
        return ResponseEntity.status(200).body(registros);
    }

    @PostMapping
    public ResponseEntity<RegistroFinanceiro> adicionar(@RequestBody RegistroFinanceiro registro) {
        //registroFinanceiroList.add(registro);
        RegistroFinanceiro registroSalvo = this.repository.save(registro);

        //return ResponseEntity.status(201).body(registro);
        return ResponseEntity.status(201).body(registroSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroFinanceiro> listarUm(@PathVariable int id) {
//        if (validacao(indice)) {
//            return ResponseEntity.status(400).build();
//        }

        Optional<RegistroFinanceiro> registroOpt = this.repository.findById(id);

        if (registroOpt.isPresent()) {
            RegistroFinanceiro registroFinanceiro = registroOpt.get();

            return ResponseEntity.status(200).body(registroFinanceiro);
        }

        //return ResponseEntity.status(200).body(registroFinanceiroList.get(indice));

        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroFinanceiro> atualizar(@PathVariable int id, @RequestBody RegistroFinanceiro registro) {
//        if (validacao(indice)) {
//            return ResponseEntity.status(400).build();
//        }
//
//        registroFinanceiroList.set(indice, registro);
//        return ResponseEntity.status(200).body(registroFinanceiroList.get(indice));
        registro.setId(id);

        if (this.repository.existsById(id)) {
            RegistroFinanceiro registroAtualizado = this.repository.save(registro);
            return ResponseEntity.status(201).body(registroAtualizado);

        }

        return ResponseEntity.status(400).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegistroFinanceiro> delete(@PathVariable int id) {
//        if (validacao(indice)) {
//            return ResponseEntity.status(404).build();
//        }
//
//        registroFinanceiroList.remove(indice);
//        return ResponseEntity.status(204).build();
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/ganhos")
    public ResponseEntity<List<RegistroFinanceiro>> ganhos() {
//        List<RegistroFinanceiro> ganhos = new ArrayList<>();
//        for (RegistroFinanceiro re: registroFinanceiroList) {
//            if (re.getValor() > 0) {
//                ganhos.add(re);
//            }
//        }
//
//        return ganhos.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(ganhos);
        List<RegistroFinanceiro> registros = this.repository.findAll();

        List<RegistroFinanceiro> ganhos = registros.stream().filter(registro -> registro.getValor()>0).toList();

        return ganhos.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(ganhos);
    }

    @GetMapping("/despesas")
    public ResponseEntity<List<RegistroFinanceiro>> despesas() {
//        List<RegistroFinanceiro> despesas = new ArrayList<>();
//        for (RegistroFinanceiro re: registroFinanceiroList) {
//            if (re.getValor() < 0) {
//                despesas.add(re);
//            }
//        }
//
//        return despesas.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(despesas);
        List<RegistroFinanceiro> registros = this.repository.findAll();

        List<RegistroFinanceiro> ganhos = registros.stream().filter(registro -> registro.getValor()<0).toList();

        return ganhos.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(ganhos);
    }

    public boolean validacao(int indice) {
        return indice < 0 || indice > registroFinanceiroList.size();
    }
}
