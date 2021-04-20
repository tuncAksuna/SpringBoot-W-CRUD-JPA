package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// this interface is responsible for data access and it holds the user records
// access the objects and create its in order to store on database
// provides the CRUD operations
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // it equals to SELECT * FROM student WHERE email = ? in Sql
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
