package example.hanteo.domain.board;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnonymityBoard extends Board {

    @OneToMany(mappedBy = "board",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<TeamBoardTable> teams = new ArrayList<>();

    public List<TeamBoardTable> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamBoardTable> teams) {
        this.teams = teams;
    }
}
