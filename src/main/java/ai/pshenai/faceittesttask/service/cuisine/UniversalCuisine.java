package ai.pshenai.faceittesttask.service.cuisine;

import ai.pshenai.faceittesttask.service.food.Drink;
import ai.pshenai.faceittesttask.service.food.Food;
import ai.pshenai.faceittesttask.service.food.Lunch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UniversalCuisine  implements Cuisine{

    private final Map<String, Food> dishList = new HashMap<>();

    @Override
    public Lunch prepareLunch(String lunchName) {
        // No universal lunches so far!
        return null;
    }

    @Override
    public Drink prepareDrink(String drinkName, boolean withIce, boolean withLemon) {
        Drink drink = (Drink)dishList.get(drinkName);
        drink.setIce(withIce);
        drink.setLemon(withLemon);

        return drink;
    }

    @Override
    public List<Food> getMenu() {
        return new ArrayList<>(dishList.values());
    }

    @Override
    public void addDish(Food food) {
        dishList.put(food.getName(), food);
    }
}