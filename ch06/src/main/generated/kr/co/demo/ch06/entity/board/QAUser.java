package kr.co.demo.ch06.entity.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAUser is a Querydsl query type for AUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAUser extends EntityPathBase<AUser> {

    private static final long serialVersionUID = -2007582356L;

    public static final QAUser aUser = new QAUser("aUser");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath userid = createString("userid");

    public QAUser(String variable) {
        super(AUser.class, forVariable(variable));
    }

    public QAUser(Path<? extends AUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAUser(PathMetadata metadata) {
        super(AUser.class, metadata);
    }

}

