package com.example.movie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowsDTO {

	private Long showId;
	private String showTime;
	private Integer totalSeats;
	private Integer availablesSeats;
}
