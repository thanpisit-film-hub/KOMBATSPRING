package com.example.oopkombat.GameState;

import com.example.oopkombat.Mode;
import com.example.oopkombat.Model.MinionModel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Data
@NoArgsConstructor
@Getter
@Setter
public class GameState {
    private UUID gameId;
    private Mode gameMode;
    private UUID gameConfigId;

    private final Map<UUID, MinionModel> minions = new ConcurrentHashMap<>();

}