package example.hanteo.domain.gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Arrays;

@Getter
public enum GenderType {

    BOY_GROUP("B"),
    GIRL_GROUP("G"),
    MIXED_GROUP("M"),
    ;
    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    public static GenderType enumOf(String n) {
        return Arrays.stream(GenderType.values())
                .filter(t -> t.getValue().equals(n))
                .findAny().orElse(null);
    }

}
