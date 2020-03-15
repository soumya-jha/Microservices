package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.TheatreDTO;
import com.example.movie.service.CommonService;

@RestController
public class CommonController {
	
	@Autowired
	CommonService commonService;
	
	@PostMapping(path = "/createTheatre", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createTheatre(@RequestBody TheatreDTO theatreDTO) throws Exception {
		String response = null;
		response = commonService.createTheatre(theatreDTO);
		return response;
	}
	
	@PostMapping(path = "/createMovie", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createTheatre(@RequestBody MovieDTO movieDTO) throws Exception {
		String response = null;
		response = commonService.createMovie(movieDTO);
		return response;
	}
	
	@PutMapping(path = "/bookTicket/{userId}/{showId}/{noOfSeats}", consumes = MediaType.TEXT_PLAIN_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
	public String bookTicket(@PathVariable Long userId, @PathVariable Long showId, @PathVariable Integer noOfSeats) throws Exception{
		String response = null;
		response = commonService.bookTicket(userId, showId, noOfSeats);
		return response;
	}
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
