package com.deniz.ppmtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deniz.ppmtool.dao.ProjectRepository;
import com.deniz.ppmtool.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project saveOrUpdate(Project project) {
		
		
		return projectRepository.save(project);
	}

}
