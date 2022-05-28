package com.example.jooqtest;

import com.example.jooqgen.tables.Book;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jooqgen.Tables.AUTHOR;
import static com.example.jooqgen.tables.Book.BOOK;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@RequiredArgsConstructor
@Repository
public class JooqRespository {

    private final DSLContext dslContext;

    public void testSelectWithoutCodeGeneration() {

        Query query = dslContext.select(field("BOOK.TITLE"), field("AUTHOR.FIRST_NAME"), field("AUTHOR.LAST_NAME"))
                .from(table("BOOK"))
                .join(table("AUTHOR"))
                .on(field("BOOK.AUTHOR_ID").eq(field("AUTHOR.ID")))
                .where(field("BOOK.PUBLISHED_IN").eq(1948));
        String sql = query.getSQL();
        List<Object> bindValues = query.getBindValues();

        System.out.println("bindValues = " + bindValues);
        System.out.println("sql = " + sql);
    }

    public void testSelectWithCodeGeneration() {

        Query query = dslContext.select(BOOK.TITLE, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                .from(BOOK)
                .join(AUTHOR)
                .on(BOOK.AUTHOR_ID.eq(AUTHOR.ID))
                .where(BOOK.PUBLISHED_IN.eq(1948l));

        String sql = query.getSQL();
        List<Object> bindValues = query.getBindValues();

        System.out.println("bindValues = " + bindValues);
        System.out.println("sql = " + sql);
    }
}
