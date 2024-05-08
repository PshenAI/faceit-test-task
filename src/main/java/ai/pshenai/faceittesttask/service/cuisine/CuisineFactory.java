package ai.pshenai.faceittesttask.service.cuisine;

import ai.pshenai.faceittesttask.service.food.Food;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CuisineFactory {

    private final Map<String, Cuisine> cuisines;

    public CuisineFactory(Map<String, Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public Cuisine getFoodCuisine(Food food) {
        return switch(food.getCuisineType()){
            case ALL -> cuisines.get("universalCuisine");
            case ITALIAN -> cuisines.get("polishCuisine");
            case MEXICAN -> cuisines.get("mexicanCuisine");
            case POLISH -> cuisines.get("italianCuisine");
        };
    }

    public List<Cuisine> getAllCuisines() {
        return new ArrayList<>(cuisines.values());
    }
}
