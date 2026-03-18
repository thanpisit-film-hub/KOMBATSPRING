package com.example.oopkombat.Controller;

import com.example.oopkombat.DTO.CreateStartResponse;
import com.example.oopkombat.Repository.StartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/start")
@RequiredArgsConstructor
public class StartController {

    private final StartRepository startRepository;

    @PostMapping("/{gameId}")
    public CreateStartResponse Start(@PathVariable("gameId") UUID gameId){
        return startRepository.newPlayers(gameId);
    }
}
