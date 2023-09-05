package com.employee.taskamanagement.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.taskamanagement.service.model.EmployeeTaskManagement;


public interface EmployeeTaskManagementService extends JpaRepository<EmployeeTaskManagement, Integer>{

	
	
}
