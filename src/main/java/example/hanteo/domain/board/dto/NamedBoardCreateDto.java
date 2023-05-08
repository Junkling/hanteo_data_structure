package example.hanteo.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NamedBoardCreateDto {
    private List<String> boardNames;
    private String teamName;

}
