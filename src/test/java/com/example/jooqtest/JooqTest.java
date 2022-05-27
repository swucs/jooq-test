package com.example.jooqtest;

import org.jooq.DSLContext;
import org.jooq.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

//@SpringBootTest
@org.springframework.boot.test.autoconfigure.jooq.JooqTest
public class JooqTest {

    private DSLContext dsl;

    public JooqTest(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Test
    public void testSelect() {

        Query query = dsl.select(field("BOOK.TITLE"), field("AUTHOR.FIRST_NAME"), field("AUTHOR.LAST_NAME"))
                .from(table("BOOK"))
                .join(table("AUTHOR"))
                .on(field("BOOK.AUTHOR_ID").eq(field("AUTHOR.ID")))
                .where(field("BOOK.PUBLISHED_IN").eq(1948));
        String sql = query.getSQL();
        List<Object> bindValues = query.getBindValues();

        System.out.println("bindValues = " + bindValues);
        System.out.println("sql = " + sql);
    }
}
