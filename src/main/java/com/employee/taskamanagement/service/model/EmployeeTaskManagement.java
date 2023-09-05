package com.employee.taskamanagement.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Employee Task Management persistance
 * @author gnanadeep.vetukuri
 *
 */
@Entity
public class EmployeeTaskManagement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String taskName;
	
	private String taskDescription;
	
	private boolean taskStatus;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public boolean isTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(boolean taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	
	
	
	
}
