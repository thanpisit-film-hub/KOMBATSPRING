package com.example.oopkombat.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreteUpdateMinionInfo {
    private UUID gameID;
    private UUID minionTypeID;
    private String minionName;
    private long defenseFactor;
}
