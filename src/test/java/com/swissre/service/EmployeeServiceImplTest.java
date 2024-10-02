/**
 * 
 */
package com.swissre.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.swissre.pojo.Employee;
import com.swissre.service.impl.EmployeeServiceImpl;

/**
 * 
 */
public class EmployeeServiceImplTest {

	Map<Integer, Employee> employees;
	EmployeeService employeeService;

	@BeforeEach
	public void setUp() {
		employeeService = new EmployeeServiceImpl();
		employees = new HashMap<>();
		employees.put(123, new Employee(123, "Joe", "Doe", 60000L, null));
		employees.put(124, new Employee(124, "Martin", "Chekov", 45000L, 123));
		employees.put(125, new Employee(125, "Bob", "Ronstad", 47000L, 123));
		employees.put(300, new Employee(300, "Alice", "Hasacat", 50000L, 124));
		employees.put(305, new Employee(305, "Brett", "Hardleaf", 34000L, 300));
		employees.put(345, new Employee(345, "King", "Kohli", 34000L, 305));
		employees.put(377, new Employee(377, "Edward", "Steve", 34000L, 345));
		employees.put(309, new Employee(309, "MSD", "Ranchi", 34000L, 377));
//        employeeService.managerDirectReportiesMap(employees) (0, employees)
	}

	@Test
	public void calculateReportingLineTest() {
		String expected = "MSD Ranchi has a reporting Count of :: 6";
		List<String> reportingLine = employeeService.calculateReportingLines(employees);
		assertEquals(2, reportingLine.size());
		assertTrue(reportingLine.contains(expected));
	}

	@Test
	public void calculateSalaryDifferencesTest() {
		String expected = "Brett Hardleaf salary :: 34000.00 higer than the average salary of his direct reportees / subordinates.";
		List<String> salaryDifference = employeeService.calculateSalaryDifferences(employees);
		assertTrue(salaryDifference.contains(expected));
	}

	@Test
	public void managerDirectReporteesCount() {
		int expectedCount = 3;
		int count = employeeService.getManagerDirectReporteesCount(305, employees);
		assertEquals(expectedCount, count);
	}

	@Test
	public void managerDirectReportiesMapTest() {
		Map<Integer, List<Integer>> expected = new HashMap<Integer, List<Integer>>();
		expected.put(305, Arrays.asList(345));
		Map<Integer, List<Integer>> directReporteesMap = employeeService.managerDirectReportiesMap(employees);
		assertEquals(expected.get(305).get(0), directReporteesMap.get(305).get(0));
	}
}
