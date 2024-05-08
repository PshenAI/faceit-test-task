package ai.pshenai.faceittesttask.service.food;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Drink extends Food {
    private boolean ice;
    private boolean lemon;
}
