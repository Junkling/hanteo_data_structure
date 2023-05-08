package example.hanteo.domain.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeamBoardTable is a Querydsl query type for TeamBoardTable
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeamBoardTable extends EntityPathBase<TeamBoardTable> {

    private static final long serialVersionUID = -162213418L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeamBoardTable teamBoardTable = new QTeamBoardTable("teamBoardTable");

    public final QBoard board;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final example.hanteo.domain.team.QTeam team;

    public QTeamBoardTable(String variable) {
        this(TeamBoardTable.class, forVariable(variable), INITS);
    }

    public QTeamBoardTable(Path<? extends TeamBoardTable> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeamBoardTable(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeamBoardTable(PathMetadata metadata, PathInits inits) {
        this(TeamBoardTable.class, metadata, inits);
    }

    public QTeamBoardTable(Class<? extends TeamBoardTable> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board")) : null;
        this.team = inits.isInitialized("team") ? new example.hanteo.domain.team.QTeam(forProperty("team")) : null;
    }

}

