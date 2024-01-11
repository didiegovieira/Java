package school.sptech.marketplaceresumido.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.marketplaceresumido.controller.dto.mapper.ProdutoMapper;
import school.sptech.marketplaceresumido.entity.Produto;
import school.sptech.marketplaceresumido.service.produto.ProdutoService;
import school.sptech.marketplaceresumido.controller.dto.ProdutoAtualizacaoDto;
import school.sptech.marketplaceresumido.controller.dto.ProdutoConsultaDto;
import school.sptech.marketplaceresumido.controller.dto.ProdutoCriacaoDto;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoConsultaDto>> listar() {
        List<Produto> produtos = produtoService.listar();

        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<ProdutoConsultaDto> produtoConsultaDtos = produtos.stream()
                .map(ProdutoMapper::mapProdutoToProdutoConsultaDto)
                .toList();

        return ResponseEntity.ok(produtoConsultaDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoConsultaDto> buscarPorId(@PathVariable Integer id) {
        Produto produto = produtoService.buscarPorId(id);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ProdutoMapper.mapProdutoToProdutoConsultaDto(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoConsultaDto> criar(@RequestBody @Valid ProdutoCriacaoDto produtoCriacaoDto) {
        Produto produto = ProdutoMapper.mapProdutoCriacaoDtoToProduto(produtoCriacaoDto);

        produto = produtoService.criar(produto);

        if (produto == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ProdutoMapper.mapProdutoToProdutoConsultaDto(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoConsultaDto> atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid ProdutoAtualizacaoDto produtoCriacaoDto) {
        Produto produtoAtualizar = produtoService.atualizar(
                Objects.requireNonNull(ProdutoMapper.mapProdutoAtualizacaoDtoToProduto(id, produtoCriacaoDto)), id);

        return ResponseEntity.ok(ProdutoMapper.mapProdutoToProdutoConsultaDto(produtoAtualizar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        produtoService.deletarPorId(id);
        return ResponseEntity.ok().build();
    }
}

