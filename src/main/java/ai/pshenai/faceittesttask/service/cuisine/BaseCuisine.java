package ai.pshenai.faceittesttask.service.cuisine;

import ai.pshenai.faceittesttask.service.food.Drink;
import ai.pshenai.faceittesttask.service.food.Food;
import ai.pshenai.faceittesttask.service.food.Lunch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseCuisine implements Cuisine {
    protected final Map<String, Food> dishList = new HashMap<>();

    public Lunch prepareLunch(String lunchName) {
        return (Lunch)dishList.get(lunchName);
    }

    public Drink prepareDrink(String drinkName, boolean withIce, boolean withLemon) {
        Drink drink = (Drink)dishList.get(drinkName);
        drink.setIce(withIce);
        drink.setLemon(withLemon);

        return drink;
    }

    public List<Food> getMenu() {
        return new ArrayList<>(dishList.values());
    }

    public void addDish(Food food) {
        dishList.put(food.getName(), food);
    }
}
