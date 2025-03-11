package br.com.lucasdias.pedidos.processador.service;

import br.com.lucasdias.pedidos.processador.entity.ItemPedido;
import br.com.lucasdias.pedidos.processador.entity.Pedido;
import br.com.lucasdias.pedidos.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private ProdutoService produtoService;

    public void save(Pedido pedido){

        //salvando produtos
        produtoService.save(pedido.getItens());

        //salvando item do pedido
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItens());

        //salvando o pedido
        pedidoRepository.save(pedido);

        //atualiza o item pedido definindo o pedido ao qual ele faz parte
        itemPedidoService.updatedItemPedido(itemPedidos, pedido);

        logger.info("Pedido Salvo: {}", pedido.toString());

    }

}

