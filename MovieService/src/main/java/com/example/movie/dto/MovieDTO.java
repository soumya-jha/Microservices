package com.example.movie.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {
	
	private Long movieId;	
	private String movieName;
	private List<TheatreDTO> theatreList;

}
