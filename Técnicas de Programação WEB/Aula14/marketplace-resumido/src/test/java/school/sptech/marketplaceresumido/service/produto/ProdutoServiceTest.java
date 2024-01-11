package school.sptech.marketplaceresumido.service.produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.marketplaceresumido.entity.Produto;
import school.sptech.marketplaceresumido.entity.data.ProdutoRepository;
import school.sptech.marketplaceresumido.entity.exception.EntidadeNaoEncontradaException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    @DisplayName("Retorna lista com 3 produtos")
    void testListaComProduto() {
        // given
        List<Produto> produtos = List.of(
                new Produto(),
                new Produto(),
                new Produto()
        );

        // when
        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);

        // then
        List<Produto> produtosRetorno = produtoService.listar();

        // assert
        assertEquals(produtos.size(), produtosRetorno.size());
    }

    @Test
    @DisplayName("Retorna objeto por id")
    void retornaPorId() {
        // given
        Produto produto = new Produto(
                1,
                "Produto 1",
                "123",
                "1232153245",
                10.0
        );

        // when
        //Mockito.when(produtoRepository.findById(1)).thenReturn(Optional.of(produto));
        Mockito.when(produtoRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(produto));

        // then
        Produto produtoRetorno = produtoService.buscarPorId(1);

        // assert
        System.out.println(produtoRetorno);
        assertEquals(produto.getId(), produtoRetorno.getId());
    }

    @Test
    void deveRetornarProdutoAoBuscarPorId() {
        // Arrange
        var produto = Mockito.mock(Produto.class);
        Mockito.when(produtoRepository.findById(1)).thenReturn(Optional.of(produto));

        // Act
        var produtoRetornado = produtoService.buscarPorId(1);

        // Assert
        assertEquals(produto, produtoRetornado);
    }

    @Test
    void deveRetornarEntidadeNaoEncontradaExceptionAoBuscarPorId() {
        // Arrange
        Mockito.when(produtoRepository.findById(1)).thenReturn(Optional.empty());

        // Act
        var exception = assertThrows(EntidadeNaoEncontradaException.class, () -> produtoService.buscarPorId(1));

        // Assert
        assertEquals("Produto não encontrado", exception.getMessage());
    }

    @Test
    void deveRetornarProdutoAoCriar() {
        // Arrange
        var produto = Mockito.mock(Produto.class);
        Mockito.when(produtoRepository.save(produto)).thenReturn(produto);

        // Act
        var produtoRetornado = produtoService.criar(produto);

        // Assert
        assertEquals(produto, produtoRetornado);
    }

    @Test
    void deveRetornarProdutoAoAtualizar() {
        // Arrange
        var produto = Mockito.mock(Produto.class);
        Mockito.when(produtoRepository.existsById(1)).thenReturn(true);
        Mockito.when(produtoRepository.existsByCodigoBarraAndIdNot("123", 1)).thenReturn(false);
        Mockito.when(produtoRepository.save(produto)).thenReturn(produto);

        // Act
        var produtoRetornado = produtoService.atualizar(produto, 1);

        // Assert
        assertEquals(produto, produtoRetornado);
    }

    @Test
    void deveRetornarEntidadeNaoEncontradaExceptionAoAtualizar() {
        // Arrange
        var produto = Mockito.mock(Produto.class);
        Mockito.when(produtoRepository.existsById(1)).thenReturn(false);

        // Act
        var exception = assertThrows(EntidadeNaoEncontradaException.class, () -> produtoService.atualizar(produto, 1));

        // Assert
        assertEquals("Produto não encontrado", exception.getMessage());
    }

    @Test
    void deveRetornarEntidadeNaoEncontradaExceptionAoAtualizarComCodigoDeBarraExistente() {
        // Arrange
        var produto = Mockito.mock(Produto.class);
        Mockito.when(produtoRepository.existsById(1)).thenReturn(true);
        Mockito.when(produtoRepository.existsByCodigoBarraAndIdNot("123", 1)).thenReturn(true);

        // Act
        var exception = assertThrows(EntidadeNaoEncontradaException.class, () -> produtoService.atualizar(produto, 2));

        // Assert
        assertEquals("Existe um produto cadastrado com o codigo informado", exception.getMessage());
    }

    @Test
    void deveDeletarProdutoAoDeletarPorId() {
        // Arrange
        Mockito.when(produtoRepository.existsById(1)).thenReturn(true);

        // Act
        produtoService.deletarPorId(1);

        // Assert
        Mockito.verify(produtoRepository).deleteById(1);
    }

    @Test
    void deveRetornarEntidadeNaoEncontradaExceptionAoDeletarPorId() {
        // Arrange
        Mockito.when(produtoRepository.existsById(1)).thenReturn(false);

        // Act
        var exception = assertThrows(EntidadeNaoEncontradaException.class, () -> produtoService.deletarPorId(1));

        // Assert
        assertEquals("Produto não encontrado", exception.getMessage());
    }


}