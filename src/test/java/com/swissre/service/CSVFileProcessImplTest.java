/**
 * 
 */
package com.swissre.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.swissre.exception.SwissReExceptionHandler;
import com.swissre.pojo.Employee;
import com.swissre.service.impl.CSVFileProcessImpl;

/**
 * 
 */
public class CSVFileProcessImplTest {

	CSVFileProcess csvFileProcess;
	
    
	@Test
	public void csvEmployeeListTest() throws SwissReExceptionHandler {
		csvFileProcess = new CSVFileProcessImpl();
		URL url = this.getClass().getClassLoader().getResource("employee.csv");
		Map<Integer, Employee> map= csvFileProcess.csvEmployeeList(url.getFile());
		assertNotNull(map);
		assertTrue(map.size()>0);
	}
}
