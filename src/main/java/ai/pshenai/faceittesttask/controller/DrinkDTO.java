package ai.pshenai.faceittesttask.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DrinkDTO {
    private String drinkName;
    private String drinkCuisine;
    private boolean drinkHasIce;
    private boolean drinkHasLemon;
}
