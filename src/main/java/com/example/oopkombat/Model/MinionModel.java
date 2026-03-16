package com.example.oopkombat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.file.Path;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MinionModel {
    // private UUID minionIDInHex; // real minion
    private UUID minionID; // type
    private long defenseFactor;
    private String minionName;
    private Path minionStrategyPath;
}

// BuyHex ส่ง position(1, 1 - 8, 8), player -> Web socket
// BuyMinion ส่ง minion type(UUID), player, position -> Web socket
// Budget, Available -> Web Socket
// End turn -> list<Hex>
// Buy Able -> list<Hex> (buy able)
// Current Turn -> Web Socket