package exceptions;

/**
 * Exception used to handle management of Employees
 * @author Huy Le
 */
public class EmployeeDBException extends Exception {
    public EmployeeDBException() {
		
    }
	
    public EmployeeDBException(String message) {
	super(message);
    }
}
