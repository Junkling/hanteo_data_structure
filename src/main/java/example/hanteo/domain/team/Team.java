package example.hanteo.domain.team;

import example.hanteo.domain.board.TeamBoardTable;
import example.hanteo.domain.board.NamedBoard;
import example.hanteo.domain.gender.GenderType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String teamName;


    @Enumerated(EnumType.STRING)
    private GenderType genderType;



    @OneToMany(mappedBy = "team",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<NamedBoard> namedBoard = new ArrayList<>();

    @OneToMany(mappedBy = "team",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<TeamBoardTable> anonymityBoard = new ArrayList<>();
}
