package ai.pshenai.faceittesttask;

import ai.pshenai.faceittesttask.service.cuisine.CuisineType;
import ai.pshenai.faceittesttask.service.food.Drink;
import ai.pshenai.faceittesttask.service.food.Lunch;

public class TestUtil {
    public static Lunch getMockPolishLunch() {
        return Lunch.builder()
                .name("Bigos Combo")
                .price(15.0)
                .description("Traditional Polish dish with a mix of meats and sauerkraut")
                .cuisineType(CuisineType.POLISH)
                .mainCourse("Bigos")
                .dessert("Paczki")
                .build();
    }

    public static Lunch getMockMexicanLunch() {
        return Lunch.builder()
                .name("Taco Trio")
                .price(18.0)
                .description("Assorted tacos with flavorful fillings")
                .cuisineType(CuisineType.MEXICAN)
                .mainCourse("Chicken Tacos")
                .dessert("Churros")
                .build();
    }

    public static Drink getMockDrink() {
        return Drink.builder()
                .name("Morshynska")
                .price(4.0)
                .description("Your average mineral water")
                .cuisineType(CuisineType.ALL)
                .ice(true)
                .lemon(false)
                .build();
    }
}
