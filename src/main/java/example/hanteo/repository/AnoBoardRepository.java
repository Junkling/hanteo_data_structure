package example.hanteo.repository;

import example.hanteo.domain.board.AnonymityBoard;
import example.hanteo.domain.board.TeamBoardTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnoBoardRepository extends JpaRepository<AnonymityBoard, Long> {

}
