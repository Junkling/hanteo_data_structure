package example.hanteo.repository;

import example.hanteo.domain.board.Board;
import example.hanteo.domain.board.NamedBoard;
import example.hanteo.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository<T extends Board> extends JpaRepository<T, Long> {
    List<Board> findByBoardName(Team team);

}
