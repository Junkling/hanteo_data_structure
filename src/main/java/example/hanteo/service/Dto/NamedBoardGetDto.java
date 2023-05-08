package example.hanteo.service.Dto;

import example.hanteo.domain.board.Board;
import example.hanteo.domain.board.NamedBoard;
import example.hanteo.domain.board.TeamBoardTable;
import example.hanteo.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NamedBoardGetDto extends BoardGetDto{
    private Long teamId;
    private String teamName;

    //    private TeamGetDto teamGetDto;

    public NamedBoardGetDto(Team team, Board entity) {
        this.teamId = team.getId();
        this.teamName = team.getTeamName();
        setBoard(entity);

    }

    public void setBoard(Board entity) {
        super.setBoardId(entity.getId());
        super.setBoardName(entity.getBoardName());
    }
}
