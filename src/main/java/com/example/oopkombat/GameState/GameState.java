package com.example.oopkombat.GameState;

import com.example.oopkombat.Hex.Hex;
import com.example.oopkombat.Minion.Minion;
import com.example.oopkombat.Mode;
import com.example.oopkombat.Model.MinionModel;
import com.example.oopkombat.Player.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Data
@NoArgsConstructor
public class GameState {
    private UUID gameId;
    private Mode gameMode;
    private UUID gameConfigId;
    private int currentTurn;

    private final List<Hex> allHexInfo = new ArrayList<>();

    private final Map<UUID, MinionModel> minions = new ConcurrentHashMap<>();

    private final Map<UUID, Minion> minionsInboard =  new ConcurrentHashMap<>();

    private final Map<UUID, Player> players = new ConcurrentHashMap<>();

}