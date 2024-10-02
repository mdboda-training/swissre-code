/**
 * 
 */
package com.swissre.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Muralidhar
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer id;
	private String firstName;
	private String lastName;
	private Long salary;
	private Integer managerId;


	public Employee() {
	}

	public Employee(Integer id, String firstName, String lastName, Long salary, Integer managerId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.managerId = managerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

}
