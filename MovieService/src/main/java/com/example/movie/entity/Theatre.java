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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Theatre")
@Getter
@Setter
public class Theatre {
	
	@Column(name = "TheatreId", nullable = false)
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long theatreId;
	
	@Column(name = "TheatreName")
	private String theatreName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "movieId")
	private Movie movie;
	
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Shows> showList;

}
