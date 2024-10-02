/**
 * 
 */
package com.swissre.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.swissre.pojo.Employee;
import com.swissre.service.EmployeeService;

/**
 * @author Muralidhar
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	Integer minSalaryPercentage = 20;
	Integer maxSalaryPercentage = 50;
	
	@Override
	public Map<Integer, List<Integer>> managerDirectReportiesMap(Map<Integer, Employee> employees) {
		Map<Integer, List<Integer>> directReportees = new HashMap<>();
		for (Employee employee : employees.values()) {
			if (employee.getManagerId() != null) {
				directReportees.computeIfAbsent(employee.getManagerId(), k -> new ArrayList<>()).add(employee.getId());
			}
		}
		return directReportees;
	}

	@Override
	public List<String> calculateReportingLines(Map<Integer, Employee> employees) {
		List<String> longReportingLines = new ArrayList<>();
		for (Employee employee : employees.values()) {
			int count = getManagerDirectReporteesCount(employee.getId(), employees);
			if (count > 4) {
				longReportingLines.add(employee.getFirstName() + " " + employee.getLastName()
						+ " has a reporting Count of :: " + (count));
			}
		}
		return longReportingLines;
	}

	@Override
	public int getManagerDirectReporteesCount(int employeeId, Map<Integer, Employee> employees) {
		int managersHirearchy = 0;
		Integer managerId = employees.get(employeeId).getManagerId();
		while (managerId != null) {
			managersHirearchy++;
			managerId = employees.get(managerId).getManagerId();
		}
		return managersHirearchy;
	}

	@Override
	public List<String> calculateSalaryDifferences(Map<Integer, Employee> employees) {
		Map<Integer, List<Integer>> directReportees = managerDirectReportiesMap(employees);
		List<String> salaryDifference = new ArrayList<>();

		for (Map.Entry<Integer, List<Integer>> entry : directReportees.entrySet()) {
			int managerId = entry.getKey();
			Employee manager = employees.get(managerId);
			List<Integer> reportees = entry.getValue();

			if (!reportees.isEmpty()) {
				double avgSubSalary = reportees.stream().mapToLong(reporteeId -> employees.get(reporteeId).getSalary()).average()
						.orElse(0);
				double lowerBound = avgSubSalary * ((minSalaryPercentage)/100);
				double upperBound = avgSubSalary * ((maxSalaryPercentage)/100);

				if (manager.getSalary() < lowerBound) {
					salaryDifference.add(manager.getFirstName() + " " + manager.getLastName() + " salary :: "
							+ String.format("%.2f", lowerBound - manager.getSalary()) + " lesser than the average salary of his direct reportees / subordinates.");
				} else if (manager.getSalary() > upperBound) {
					salaryDifference.add(manager.getFirstName() + " " + manager.getLastName() + " salary :: "
							+ String.format("%.2f", manager.getSalary() - upperBound) + " higer than the average salary of his direct reportees / subordinates.");
				}
			}
		}
		return salaryDifference;
	}

}
