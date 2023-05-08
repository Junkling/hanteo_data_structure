package example.hanteo.service.Dto;

import example.hanteo.domain.board.Board;
import example.hanteo.domain.board.TeamBoardTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamBoardTableDto {
    private Long tableId;

    private List<AnoBoardGetDto> boardList = new ArrayList<>();



    public TeamBoardTableDto(TeamBoardTable table) {
        this.tableId = table.getId();
        boardList.add(new AnoBoardGetDto(table));
    }

}
