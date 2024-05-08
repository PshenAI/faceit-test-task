package ai.pshenai.faceittesttask.service.cuisine;

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

    public Cuisine getConcreteCuisine(String cuisineName) {
        return switch(cuisineName){
            case "ALL" -> cuisines.get("universalCuisine");
            case "POLISH" -> cuisines.get("polishCuisine");
            case "MEXICAN" -> cuisines.get("mexicanCuisine");
            case "ITALIAN" -> cuisines.get("italianCuisine");
            default -> throw new IllegalStateException("Illegal cuisine name: " + cuisineName);
        };
    }

    public List<Cuisine> getAllCuisines() {
        return new ArrayList<>(cuisines.values());
    }
}
