package com.deniz.ppmtool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deniz.ppmtool.entity.Project;
import com.deniz.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationError mapValidationError;
	
	@PostMapping
	public ResponseEntity<?> addProject(@Valid @RequestBody Project project, 
			BindingResult bindingResult) {
		
		ResponseEntity<?> errorMap = mapValidationError.mapValidationService(bindingResult);
		
		if (errorMap != null) {
			return errorMap;
		}
		
		projectService.saveOrUpdate(project);
		return new ResponseEntity<>(project, HttpStatus.CREATED);
	}
}
