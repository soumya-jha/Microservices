package com.example.movie.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Shows")
@Getter
@Setter
public class Shows {
	
	@Column(name = "ShowId", nullable = false)
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long showId;
	
	@Column(name = "ShowTime")
	private String showTime;
	
	@Column(name = "TotalSeats")
	private Integer totalSeats;
	
	@Column(name = "AvailableSeats")
	private Integer availablesSeats;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "theatreId")
	private Theatre theatre;

}
