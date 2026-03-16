package com.example.oopkombat.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GameConfigModel {
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
