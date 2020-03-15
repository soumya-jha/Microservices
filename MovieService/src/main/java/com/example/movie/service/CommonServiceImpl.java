package com.example.movie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.TheatreDTO;
import com.example.movie.entity.Shows;
import com.example.movie.repository.ShowsRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	ShowsRepository showsRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public String createTheatre(TheatreDTO theatreDTO) throws Exception {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public String createMovie(MovieDTO movieDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallBack", commandKey = "orderKey", 
	commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")}) //value for timeout in mS.
	public String bookTicket(Long userId, Long showId, Integer noOfSeats) throws Exception {
		// TODO Auto-generated method stub
		Boolean orderResponse = false;
		Optional<Shows> showOptional = showsRepository.findById(showId);
		if(showOptional.isPresent()) {
			Shows shows = showOptional.get();
			if(shows.getAvailablesSeats()>=noOfSeats) {
				//call order service
				System.out.println("Before calling order service");
				ResponseEntity<Boolean> responseEntity  = restTemplate.exchange("http://order-service/order/create/"+userId+"/"+showId, 
						HttpMethod.POST, null, Boolean.class);
				System.out.println("After calling order service");
				orderResponse = responseEntity.getBody();
				if(orderResponse) {
					shows.setAvailablesSeats(shows.getAvailablesSeats()-noOfSeats);
					showsRepository.save(shows);
				}
			}
		}
		return "Tickets Booked";
	}
	
	public String fallBack(Long userId, Long showId, Integer noOfSeats) {
		//Method signature of fallback should be same as the method where hystrix is used.
		return "Fallback received while booking showId  :: " + showId;
		
	}

}
