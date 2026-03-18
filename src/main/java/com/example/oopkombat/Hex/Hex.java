package com.example.oopkombat.Hex;

import com.example.oopkombat.Minion.Minion;
import com.example.oopkombat.Player.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Hex {
    private final int row;
    private final int col;

    private Player player;
    private Minion minion;
}
