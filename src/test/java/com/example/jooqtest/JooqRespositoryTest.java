package com.example.jooqtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JooqRespositoryTest {

    @Autowired
    private JooqRespository jooqRespository;

    @Test
    void testSelectWithoutCodeGeneration() {
    }

    @Test
    void testSelectWithCodeGeneration() {
        jooqRespository.testSelectWithCodeGeneration();
    }
}