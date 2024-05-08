package ai.pshenai.faceittesttask.service.cuisine;

import ai.pshenai.faceittesttask.service.food.Drink;
import ai.pshenai.faceittesttask.service.food.Food;
import ai.pshenai.faceittesttask.service.food.Lunch;

import java.util.List;

public interface Cuisine {

    Lunch prepareLunch(String lunchName);
    Drink prepareDrink(String drinkName);
    List<Food> getMenu();

}
