package example.hanteo.domain.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnonymityBoard is a Querydsl query type for AnonymityBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnonymityBoard extends EntityPathBase<AnonymityBoard> {

    private static final long serialVersionUID = -1257727799L;

    public static final QAnonymityBoard anonymityBoard = new QAnonymityBoard("anonymityBoard");

    public final QBoard _super = new QBoard(this);

    //inherited
    public final StringPath boardName = _super.boardName;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final ListPath<TeamBoardTable, QTeamBoardTable> teams = this.<TeamBoardTable, QTeamBoardTable>createList("teams", TeamBoardTable.class, QTeamBoardTable.class, PathInits.DIRECT2);

    public QAnonymityBoard(String variable) {
        super(AnonymityBoard.class, forVariable(variable));
    }

    public QAnonymityBoard(Path<? extends AnonymityBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnonymityBoard(PathMetadata metadata) {
        super(AnonymityBoard.class, metadata);
    }

}

