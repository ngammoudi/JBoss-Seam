package com.businessdecision.seampoc.util;

import org.jboss.seam.annotations.ApplicationException;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.exception.Redirect;

/**
 * 
 * @author ngamoudi
 * 
 */
@Name("concurerentDataAccessException"	)
@Redirect(viewId="editEmployee.xhtml",message="EEEEEEEEEE")
 @ApplicationException(rollback=true)
public class ConcurrentDataAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConcurrentDataAccessException() {
		super();

	}

	public ConcurrentDataAccessException(String message, Throwable cause) {
		super(message, cause);

	}

}
