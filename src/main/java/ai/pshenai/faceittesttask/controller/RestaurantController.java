package ai.pshenai.faceittesttask.controller;

import ai.pshenai.faceittesttask.service.cuisine.Cuisine;
import ai.pshenai.faceittesttask.service.cuisine.CuisineFactory;
import ai.pshenai.faceittesttask.service.food.Food;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

    private final CuisineFactory cuisineFactory;

    public RestaurantController(CuisineFactory cuisineFactory) {
        this.cuisineFactory = cuisineFactory;
    }

    @GetMapping("/menu")
    public ResponseEntity<Object> getRestaurantMenu() {
        List<List<Food>> result = new ArrayList<>();

        List<Cuisine> cuisines = cuisineFactory.getAllCuisines();
        cuisines.forEach(cuisine -> result.add(cuisine.getMenu()));

        return ResponseEntity.ok(result);
    }
}
