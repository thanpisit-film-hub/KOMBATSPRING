package com.example.oopkombat.Repository;

import com.example.oopkombat.Mode;

import java.util.UUID;

public interface iModRepository {
    UUID selectMod(Mode Mode);
}
