package ai.pshenai.faceittesttask.service.cuisine;

import lombok.Getter;

@Getter
public enum CuisineType {
    ALL("*"),
    POLISH("POLISH"),
    MEXICAN("MEXICAN"),
    ITALIAN("ITALIAN");

    private String value;

    CuisineType(String value) {
    }
}
