package com.example.oopkombat.Controller;

import com.example.oopkombat.DTO.CreateModSelection;
import com.example.oopkombat.Repository.ModRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/select-mode/new-game")
@RequiredArgsConstructor
public class SelectModController {
    private final ModRepository modRepository;

    // /select-mode/new-game
    @PostMapping()
    public UUID selectMod(@RequestBody CreateModSelection mode) {
        return modRepository.selectMod(mode.getMode());
    }
    /**
     * Flow
     * Client sent -> Enum -> mode มาทาง ("/select-mode/new-game") แปลงบ้อมูลผ่าน DTO
     * จากนั้นจะเข้า Function selectMod(CreateModSelection mode) Function เรียกใช้ Repository(selectMod)
     * ภายใน Function จะเช็คว่า mode == null ไหมจะใช่ return null ถ้าไม่
     * จะทำการสร้างเกมใหม่ผ่าน GameManager ซึ่งจะได้ UUID ของ Game ออกมาและ Game จะถูกเก็บใน map<gameID, GameState>
     * และภายใน Function นี้จะ Set gameID, Mode ให้เอง จบ...
     */
}
