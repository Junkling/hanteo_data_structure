package example.hanteo.service;

import example.hanteo.domain.board.AnonymityBoard;
import example.hanteo.domain.board.Board;
import example.hanteo.domain.board.NamedBoard;
import example.hanteo.domain.board.TeamBoardTable;
import example.hanteo.domain.board.dto.AnoBoardCreateDto;
import example.hanteo.domain.board.dto.NamedBoardCreateDto;
import example.hanteo.domain.team.Team;
import example.hanteo.repository.*;
import example.hanteo.service.Dto.AnoBoardGetDto;
import example.hanteo.service.Dto.BoardGetDto;
import example.hanteo.service.Dto.NamedBoardGetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final NamedBoardRepository namedBoardRepository;
    private final TeamRepository teamRepository;
    private final TeamBoardRepository teamBoardRepository;
    private final BoardRepository boardRepository;
    private final AnoBoardRepository anoBoardRepository;


    public BoardGetDto findById(Long boardId) {
        if (namedBoardRepository.findById(boardId).isPresent()) {
            NamedBoard namedBoard = namedBoardRepository.findById(boardId).orElseThrow();
            NamedBoardGetDto namedBoardGetDto = new NamedBoardGetDto(namedBoard.getTeam(), namedBoard);
            return namedBoardGetDto;
        }
        if (anoBoardRepository.findById(boardId).isPresent()) {
            List<TeamBoardTable> byBoardId = teamBoardRepository.findByBoard(anoBoardRepository.findById(boardId).orElseThrow());
            AnoBoardGetDto anoBoardGetDto = new AnoBoardGetDto(byBoardId);

            return anoBoardGetDto;
        } else {
            throw new EntityNotFoundException("게시판이 없습니다.");
        }
    }

    public List<NamedBoardGetDto> findByTeamId(Long teamId) {
        List<TeamBoardTable> tbTable = teamBoardRepository.findByTeam(teamRepository.findById(teamId).orElseThrow());
        List<NamedBoardGetDto> joined = new ArrayList<>();
        Team team = teamRepository.findById(teamId).orElseThrow();

        Iterator<TeamBoardTable> iter = tbTable.iterator();
        while (iter.hasNext()) {
            Board board = iter.next().getBoard();
            joined.add(new NamedBoardGetDto(team, board));
        }
        List<NamedBoard> byTeam = namedBoardRepository.findByTeam(teamRepository.findById(teamId).orElseThrow());
        Iterator<NamedBoard> iterator = byTeam.iterator();
        while (iterator.hasNext()) {
            NamedBoard next = iterator.next();
            joined.add(new NamedBoardGetDto(team, iterator.next()));
        }
        joined.sort((a, b) -> a.getBoardId().compareTo(b.getBoardId()));

        return joined;
    }

    //Dto 만들어서 반환
    public List<NamedBoardGetDto> saveNamed(NamedBoardCreateDto dto) {
        List<NamedBoardGetDto> createList = new ArrayList<>();
        List<String> boardNames = dto.getBoardNames();
        Iterator<String> iter = boardNames.iterator();
        while (iter.hasNext()) {
            NamedBoard namedBoard = new NamedBoard();
            namedBoard.setBoardName(iter.next());
            Team team = teamRepository.findByTeamName(dto.getTeamName()).orElseThrow();
            namedBoard.setTeam(team);
            Board entity = (Board) boardRepository.save(namedBoard);
            NamedBoardGetDto namedBoardGetDto = new NamedBoardGetDto(team, entity);

            createList.add(namedBoardGetDto);
        }
        return createList;
    }

    public AnoBoardGetDto saveAno(AnoBoardCreateDto dto) {
        //익명 게시판 저장
        AnonymityBoard anonymityBoard = new AnonymityBoard();
        anonymityBoard.setBoardName(dto.getBoardName());
        AnonymityBoard entity = anoBoardRepository.save(anonymityBoard);

        AnoBoardGetDto anoBoardGetDto = new AnoBoardGetDto();
        anoBoardGetDto.setBoardId(entity.getId());
        anoBoardGetDto.setBoardName(entity.getBoardName());
        //익명 게시판에 관련된 팀 테이블 생성 및 연관관계 매핑
        List<String> teamNames = dto.getTeamNames();
        Iterator<String> iter = teamNames.iterator();
        List<Long> teamIds = new ArrayList<>();
        while (iter.hasNext()) {
            TeamBoardTable teamBoardTable = new TeamBoardTable();
            teamBoardTable.setBoard(entity);
            teamBoardTable.setTeam(teamRepository.findByTeamName(iter.next()).orElseThrow());
            TeamBoardTable table = teamBoardRepository.save(teamBoardTable);
            teamIds.add(table.getId());
        }
        anoBoardGetDto.setTeamIds(teamIds);
        anoBoardGetDto.setTeamNames(teamNames);
        return anoBoardGetDto;
    }

    public void delete(Long boardId) {
        boardRepository.delete(
                boardRepository.findById(boardId).orElseThrow()
        );

    }
}
