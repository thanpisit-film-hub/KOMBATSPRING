package com.example.oopkombat.Hex;

import com.example.oopkombat.Model.MinionModel;
import com.example.oopkombat.Player.Player;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Hex {
    private final int row;
    private final int col;

    private Player player;
    private MinionModel minion;
}
