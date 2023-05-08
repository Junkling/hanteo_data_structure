package example.hanteo.domain.team;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeam is a Querydsl query type for Team
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeam extends EntityPathBase<Team> {

    private static final long serialVersionUID = -38446043L;

    public static final QTeam team = new QTeam("team");

    public final ListPath<example.hanteo.domain.board.TeamBoardTable, example.hanteo.domain.board.QTeamBoardTable> anonymityBoard = this.<example.hanteo.domain.board.TeamBoardTable, example.hanteo.domain.board.QTeamBoardTable>createList("anonymityBoard", example.hanteo.domain.board.TeamBoardTable.class, example.hanteo.domain.board.QTeamBoardTable.class, PathInits.DIRECT2);

    public final EnumPath<example.hanteo.domain.gender.GenderType> genderType = createEnum("genderType", example.hanteo.domain.gender.GenderType.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<example.hanteo.domain.board.NamedBoard, example.hanteo.domain.board.QNamedBoard> namedBoard = this.<example.hanteo.domain.board.NamedBoard, example.hanteo.domain.board.QNamedBoard>createList("namedBoard", example.hanteo.domain.board.NamedBoard.class, example.hanteo.domain.board.QNamedBoard.class, PathInits.DIRECT2);

    public final StringPath teamName = createString("teamName");

    public QTeam(String variable) {
        super(Team.class, forVariable(variable));
    }

    public QTeam(Path<? extends Team> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeam(PathMetadata metadata) {
        super(Team.class, metadata);
    }

}

