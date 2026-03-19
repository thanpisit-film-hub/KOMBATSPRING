package com.example.oopkombat.Repository;

import com.example.oopkombat.DTO.CreateMinionRespond;
import com.example.oopkombat.GameManager.GameManager;
import com.example.oopkombat.GameState.GameState;
import com.example.oopkombat.Minion.Minion;
import com.example.oopkombat.Model.MinionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class MinionRepository implements iMinionRepository {
    private final GameManager gameManager;
    private static final Path strategy_Path = Paths.get("./StrategyStorage");

    //สร้าง UUID ของ minion Type
    @Override
    public List<UUID> minionNumberManager(UUID gameID,int minionNumber) {
        if(gameID == null){
            return List.of();
        }
        if(minionNumber <= 0 || minionNumber > 5) return List.of();
        List<UUID> uuidList = new ArrayList<>();

        GameState gameState = gameManager.getGame(gameID);
        if(gameState == null) return List.of();

        gameState.getMinions().clear();

        for(int i = 0; i < minionNumber; i++) {
            MinionModel minion = new MinionModel();
            minion.setMinionTypeID(UUID.randomUUID());

            UUID minionuuid = minion.getMinionTypeID();

            uuidList.add(minionuuid);
            gameState.getMinions().put(minionuuid, minion);
        }
        return uuidList;
    }

    //หา minion Type
    @Override
    public MinionModel getMinionByUUID(UUID minionUUID, UUID gameID) {
        GameState gameState = gameManager.getGame(gameID);
        if(gameState == null) return null;
        return gameState.getMinions().get(minionUUID);
    }

    // update minion Type
    @Override
    public MinionModel updateMinionInfo(UUID gameID, UUID minionID, String minionName, long defenseFactor) {
        GameState gameState = gameManager.getGame(gameID);
        if(gameState == null) return null;

        MinionModel minion = gameState.getMinions().get(minionID);
        if(minion == null) return null;

        minion.setMinionName(minionName);
        minion.setDefenseFactor(defenseFactor);
        return minion;
    }

    // อัปไฟล์จาก client เก็บไว้ใน StrategyStorage พร้อมผูกเก็บไว้ใน minion Type
    @Override
    public boolean uploadStrategy(UUID gameID, UUID minionID, MultipartFile file) {
        if(gameID == null || minionID == null || file == null || file.isEmpty()) return false;

        GameState gameState = gameManager.getGame(gameID);
        if(gameState == null) return false;

        MinionModel minion = gameState.getMinions().get(minionID);
        if(minion == null) return false;

        String fileName = file.getOriginalFilename();
        if(fileName == null || !fileName.toLowerCase().endsWith(".txt")) return false;

        try{
            Files.createDirectories(strategy_Path);
            Path currentPath = strategy_Path.resolve(gameID + "-" + minionID + ".txt");
            Files.copy(file.getInputStream(), currentPath, StandardCopyOption.REPLACE_EXISTING);
            minion.setMinionStrategyPath(currentPath);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    // หา minion ใน board
    @Override
    public CreateMinionRespond getMinionInBoradByUUID(UUID minionUUID, UUID gameID) {
        GameState gameState = gameManager.getGame(gameID);
        if(gameState == null) return null;

        CreateMinionRespond createMinionRespond = new CreateMinionRespond();
        Minion minion = gameState.getMinionsInboard().get(minionUUID);

        createMinionRespond.setMinionId(minion.getMinionId());
        createMinionRespond.setMinionTypeId(minion.getModel().getMinionTypeID());
        createMinionRespond.setPlayerId(minion.getOwner().getPlayerId());

        return createMinionRespond;
    }

}