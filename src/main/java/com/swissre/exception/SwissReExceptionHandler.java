/**
 * 
 */
package com.swissre.exception;

import java.io.FileNotFoundException;

/**
 * @author Muralidhar
 */
public class SwissReExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public SwissReExceptionHandler(String message) {
		super(message);
	}


	public void fileNotFoundException(String fileName) throws FileNotFoundException{
		throw new FileNotFoundException("Given file : \""+fileName+"\" not found");
	}
}
