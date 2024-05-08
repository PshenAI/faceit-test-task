package ai.pshenai.faceittesttask.service.food;

import ai.pshenai.faceittesttask.service.cuisine.CuisineType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public abstract class Food {
    private String name;
    private Double price;
    private String description;
    private CuisineType cuisineType;
}
