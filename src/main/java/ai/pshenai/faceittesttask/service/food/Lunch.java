package ai.pshenai.faceittesttask.service.food;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Lunch extends Food {
    private String mainCourse;
    private String dessert;
}
