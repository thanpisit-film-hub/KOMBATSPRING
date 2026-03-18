package com.example.oopkombat.Player;

import com.example.oopkombat.Hex.Hex;
import com.example.oopkombat.Minion.Minion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Player {
    private UUID playerId;

    private final List<Minion> minions = new ArrayList<>();
    private final List<Hex> ownHex =  new ArrayList<>();

    private long Budget;
}
