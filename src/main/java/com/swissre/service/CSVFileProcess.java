package com.swissre.service;

import java.util.Map;

import com.swissre.exception.SwissReExceptionHandler;
import com.swissre.pojo.Employee;
/**
 * @author Muralidhar
 */
public interface CSVFileProcess {

	/**
	 * 
	 * @param fileLocation
	 * @return List<Employee>
	 */
	Map<Integer, Employee> csvEmployeeList(String fileLocation) throws SwissReExceptionHandler;
}
