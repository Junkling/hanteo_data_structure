package example.hanteo.domain.board;

import example.hanteo.domain.team.Team;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TeamBoardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
