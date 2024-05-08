package ai.pshenai.faceittesttask.service.cuisine;

import ai.pshenai.faceittesttask.service.food.Lunch;
import org.springframework.stereotype.Component;

@Component
public class UniversalCuisine extends BaseCuisine{

    @Override
    public Lunch prepareLunch(String lunchName) {
        // No universal lunches so far
        return null;
    }
}