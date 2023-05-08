package example.hanteo.domain.team;

import example.hanteo.domain.gender.GenderType;
import lombok.Data;

@Data
public class TeamDto {
    private String teamName;
    private String genderType;
}
