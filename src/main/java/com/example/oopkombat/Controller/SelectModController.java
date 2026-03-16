package com.example.oopkombat.Controller;

import com.example.oopkombat.DTO.CreateModSelection;
import com.example.oopkombat.Model.ModeModel;
import com.example.oopkombat.Repository.ModRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/select-mode/new-game")
@RequiredArgsConstructor
public class SelectModController {
    private final ModRepository modRepository;

    // /select-mode/new-game
    @PostMapping()
    public ModeModel selectMod(@RequestBody CreateModSelection mode) {
        return modRepository.selectMod(mode.getMode());
    }

}
