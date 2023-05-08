package example.hanteo.controller;

import example.hanteo.domain.board.dto.AnoBoardCreateDto;
import example.hanteo.domain.board.dto.NamedBoardCreateDto;
import example.hanteo.domain.team.Team;
import example.hanteo.domain.team.TeamDto;
import example.hanteo.service.BoardService;
import example.hanteo.service.Dto.AnoBoardGetDto;
import example.hanteo.service.Dto.BoardGetDto;
import example.hanteo.service.Dto.NamedBoardGetDto;
import example.hanteo.service.Dto.TeamGetDto;
import example.hanteo.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class Controller {
    private final BoardService boardService;
    private final TeamService teamService;

    @GetMapping("/gender")
    public ResponseEntity<List<TeamGetDto>> teamList(@RequestParam String gender) {
        log.info("/gender 호출");
        List<TeamGetDto> byGender = teamService.findByGender(gender);
        return ResponseEntity.ok().body(byGender);
    }

    @GetMapping("/team")
    public ResponseEntity<TeamGetDto> boardList(@RequestParam Long teamId) {
        TeamGetDto byTeamName = teamService.findTeam(teamId);
        return ResponseEntity.ok().body(byTeamName);
    }

    @GetMapping("/board")
    public ResponseEntity<BoardGetDto> board(@RequestParam Long boardId) {
        return ResponseEntity.ok().body(boardService.findById(boardId));
    }

    @PostMapping("/board")
    public ResponseEntity<List<NamedBoardGetDto>> createNamedBoard(@RequestBody NamedBoardCreateDto dto) {
        List<NamedBoardGetDto> saved = boardService.saveNamed(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/anonymity")
    public ResponseEntity<AnoBoardGetDto> createAnoBoard(@RequestBody AnoBoardCreateDto dto) {
        AnoBoardGetDto anoBoardGetDto = boardService.saveAno(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(anoBoardGetDto);
    }

    @PostMapping("/team")
    public ResponseEntity<Team> createTeam(@RequestBody TeamDto dto) {
        log.info("성별={}", dto.getGenderType());
        Team savedTeam = teamService.save(dto);
        boardService.saveNamed(new NamedBoardCreateDto(new ArrayList<String>(
                Arrays.asList("공지사항("+dto.getTeamName()+")")), savedTeam.getTeamName()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }

    @DeleteMapping("/board")
    public ResponseEntity deleteBoard(@RequestParam Long boardId) throws Throwable {
        boardService.delete(boardId);
        return ResponseEntity.ok().body("삭제되었습니다. 게시판 ID : " + boardId);
    }

    @DeleteMapping("/team")
    public ResponseEntity deleteTeam(@RequestParam Long teamId) {
        teamService.delete(teamId);
        return ResponseEntity.ok().body("그룹이 삭제되었습니다. 그룹 ID : " + teamId);
    }
}
