package kr.co.demo.ch06.entity.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAComment is a Querydsl query type for AComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAComment extends EntityPathBase<AComment> {

    private static final long serialVersionUID = 631255326L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAComment aComment = new QAComment("aComment");

    public final QArticle article;

    public final StringPath author = createString("author");

    public final NumberPath<Integer> cno = createNumber("cno", Integer.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> wdate = createDateTime("wdate", java.time.LocalDateTime.class);

    public QAComment(String variable) {
        this(AComment.class, forVariable(variable), INITS);
    }

    public QAComment(Path<? extends AComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAComment(PathMetadata metadata, PathInits inits) {
        this(AComment.class, metadata, inits);
    }

    public QAComment(Class<? extends AComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new QArticle(forProperty("article"), inits.get("article")) : null;
    }

}

