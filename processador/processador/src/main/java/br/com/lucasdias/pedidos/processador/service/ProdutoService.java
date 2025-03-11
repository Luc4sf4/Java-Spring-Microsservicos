package br.com.lucasdias.pedidos.processador.service;

import br.com.lucasdias.pedidos.processador.entity.ItemPedido;
import br.com.lucasdias.pedidos.processador.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void save(List<ItemPedido> itens) {

        itens.forEach(itemPedido ->{
            produtoRepository.save(itemPedido.getProduto());
        } );

    }
}
