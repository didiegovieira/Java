package com.example.estoque01222015diego.Controllers;

import com.example.estoque01222015diego.Entity.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    List<Produto> list = new ArrayList<>();

    @GetMapping
    public List<Produto> listar() { return list; }

    @PostMapping()
    public Produto cadastro(@RequestBody Produto produto){
        list.add(produto);
        return produto;
    }

    @PutMapping("/{indice}")
    public Produto atualizar(@PathVariable int indice, @RequestBody Produto produto){
        if (!validacao(indice)) {
            return null;
        }

        list.set(indice, produto);

        return list.get(indice);
    }

    @GetMapping("/estoque/{qtdEstoque}")
    public List<Produto> getEstoque(@PathVariable int qtdEstoque){
        List<Produto> getEstoque = new ArrayList<>();

        for (Produto p : list) {
            if (p.getQtdEstoque() > qtdEstoque) {
                getEstoque.add(p);
            }
        }

        return getEstoque;
    }

    public Boolean validacao(int indice){
        return indice >= 0 && indice < list.size();
    }
}
