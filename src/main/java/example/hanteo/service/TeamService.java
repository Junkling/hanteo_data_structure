package example.hanteo.service;

import example.hanteo.domain.gender.GenderType;
import example.hanteo.domain.team.Team;
import example.hanteo.domain.team.TeamDto;
import example.hanteo.repository.TeamRepository;
import example.hanteo.service.Dto.TeamGetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {
    private final TeamRepository teamRepository;

    public Team save(TeamDto dto) {
        Team team = new Team();
        team.setTeamName(dto.getTeamName());
        try {

            team.setGenderType(GenderType.enumOf(dto.getGenderType()));

            return teamRepository.save(team);
        } catch (Exception e) {
            log.info("TeamService GenderType Error");
            throw e;
        }
    }

    public TeamGetDto findTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow();
        return new TeamGetDto(team);
    }


    public List<TeamGetDto> findByGender(String gender) {
        try {
            List<Team> byGender = teamRepository.findByGenderType(GenderType.valueOf(gender));
            Iterator<Team> iterator = byGender.iterator();
            List<TeamGetDto> teamGetDtos = new ArrayList<>();
            while (iterator.hasNext()) {
                TeamGetDto teamGetDto = new TeamGetDto(iterator.next());
                teamGetDtos.add(teamGetDto);
            }
            return teamGetDtos;
        } catch (Exception e) {

            log.info("TeamRepository Gender Error");
            throw e;
        }
    }

    public Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    public void delete(Long teamId) {
        teamRepository.delete(
                teamRepository.findById(teamId).orElseThrow(() -> new EntityNotFoundException("그룹이 없습니다."))
        );
    }

}
