package ai.pshenai.faceittesttask.service.order;

import ai.pshenai.faceittesttask.controller.OrderDTO;
import ai.pshenai.faceittesttask.service.cuisine.Cuisine;
import ai.pshenai.faceittesttask.service.cuisine.CuisineFactory;
import ai.pshenai.faceittesttask.service.food.Food;
import ai.pshenai.faceittesttask.service.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CuisineFactory cuisineFactory;

    public OrderService(OrderRepository orderRepository, CuisineFactory cuisineFactory) {
        this.orderRepository = orderRepository;
        this.cuisineFactory = cuisineFactory;
    }

    public List<Food> processOrder(OrderDTO order) {
        List<Food> result = new ArrayList<>();
        Order placedOrder = new Order();

        if(order.getLunchDTO() != null) {
            String lunchCuisine = order.getLunchDTO().getLunchCuisine();
            String lunchName = order.getLunchDTO().getLunchName();
            Cuisine cuisine = cuisineFactory.getConcreteCuisine(lunchCuisine);
            result.add(cuisine.prepareLunch(order.getLunchDTO().getLunchName()));

            placedOrder.setLunchName(lunchName);
            placedOrder.setLunchCuisine(lunchCuisine);
        }

        if(order.getDrinkDTO() != null) {
            String drinkName = order.getDrinkDTO().getDrinkName();
            String drinkCuisine = order.getDrinkDTO().getDrinkCuisine();
            boolean withLemon = order.getDrinkDTO().isDrinkHasLemon();
            boolean withIce = order.getDrinkDTO().isDrinkHasIce();


            Cuisine cuisine = cuisineFactory.getConcreteCuisine(order.getDrinkDTO().getDrinkCuisine());
            result.add(cuisine.prepareDrink(order.getDrinkDTO().getDrinkName(), withIce, withLemon));

            placedOrder.setDrinkName(drinkName);
            placedOrder.setDrinkCuisine(drinkCuisine);
            placedOrder.setDrinkHasLemon(withLemon);
            placedOrder.setDrinkHasIce(withIce);
        }

        orderRepository.save(placedOrder);
        return result;
    }
}
