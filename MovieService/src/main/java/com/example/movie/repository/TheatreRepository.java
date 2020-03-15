package com.example.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

}
