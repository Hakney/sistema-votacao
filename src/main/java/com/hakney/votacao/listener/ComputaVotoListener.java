package com.hakney.votacao.listener;

import com.hakney.votacao.dto.VotoRequest;
import com.hakney.votacao.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ComputaVotoListener {

    private final VotoService votoService;

    @RabbitListener(queues = "computar.voto.queue")
    public void processMessage(VotoRequest request){
        votoService.salvar(request);
    }
}
