package com.example.oopkombat.DTO;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBuyMinion {
    private UUID gameId;
    private UUID minionTypeId;
    private UUID playerId;
    private int row;
    private int col;
}
