package br.com.lucasdias.pedidos.processador.service;

import br.com.lucasdias.pedidos.processador.entity.ItemPedido;
import br.com.lucasdias.pedidos.processador.entity.Pedido;
import br.com.lucasdias.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> save(List<ItemPedido> itens) {

        return itemPedidoRepository.saveAll(itens);

    }

    public void save(ItemPedido item){
        itemPedidoRepository.save(item);
    }

    public void updatedItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {

        itemPedidos.forEach(item->{
            item.setPedido(pedido); //informando ao item o seu pedido
            this.save(item);
        });
    }
}
