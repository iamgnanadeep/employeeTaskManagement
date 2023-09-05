package com.employee.taskamanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.taskamanagement.exception.ResourceNotFoundException;
import com.employee.taskamanagement.service.EmployeeTaskManagementService;
import com.employee.taskamanagement.service.model.EmployeeTaskManagement;
import com.employee.taskamanagement.service.model.EmployeeTaskSaved;

@RestController 
@CrossOrigin
public class EmployeeTaskManagementController {
	@Autowired
	EmployeeTaskManagementService employeeTaskManagementService;

	@Autowired
	EmployeeTaskSaved taskSaved;

	public String SAVED = "Successfully Persisted";
	public String DELETED = "Successfully Deleted";

	/**
	 * Method to get all Employee Tasks
	 */
	@GetMapping("/getEmployeeTaskManagement")
	public @ResponseBody List<EmployeeTaskManagement> getEmployeeTaskManagement() {
		return employeeTaskManagementService.findAll();
	}

	/**
	 * 
	 * @param taskManagement {@ EmployeeTaskManagement}
	 * @return
	 */
	@PostMapping("/saveEmployeeTaskManagement")
	public EmployeeTaskSaved saveEmployeeTaskManagement(@RequestBody EmployeeTaskManagement taskManagement) {
		employeeTaskManagementService.save(taskManagement);
		taskSaved.setSaveStatus(SAVED);
		return taskSaved;
	}

	/**
	 * 
	 * @param taskManagement {@ EmployeeTaskManagement}
	 * @return
	 */
	@PutMapping("/updateEmployeeTaskManagement/{id}")
	public EmployeeTaskSaved updateEmployeeTaskManagement(@PathVariable int id,
			@RequestBody EmployeeTaskManagement taskManagement) {
		EmployeeTaskManagement employeeTask = employeeTaskManagementService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		employeeTask.setTaskDescription(taskManagement.getTaskDescription());
		employeeTask.setTaskName(taskManagement.getTaskName());
		employeeTask.setTaskStatus(taskManagement.isTaskStatus());
		employeeTask.setTaskDescription(taskManagement.getTaskDescription());
		employeeTaskManagementService.save(employeeTask);
		taskSaved.setSaveStatus(SAVED);
		return taskSaved;
	}
	/**
	 * 
	 * @param taskManagement {@ EmployeeTaskManagement}
	 * @return
	 */
	@DeleteMapping("/deleteEmployeeTaskManagement/{id}")
	public EmployeeTaskSaved deleteEmployeeTaskManagement(@PathVariable int id) {
		EmployeeTaskManagement employeeTask = employeeTaskManagementService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	
		employeeTaskManagementService.delete(employeeTask);
		taskSaved.setSaveStatus(DELETED);
		return taskSaved;
	}
}
