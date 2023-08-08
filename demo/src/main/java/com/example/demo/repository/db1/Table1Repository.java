package com.example.demo.repository.db1;

import com.example.demo.model.db1.Table1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table1Repository extends JpaRepository<Table1,String> {
}
