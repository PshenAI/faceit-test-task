package ai.pshenai.faceittesttask.service.cuisine;

import ai.pshenai.faceittesttask.service.food.Drink;
import ai.pshenai.faceittesttask.service.food.Food;
import ai.pshenai.faceittesttask.service.food.Lunch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PolishCuisine implements Cuisine{

    private final static CuisineType type = CuisineType.POLISH;
    private final List<Food> dishList = new ArrayList<>();

    @Override
    public Lunch prepareLunch(String lunchName) {
        return null;
    }

    @Override
    public Drink prepareDrink(String drinkName) {
        return null;
    }

    @Override
    public List<Food> getMenu() {
        return dishList;
    }

    public void addDish(Food food) {
        dishList.add(food);
    }

    public void removeDish(Food food) {
        dishList.remove(food);
    }
}