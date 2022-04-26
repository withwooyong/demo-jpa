package com.example.demo.repository;

import com.example.demo.entity.Child;
import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Child> findByName(String name);
}
