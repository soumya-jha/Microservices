package com.example.movie.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "Movie")
@Getter
@Setter
public class Movie {
	
	@Column(name = "MovieId", nullable = false)
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long movieId;
	
	@Column(name = "MovieName")
	private String movieName;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Theatre> theatreList;

}
