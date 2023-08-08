package com.example.demo.controller;

import com.example.demo.repository.db1.Table1Repository;
import com.example.demo.repository.db2.Table2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    Table1Repository table1Repository;

    @Autowired
    Table2Repository table2Repository;

    @GetMapping("/test")
    public void getTest(){
        System.out.println(table1Repository.findAll());
        System.out.println(table2Repository.findAll());
    }
}
