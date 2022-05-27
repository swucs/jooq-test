package com.example.jooqtest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @Autowired
    private JooqRespository jooqRespository;

    @GetMapping("/")
    public String home() {
        jooqRespository.testSelect();
        return "success";
    }
}
