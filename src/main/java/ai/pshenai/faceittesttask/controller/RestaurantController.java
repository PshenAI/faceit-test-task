package ai.pshenai.faceittesttask.controller;

import ai.pshenai.faceittesttask.service.cuisine.Cuisine;
import ai.pshenai.faceittesttask.service.cuisine.CuisineFactory;
import ai.pshenai.faceittesttask.service.food.Food;
import ai.pshenai.faceittesttask.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

    private final CuisineFactory cuisineFactory;
    private final OrderService orderService;

    public RestaurantController(CuisineFactory cuisineFactory, OrderService orderService) {
        this.cuisineFactory = cuisineFactory;
        this.orderService = orderService;
    }

    @GetMapping("/menu")
    public ResponseEntity<Object> getRestaurantMenu() {
        List<List<Food>> result = new ArrayList<>();

        List<Cuisine> cuisines = cuisineFactory.getAllCuisines();
        cuisines.forEach(cuisine -> result.add(cuisine.getMenu()));

        return ResponseEntity.ok(result);
    }

    @PostMapping("/order")
    public ResponseEntity<Object> placeOrder(@RequestBody OrderDTO order) {
        List<Food> processedOrder = orderService.processOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(processedOrder);
    }
}
