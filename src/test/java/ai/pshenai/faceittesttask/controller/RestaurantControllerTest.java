package ai.pshenai.faceittesttask.controller;

import ai.pshenai.faceittesttask.TestUtil;
import ai.pshenai.faceittesttask.service.cuisine.*;
import ai.pshenai.faceittesttask.service.order.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CuisineFactory cuisineFactory;
    @MockBean
    private OrderService orderService;
    @MockBean
    private PolishCuisine polishCuisine;
    @MockBean
    private ItalianCuisine italianCuisine;
    @MockBean
    private UniversalCuisine universalCuisine;
    @MockBean
    private MexicanCuisine mexicanCuisine;

    @Test
    public void testGetRestaurantMenu() throws Exception {
        // Given
        PolishCuisine polishCuisine = new PolishCuisine();
        polishCuisine.addDish(TestUtil.getMockPolishLunch());

        MexicanCuisine mexicanCuisine = new MexicanCuisine();
        mexicanCuisine.addDish(TestUtil.getMockMexicanLunch());

        when(cuisineFactory.getAllCuisines()).thenReturn(List.of(
                mexicanCuisine,
                polishCuisine
        ));

        // When / Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurant/menu")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0][0].name").value("Taco Trio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0][0].price").value(18.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0][0].description").value("Assorted tacos with flavorful fillings"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0][0].cuisineType").value("MEXICAN"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0][0].mainCourse").value("Chicken Tacos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0][0].dessert").value("Churros"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1][0].name").value("Bigos Combo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1][0].price").value(15.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1][0].description").value("Traditional Polish dish with a mix of meats and sauerkraut"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1][0].cuisineType").value("POLISH"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1][0].mainCourse").value("Bigos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1][0].dessert").value("Paczki"));
    }

    @Test
    public void testPlaceOrder() throws Exception {
        // Given
        OrderDTO orderDTO = new OrderDTO();

        when(orderService.processOrder(any(OrderDTO.class))).thenReturn(List.of(TestUtil.getMockMexicanLunch(), TestUtil.getMockDrink()));

        // When / Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurant/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(orderDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Taco Trio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(18.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Assorted tacos with flavorful fillings"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cuisineType").value("MEXICAN"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mainCourse").value("Chicken Tacos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dessert").value("Churros"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Morshynska"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(4.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description").value("Your average mineral water"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].cuisineType").value("ALL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ice").value("true"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].lemon").value("false"));

    }

    @Test
    public void testPlaceEmptyOrder() throws Exception {
        // When / Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurant/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(null)))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

    private String asJsonString(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper.writeValueAsString(obj);
    }

}
