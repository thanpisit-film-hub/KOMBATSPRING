package com.example.oopkombat.Player;

import com.example.oopkombat.Hex.Hex;
import com.example.oopkombat.Model.MinionModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private final List<MinionModel> minions = new ArrayList<>();
    private final List<Hex> ownHex =  new ArrayList<>();

    private long Budget;
}
