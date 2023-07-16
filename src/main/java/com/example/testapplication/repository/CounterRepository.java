package com.example.testapplication.repository;

import com.example.testapplication.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, Long> {


}
