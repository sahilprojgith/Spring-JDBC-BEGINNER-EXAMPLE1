package com.telusko.spring_data_jpa_ex.repo;

import com.telusko.spring_data_jpa_ex.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo  extends JpaRepository<Student,Integer> { //primary key-roll no -whic is Integer.

    @Query("select s from Student s where s.name = ?1") //even if it isn't there is would work.
    List<Student> findByName(String name);
    // JPA already have the methods you want to look, well most of it.



}
