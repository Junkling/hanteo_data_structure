package example.hanteo.domain.gender;

import javax.persistence.AttributeConverter;

public class GenderTypeConverter implements AttributeConverter<GenderType, String> {

    @Override
    public String convertToDatabaseColumn(GenderType genderType) {
        if (genderType == null) {
            return null;
        }
        return genderType.getValue();
    }

    @Override
    public GenderType convertToEntityAttribute(String string) {
        if (string == null) {
            return null;
        }
        try {
            return GenderType.valueOf(string);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}