package br.com.lucasdias.pedidos.processador.repository;

import br.com.lucasdias.pedidos.processador.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
