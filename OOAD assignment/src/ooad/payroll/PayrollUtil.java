package ooad.payroll;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This class provides some utility function
 * 
 *
 */
public class PayrollUtil {
	
	public final static int MANAGER = 0;
	public final static int SALESMAN = 1;
	public final static int STAFF = 2;
	
	//convert final constant to string 
	public static String typeToString (int empType)
	{
		int type = empType;
		switch(type)
		{
		case 0:
			{
				return "MANAGER";
			}
		case 1:
			{
				return "SALESMAN";
			}
		case 2:
			{
				return "STAFF";
			}
		default:
				return null;
		}
	}
	
	
	public static boolean stringIsEmpty (String s)
	{
		if (s== null || "".equals(s.trim()))
			return true;
		else
			return false;
	}
	
	public static boolean stringIsNotEmpty (String s)
	{
		if (!(s== null || "".equals(s.trim()))) {
			return true;
		} else {
			return false;
		}
	}
		

	/**
	 * Check that is all text field required has been filled
	 * @param text
	 * @return
	 */
	public static boolean checkTextIsFilled (JTextField [] text)
	{
		for(JTextField tf:text)
		{	
			if (PayrollUtil.stringIsEmpty(tf.getText()))
			{
				JOptionPane.showMessageDialog(null, tf.getName() + " is empty.");
				return false;
			}
		}
		return true;
	}
	
}
