package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.TheatreDTO;

public interface CommonService{
	
	public String createTheatre(TheatreDTO theatreDTO) throws Exception;
	public String createMovie(MovieDTO movieDTO) throws Exception;
	public String bookTicket(Long userId, Long showId, Integer noOfSeats) throws Exception;

}
