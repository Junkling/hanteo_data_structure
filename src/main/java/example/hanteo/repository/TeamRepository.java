package example.hanteo.repository;

import example.hanteo.domain.gender.GenderType;
import example.hanteo.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByGenderType(GenderType genderType);

    Optional<Team> findByTeamName(String teamName);

    Optional<Team> findById(Long Id);
}
