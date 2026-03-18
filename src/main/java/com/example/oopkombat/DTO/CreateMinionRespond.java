package com.example.oopkombat.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMinionRespond {
    private UUID playerId;
    private UUID minionId;
    private UUID minionTypeId;
}
