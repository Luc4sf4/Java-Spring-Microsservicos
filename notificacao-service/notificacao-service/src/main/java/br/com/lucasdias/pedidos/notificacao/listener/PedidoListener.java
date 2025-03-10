package br.com.lucasdias.pedidos.notificacao.listener;

import br.com.lucasdias.pedidos.notificacao.entity.Pedido;
import br.com.lucasdias.pedidos.notificacao.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {
    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    @Autowired
    private  EmailService emailService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido) {

        emailService.enviarEmail(pedido);
        logger.info("Notificacao Gerada: {}", pedido.toString());
    }
}
