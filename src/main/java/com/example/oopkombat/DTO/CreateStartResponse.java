package com.example.oopkombat.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStartResponse {
    private UUID PlaterOne;
    private UUID PlaterTwo;
}
