package example.hanteo.repository;

import example.hanteo.domain.board.Board;
import example.hanteo.domain.board.NamedBoard;
import example.hanteo.domain.board.TeamBoardTable;
import example.hanteo.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NamedBoardRepository extends JpaRepository<NamedBoard, Long> {


//    List<NamedBoard> findByTeamName(String teamName);

    List<NamedBoard> findByTeam(Team team);

//    List<Board> findAllByTable(List<TeamBoardTable> teamBoardTable);


}
