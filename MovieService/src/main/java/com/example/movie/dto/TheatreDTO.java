package com.example.movie.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreDTO {
	
	private Long theatreId;
	private String theatreName;
	private List<ShowsDTO> showList;

}
