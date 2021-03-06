package com.sgic.defect.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.common.api.response.ContentResponse;
import com.sgic.common.api.response.ListContentResponse;
import com.sgic.defect.dto.mapper.Mapper;
import com.sgic.defect.server.dto.PriorityDto;
import com.sgic.defect.server.entities.Priority;
import com.sgic.defect.server.services.PriorityService;

@RestController
@RequestMapping("/api/v1")
public class PriorityController {
	@Autowired
	PriorityService priorityService;

	@Autowired
	private Mapper mapper;

	//Add Priority
	@PostMapping(value = "/priority")
	public ResponseEntity<Object> createPriority(@RequestBody PriorityDto priorityData) {
		Priority priority = mapper.map(priorityData, Priority.class);
		priorityService.addPriority(priority);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.CREATED), HttpStatus.OK);	
	}
	
	//Get All Priority
	@GetMapping(value = "/priority")
	public ResponseEntity<Object> getAllPriority() {
		List<Priority> priority = priorityService.getAllPriority();
		List<PriorityDto> priorityData = mapper.map(priority, PriorityDto.class);
		return new ResponseEntity<>(new ListContentResponse<PriorityDto>("gfsyvvjkju",priorityData, RestApiResponseStatus.RECEIVED), HttpStatus.OK);	
	}
	
	//Update Priority
	@PutMapping(value = "/priority")
	public ResponseEntity<Object> updatePriority(@RequestBody PriorityDto priorityData) {
		Priority priority = mapper.map(priorityData, Priority.class);
		priorityService.addPriority(priority);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.UPDATED), HttpStatus.OK);	
	}
	
	//Delete Priority
	@DeleteMapping(value = "/priority")
	public ResponseEntity<Object> removePriority(@RequestBody PriorityDto priorityData) {
		Long id = priorityData.getId();
		if(priorityService.isIdExists(id)) {
			priorityService.deletePriority(id);
			return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.DELETED), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		}
	}	
	
	//Get Priority By Id
	@GetMapping(value = "/priority/{id}")
	public ResponseEntity<Object> getPriorityById(@PathVariable Long id) {
		Priority priority = priorityService.getPriorityById(id);
		PriorityDto priorityData = mapper.map(priority, PriorityDto.class);
		return new ResponseEntity<>(new ContentResponse<PriorityDto>("xyhhdgdfkkjx", priorityData, RestApiResponseStatus.RECEIVED), HttpStatus.OK);	
	}
  
}
