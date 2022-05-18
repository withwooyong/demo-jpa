package com.example.demo.repository;

import com.example.demo.entity.test.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildRepository extends JpaRepository<Child, Long> {

    Optional<Child> findByName(String name);
}
