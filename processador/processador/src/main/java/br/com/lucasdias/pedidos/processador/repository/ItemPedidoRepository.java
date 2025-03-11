package br.com.lucasdias.pedidos.processador.repository;

import br.com.lucasdias.pedidos.processador.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, UUID> {
}
