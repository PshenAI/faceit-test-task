package ai.pshenai.faceittesttask.service.cuisine;

import ai.pshenai.faceittesttask.service.food.Drink;
import ai.pshenai.faceittesttask.service.food.Food;
import ai.pshenai.faceittesttask.service.food.Lunch;

import java.util.List;

public interface Cuisine {

    /**
     * Encapsulates all logic regarding lunch creation
     *
     * @param lunchName name of the lunch
     * @return {@link Lunch}
     */
    Lunch prepareLunch(String lunchName);

    /**
     * Encapsulates all logic regarding drink creation
     *
     * @param drinkName name of the drink
     * @param withIce (optional) add ice
     * @param withLemon (optional) add lemon
     * @return {@link Drink}
     */
    Drink prepareDrink(String drinkName, boolean withIce, boolean withLemon);

    /**
     * @return list of all available dishes from all cuisines
     */
    List<Food> getMenu();

    /**
     * Adds a dish to cuisine dishList
     *
     * @param food - a Drink or a Lunch object
     */
    void addDish(Food food);

}
