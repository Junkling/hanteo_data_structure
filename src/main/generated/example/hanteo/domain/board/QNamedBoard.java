package example.hanteo.domain.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNamedBoard is a Querydsl query type for NamedBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNamedBoard extends EntityPathBase<NamedBoard> {

    private static final long serialVersionUID = 2071165630L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNamedBoard namedBoard = new QNamedBoard("namedBoard");

    public final QBoard _super = new QBoard(this);

    //inherited
    public final StringPath boardName = _super.boardName;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final example.hanteo.domain.team.QTeam team;

    public QNamedBoard(String variable) {
        this(NamedBoard.class, forVariable(variable), INITS);
    }

    public QNamedBoard(Path<? extends NamedBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNamedBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNamedBoard(PathMetadata metadata, PathInits inits) {
        this(NamedBoard.class, metadata, inits);
    }

    public QNamedBoard(Class<? extends NamedBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new example.hanteo.domain.team.QTeam(forProperty("team")) : null;
    }

}

