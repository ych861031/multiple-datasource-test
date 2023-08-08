package com.example.demo.model.db1;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Table1")
public class Table1 {
    @Id
    private String test1;
}
