package com.deniz.ppmtool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	
	@PostMapping
	public ResponseEntity<?> addProject(@Valid @RequestBody Project project, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<String>("Invalid Project object", HttpStatus.BAD_REQUEST);
		}
		
		projectService.saveOrUpdate(project);
		return new ResponseEntity<>(project, HttpStatus.CREATED);
	}
}
