/**
 * 
 */
package com.swissre.service;

import java.util.List;
import java.util.Map;

import com.swissre.pojo.Employee;

/**
 * @author Muralidhar
 */
public interface EmployeeService {
	
	Map<Integer, List<Integer>> managerDirectReportiesMap(Map<Integer, Employee> employees) ;
	
	List<String> calculateReportingLines(Map<Integer, Employee> employees);
	
	int getManagerDirectReporteesCount(int employeeId, Map<Integer, Employee> employees);
	
	List<String> calculateSalaryDifferences(Map<Integer, Employee> employees);

}
