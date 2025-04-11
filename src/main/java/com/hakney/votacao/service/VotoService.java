package com.hakney.votacao.service;

import com.hakney.votacao.dto.VotoRequest;
import com.hakney.votacao.entity.Candidato;
import com.hakney.votacao.entity.Voto;
import com.hakney.votacao.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VotoService {

    private final RabbitTemplate rabbitTemplate;
    private final VotoRepository votoRepository;

    public void processaVoto(VotoRequest request) {
        rabbitTemplate.convertAndSend("computar.voto.ex", "", request);
    }

    public void salvar(VotoRequest request) {
        Voto voto = new Voto();
        voto.setCandidato(new Candidato(request.getIdCandidato()));
        votoRepository.save(voto);
    }
}
