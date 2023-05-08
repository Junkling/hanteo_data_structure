package example.hanteo.service.Dto;

import lombok.Data;

@Data
public abstract class BoardGetDto {

    private Long boardId;
    private String boardName;

}
