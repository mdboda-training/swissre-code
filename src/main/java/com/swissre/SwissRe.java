/**
 * 
 */
package com.swissre;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.swissre.exception.SwissReExceptionHandler;
import com.swissre.pojo.Employee;
import com.swissre.service.CSVFileProcess;
import com.swissre.service.EmployeeService;
import com.swissre.service.impl.CSVFileProcessImpl;
import com.swissre.service.impl.EmployeeServiceImpl;

/**
 * @author Muralidhar
 */
public class SwissRe {

	static EmployeeService employeeService = new EmployeeServiceImpl();
	static CSVFileProcess csvFileProcess = new CSVFileProcessImpl();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			SwissRe swissRe = new SwissRe();
			URL url = swissRe.getClass().getClassLoader().getResource("employee.csv");
			File file = new File(url.getFile());
			System.out.println(file.getAbsolutePath() +"  "+file.exists());
			String filePath = "";
			if(file.exists()) {
				filePath = file.getAbsolutePath();
			}else {
				System.out.println("Employee file Path:: ");
				Scanner scanner = new Scanner(System.in);
				filePath = scanner.nextLine();
				scanner.close();
			}
		    Map<Integer, Employee> employees = csvFileProcess.csvEmployeeList(filePath);
			
			List<String> longReportingLines = employeeService.calculateReportingLines(employees);
			System.out.println("Employees List with long reporting line:");
			for (String line : longReportingLines) {
				System.out.println(line);
			}
			
			List<String> salaryDifferences = employeeService.calculateSalaryDifferences(employees);
			System.out.println("Salary Differences::");
			for (String difference : salaryDifferences) {
				System.out.println(difference);
			}
			
			
		} catch (SwissReExceptionHandler e) {
			e.printStackTrace();
		}

	}

}
