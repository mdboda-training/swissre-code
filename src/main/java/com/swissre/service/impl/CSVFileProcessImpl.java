/**
 * 
 */
package com.swissre.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.swissre.exception.SwissReExceptionHandler;
import com.swissre.pojo.Employee;
import com.swissre.service.CSVFileProcess;

/**
 * @author Muralidhar
 */
public class CSVFileProcessImpl implements CSVFileProcess{

	@Override
	public Map<Integer, Employee> csvEmployeeList(String fileLocation) throws SwissReExceptionHandler{
        Map<Integer, Employee> employees = new HashMap<>();
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileLocation));
			String line;
	        br.readLine(); 
	        Employee employee = null;
	        while ((line = br.readLine()) != null) {
	        	employee = new Employee();
	            String[] columns = line.split(",");
	            employee.setId(Integer.parseInt(columns[0].trim()));
	            employee.setFirstName(columns[1].trim());
	            employee.setLastName(columns[2].trim());
	            employee.setSalary(Long.parseLong(columns[3].trim()));
	            if(columns.length > 4 && !columns[4].trim().isEmpty()) {
	            	employee.setManagerId(Integer.parseInt(columns[4].trim()));
	            }
	            employees.put(employee.getId(), employee);
	        }
	        br.close();
		} catch (FileNotFoundException e) {
			throw new SwissReExceptionHandler("File not Found "+fileLocation);
		} catch (IOException e) {
			throw new SwissReExceptionHandler("Exception while reading the file "+fileLocation);
		}
        
        return employees;
    }

	
	
}
