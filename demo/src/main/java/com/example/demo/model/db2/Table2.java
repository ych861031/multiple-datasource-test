package com.example.demo.model.db2;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Table2")
public class Table2 {
    @Id
    private String test2;

}
