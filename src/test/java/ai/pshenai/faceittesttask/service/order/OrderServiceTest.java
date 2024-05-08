package ai.pshenai.faceittesttask.service.order;

import ai.pshenai.faceittesttask.TestUtil;
import ai.pshenai.faceittesttask.controller.DrinkDTO;
import ai.pshenai.faceittesttask.controller.LunchDTO;
import ai.pshenai.faceittesttask.controller.OrderDTO;
import ai.pshenai.faceittesttask.service.cuisine.Cuisine;
import ai.pshenai.faceittesttask.service.cuisine.CuisineFactory;
import ai.pshenai.faceittesttask.service.food.Food;
import ai.pshenai.faceittesttask.service.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private CuisineFactory cuisineFactory;

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService(orderRepository, cuisineFactory);
    }

    @Test
    public void testProcessOrder() {
        // Given
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setLunchDTO(new LunchDTO("Bigos", "POLISH"));
        orderDTO.setDrinkDTO(new DrinkDTO("Morshynska", "ALL", true, true));

        Cuisine polishCuisine = mock(Cuisine.class);
        when(polishCuisine.prepareLunch("Bigos")).thenReturn(TestUtil.getMockPolishLunch());
        when(cuisineFactory.getConcreteCuisine("POLISH")).thenReturn(polishCuisine);

        Cuisine mexicanCuisine = mock(Cuisine.class);
        when(mexicanCuisine.prepareDrink("Morshynska", true, true)).thenReturn(TestUtil.getMockDrink());
        when(cuisineFactory.getConcreteCuisine("ALL")).thenReturn(mexicanCuisine);

        Order expectedOrder = new Order();
        expectedOrder.setLunchName("Bigos");
        expectedOrder.setLunchCuisine("POLISH");
        expectedOrder.setDrinkName("Morshynska");
        expectedOrder.setDrinkCuisine("ALL");
        expectedOrder.setDrinkHasLemon(true);
        expectedOrder.setDrinkHasIce(true);

        List<Food> expectedFoods = new ArrayList<>();
        expectedFoods.add(TestUtil.getMockPolishLunch());
        expectedFoods.add(TestUtil.getMockDrink());

        // When
        List<Food> processedOrder = orderService.processOrder(orderDTO);

        // Then
        verify(orderRepository, times(1)).save(expectedOrder);
        assertEquals(expectedFoods, processedOrder);
    }
}
