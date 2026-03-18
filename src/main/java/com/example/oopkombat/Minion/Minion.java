package com.example.oopkombat.Minion;

import com.example.oopkombat.Hex.Hex;
import com.example.oopkombat.Model.MinionModel;
import com.example.oopkombat.Player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Minion {
    private Hex pos;
    private Player owner;
    private MinionModel model; // MinionStrategy
    private UUID minionId;
}
