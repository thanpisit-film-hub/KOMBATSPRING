package com.example.oopkombat.Model;

import com.example.oopkombat.Mode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModeModel {
    private String gameID;
    private Mode modeEnum;
}
