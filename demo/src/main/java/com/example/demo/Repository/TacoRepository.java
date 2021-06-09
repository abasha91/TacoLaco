package com.example.demo.Repository;

import com.example.demo.Model.Taco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {
    public Taco findByType(String type);
}
