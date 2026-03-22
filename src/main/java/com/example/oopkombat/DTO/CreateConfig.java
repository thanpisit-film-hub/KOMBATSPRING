package com.example.oopkombat.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateConfig {
    private UUID gameID;
    private long startingGold;
    private long maxGold;
    private long goldPerRound;
    private long interestRate;
    private long hexCost;
    private long turnLimit;
    private long minionHp;
    private long maxMinions;
    private long minionCost;
}
