package example.hanteo.service.Dto;

import example.hanteo.domain.board.NamedBoard;
import example.hanteo.domain.board.TeamBoardTable;
import example.hanteo.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamGetDto {
    private Long teamId;
    private String teamName;
    private List<NamedBoardGetDto> boardList;

    private List<TeamBoardTableDto> tableDto;


    public TeamGetDto(Team entity) {
        this.teamId = entity.getId();
        this.teamName = entity.getTeamName();
        List<NamedBoard> namedBoard = entity.getNamedBoard();
        Iterator<NamedBoard> iterator = namedBoard.iterator();
        ArrayList<NamedBoardGetDto> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(new NamedBoardGetDto(entity,iterator.next()));
        }
        this.boardList = list;

        ArrayList<TeamBoardTableDto> list2 = new ArrayList<>();
        List<TeamBoardTable> tables = entity.getAnonymityBoard();
        Iterator<TeamBoardTable> iterator2 = tables.iterator();
        while (iterator2.hasNext()) {
            list2.add(new TeamBoardTableDto(iterator2.next()));
        }
        this.tableDto = list2;

    }
}
