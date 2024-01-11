package school.sptech.marketplaceresumido.entity.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.marketplaceresumido.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    boolean existsByCodigoBarraAndIdNot(String codigo, Integer id);
}
