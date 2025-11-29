package com.example.myproject.myproject.repo;

import com.example.myproject.myproject.model.Dukanam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DukanamRepo extends JpaRepository<Dukanam,Integer> {
    Optional<Dukanam> findByUserId(String userId);
}
