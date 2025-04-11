package com.hakney.votacao.controller;

import com.hakney.votacao.dto.VotoRequest;
import com.hakney.votacao.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/voto")
public class VotoController {

    private final VotoService votoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void processaVoto(@RequestBody VotoRequest request){
        votoService.processaVoto(request);
    }
}
