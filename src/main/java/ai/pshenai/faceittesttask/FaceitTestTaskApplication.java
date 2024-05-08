package ai.pshenai.faceittesttask;

import ai.pshenai.faceittesttask.service.cuisine.*;
import ai.pshenai.faceittesttask.service.food.Drink;
import ai.pshenai.faceittesttask.service.food.Lunch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class FaceitTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceitTestTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner onStart(PolishCuisine polishCuisine, ItalianCuisine italianCuisine, MexicanCuisine mexicanCuisine,
                                     UniversalCuisine universalCuisine, final CuisineFactory cuisineFactory) {
        return strings ->{
            Lunch italianLunch = Lunch.builder()
                    .name("Carbonara")
                    .price(20.0)
                    .description("True carbonara with exquisite macaroni for a dessert")
                    .cuisineType(CuisineType.ITALIAN)
                    .mainCourse("Pasta Carbonara")
                    .dessert("Macaroni")
                    .build();
            italianCuisine.addDish(italianLunch);

            Lunch polishLunch = Lunch.builder()
                    .name("Bigos Combo")
                    .price(15.0)
                    .description("Traditional Polish dish with a mix of meats and sauerkraut")
                    .cuisineType(CuisineType.POLISH)
                    .mainCourse("Bigos")
                    .dessert("Paczki")
                    .build();
            polishCuisine.addDish(polishLunch);

            Lunch mexicanLunch = Lunch.builder()
                    .name("Taco Trio")
                    .price(18.0)
                    .description("Assorted tacos with flavorful fillings")
                    .cuisineType(CuisineType.MEXICAN)
                    .mainCourse("Chicken Tacos")
                    .dessert("Churros")
                    .build();
            mexicanCuisine.addDish(mexicanLunch);

            Drink mineralWater = Drink.builder()
                    .name("Morshynska")
                    .price(4.0)
                    .description("Your average mineral water")
                    .cuisineType(CuisineType.ALL)
                    .build();
            universalCuisine.addDish(mineralWater);

            Drink polishDrink = Drink.builder()
                    .name("Żubrówka")
                    .price(8.0)
                    .description("Famous Polish vodka flavored with bison grass")
                    .cuisineType(CuisineType.POLISH)
                    .build();
            polishCuisine.addDish(polishDrink);

            Drink mexicanDrink = Drink.builder()
                    .name("Margarita")
                    .price(10.0)
                    .description("Classic Mexican cocktail with tequila, lime, and triple sec")
                    .cuisineType(CuisineType.MEXICAN)
                    .build();
            mexicanCuisine.addDish(mexicanDrink);
        };
    }
}
