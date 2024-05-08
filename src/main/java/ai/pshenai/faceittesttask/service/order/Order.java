package ai.pshenai.faceittesttask.service.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String lunchName;
    private String lunchCuisine;
    private String drinkName;
    private String drinkCuisine;
    private boolean drinkHasIce;
    private boolean drinkHasLemon;
}
