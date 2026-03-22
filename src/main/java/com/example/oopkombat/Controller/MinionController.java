package com.example.oopkombat.Controller;

import com.example.oopkombat.DTO.CreateMinionRespond;
import com.example.oopkombat.DTO.CreateNumberOfMinion;
import com.example.oopkombat.DTO.CreteUpdateMinionInfo;
import com.example.oopkombat.Model.MinionModel;
import com.example.oopkombat.Repository.MinionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/minion")
public class MinionController {
    private final MinionRepository minionRepository;

    @PostMapping("/minion-number")
    public List<UUID> minionNumber(@RequestBody CreateNumberOfMinion NumberOfMinion) {
        return minionRepository.minionNumberManager(NumberOfMinion.getGameID(), NumberOfMinion.getNumberOfMinion());
    }

    @GetMapping("/find-minion-type/{gameID}/{minionTypeID}")
    public MinionModel findMinionType(@PathVariable UUID gameID,
                                  @PathVariable UUID minionTypeID) {
        return minionRepository.getMinionByUUID(minionTypeID, gameID);
    }

    @PostMapping("/info")
    public MinionModel updateMinionInfo(@RequestBody CreteUpdateMinionInfo UpdateMinionInfo) {
        return minionRepository.updateMinionInfo(UpdateMinionInfo.getGameID(), UpdateMinionInfo.getMinionTypeID(), UpdateMinionInfo.getMinionName(), UpdateMinionInfo.getDefenseFactor());
    }

    @PostMapping("/strategy/{gameID}/{minionTypeID}")
    public boolean uploadStrategy(@PathVariable UUID gameID,
                                      @PathVariable UUID minionTypeID,
                                      @RequestPart("File") MultipartFile file){
        return minionRepository.uploadStrategy(gameID, minionTypeID, file);
    }

    @GetMapping("/find-minion/{gameID}/{minionID}")
    public CreateMinionRespond findMinion(@PathVariable UUID gameID,
                                          @PathVariable UUID minionID) {
        return minionRepository.getMinionInBoradByUUID(gameID, minionID);
    }
}
