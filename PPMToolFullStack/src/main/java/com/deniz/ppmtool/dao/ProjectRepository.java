package com.deniz.ppmtool.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deniz.ppmtool.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}
