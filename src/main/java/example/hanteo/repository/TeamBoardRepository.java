package example.hanteo.repository;

import example.hanteo.domain.board.AnonymityBoard;
import example.hanteo.domain.board.Board;
import example.hanteo.domain.board.TeamBoardTable;
import example.hanteo.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamBoardRepository extends JpaRepository<TeamBoardTable, Long> {
    List<TeamBoardTable> findByTeam(Team team);

    List<TeamBoardTable> findByBoard(Board board);
}
