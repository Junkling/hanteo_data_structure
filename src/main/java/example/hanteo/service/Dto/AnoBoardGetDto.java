package example.hanteo.service.Dto;

import example.hanteo.domain.board.TeamBoardTable;
import example.hanteo.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class AnoBoardGetDto extends BoardGetDto{
    private List<Long> teamIds = new ArrayList<>();
    private List<String> teamNames = new ArrayList<>();


    public void setBoard(TeamBoardTable table) {
        super.setBoardId(table.getBoard().getId());
        super.setBoardName(table.getBoard().getBoardName());
    }

    public AnoBoardGetDto(TeamBoardTable table) {
        setBoard(table);
        setTeam(table);
    }

    public void setTeam(TeamBoardTable table) {
        teamIds.add(table.getTeam().getId());
        teamNames.add(table.getTeam().getTeamName());
    }

    public void setTeam(List<TeamBoardTable> list) {
        Iterator<TeamBoardTable> iterator = list.iterator();
        while (iterator.hasNext()) {
            Team team = iterator.next().getTeam();
            teamIds.add(team.getId());
            teamNames.add(team.getTeamName());
        }
    }

    public AnoBoardGetDto(List<TeamBoardTable> list) {
        setBoard(list.get(0));
        setTeam(list);
    }

}
