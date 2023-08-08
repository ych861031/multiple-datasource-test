package com.example.demo.repository.db2;

import com.example.demo.model.db2.Table2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table2Repository extends JpaRepository<Table2,String> {
}
