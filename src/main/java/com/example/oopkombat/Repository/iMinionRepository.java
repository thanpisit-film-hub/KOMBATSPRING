package com.example.oopkombat.Repository;

import com.example.oopkombat.Model.MinionModel;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface iMinionRepository {
    List<UUID> minionNumberManager(UUID gameID,int minionNumber);
    MinionModel getMinionByUUID(UUID minionUUID, UUID gameID);
    MinionModel updateMinionInfo(UUID gameID, UUID minionID, String minionName, long defenseFactor);
    boolean uploadStrategy(UUID gameID, UUID minionID, @RequestPart("File") MultipartFile file);
}
