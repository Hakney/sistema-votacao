package com.hakney.votacao.controller;

import com.hakney.votacao.dto.VotoRequest;
import com.hakney.votacao.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/whoami")
public class WhoAmIController {

    @GetMapping("/whoami")
    public String whoami() throws UnknownHostException {
        return "Pod: " + InetAddress.getLocalHost().getHostName();
    }
}
