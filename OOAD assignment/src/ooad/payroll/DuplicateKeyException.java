package ooad.payroll;

@SuppressWarnings("serial")
public class DuplicateKeyException extends Exception{


	//Construct exception with details 
	public DuplicateKeyException(String str) {
		super(str);
	}
	
	
	public DuplicateKeyException() {
	
	}

	

}
