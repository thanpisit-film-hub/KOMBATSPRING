package com.example.oopkombat.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateHexRespond {
    private int row;
    private int col;

    private UUID playerId;
    private UUID minionId;
}
