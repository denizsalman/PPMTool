package com.deniz.ppmtool.dao;

import org.springframework.data.repository.CrudRepository;

import com.deniz.ppmtool.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	Iterable<Project> findAllById(Iterable<Long> ids);

	
}
