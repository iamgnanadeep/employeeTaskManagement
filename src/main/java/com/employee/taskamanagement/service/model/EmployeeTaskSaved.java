package com.employee.taskamanagement.service.model;

import org.springframework.stereotype.Component;
@Component
public class EmployeeTaskSaved {

	private String saveStatus;
	
   public EmployeeTaskSaved() {
	   
   }

	public String getSaveStatus() {
		return saveStatus;
	}
	
	public void setSaveStatus(String saveStatus) {
		this.saveStatus = saveStatus;
	}
		
}
