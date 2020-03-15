package com.example.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.entity.Shows;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, Long> {

}
