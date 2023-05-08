package example.hanteo.domain.board.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnoBoardCreateDto {
    private String boardName;
    private List<String> teamNames;

}
