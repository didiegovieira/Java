package school.sptech.marketplaceresumido.service.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.marketplaceresumido.entity.Produto;
import school.sptech.marketplaceresumido.entity.data.ProdutoRepository;
import school.sptech.marketplaceresumido.entity.exception.EntidadeConflitoExepction;
import school.sptech.marketplaceresumido.entity.exception.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Integer id) {
        Optional<Produto> caixa = produtoRepository.findById(id);

        if (caixa.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Produto não encontrado");
        }

        return caixa.get();
    }

    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Produto produto, Integer id) {
        if (!this.produtoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Produto não encontrado");
        }

        if (this.produtoRepository.existsByCodigoBarraAndIdNot(
                produto.getCodigoBarra(), id
        )) {
            throw new EntidadeConflitoExepction("Existe um produto cadastrado com o codigo informado");
        }

        produto.setId(id);

        return produtoRepository.save(produto);
    }

    public void deletarPorId(Integer id) {
        if (!this.produtoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Produto não encontrado");
        }

        produtoRepository.deleteById(id);
    }

}
