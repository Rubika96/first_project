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
import com.sgic.defect.server.dto.SeverityDto;
import com.sgic.defect.server.entities.Severity;
import com.sgic.defect.server.services.SeverityService;
import com.sgic.defect.dto.mapper.Mapper;

@RestController
@RequestMapping("/api/v1")
public class SeverityController {

	@Autowired
	SeverityService severityService;

	@Autowired
	private Mapper mapper;

	//Add Severity
	@PostMapping(value = "/severity")
	public ResponseEntity<Object> createSeverity(@RequestBody SeverityDto severityData) {
		Severity severity = mapper.map(severityData, Severity.class);
		severityService.addSeverity(severity);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.CREATED), HttpStatus.OK);	
	}
	
	//Get All Severity
	@GetMapping(value = "/severity")
	public ResponseEntity<Object> getAllSeverity() {
		List<Severity> severity = severityService.getAllSeverity();
		List<SeverityDto> severityData = mapper.map(severity, SeverityDto.class);
		return new ResponseEntity<>(new ListContentResponse<SeverityDto>("gfsyvvjkju",severityData, RestApiResponseStatus.RECEIVED), HttpStatus.OK);	
	}
	
	//Update Severity
	@PutMapping(value = "/severity")
	public ResponseEntity<Object> updateSeverity(@RequestBody SeverityDto severityData) {
		Severity severity = mapper.map(severityData, Severity.class);
		severityService.addSeverity(severity);
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.UPDATED), HttpStatus.OK);	
	}
	
	//Delete Severity
	@DeleteMapping(value = "/severity")
	public ResponseEntity<Object> removeSeverity(@RequestBody SeverityDto severityData) {
		Long id = severityData.getId();
		if(severityService.isIdExists(id)) {
			severityService.deleteSeverity(id);
			return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.DELETED), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		}
	}	
	
	//Get Severity By Id
	@GetMapping(value = "/severity/{id}")
	public ResponseEntity<Object> getSeverityById(@PathVariable Long id) {
		Severity severity = severityService.getSeverityById(id);
		SeverityDto severityData = mapper.map(severity, SeverityDto.class);
		return new ResponseEntity<>(new ContentResponse<SeverityDto>("xyhhdgdfkkjx", severityData, RestApiResponseStatus.RECEIVED), HttpStatus.OK);	
	}
		
}
