package ooad.payroll;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Payroll application v1.6
 * 
 * Launch the application
 *
 */

public class PayrollApplication {
	
	protected static final String VERSION = "v1.6"; 
	protected static EmployeeManage empDataList = new EmployeeManage();
	private GUIMainMenu mainMenu;
	
	public static void main(String[] args) {

		new PayrollApplication();
		
	}
	

	public PayrollApplication() {
		
		try {
		empDataList.init();
		}catch (IOException e){
			JOptionPane.showMessageDialog(null, "employeeData.txt not found! Employee data is not readed.");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Wrong number format readed! Employee data is not readed.");
			e.printStackTrace();
		} catch (IllegalIdFormatException e) {
			JOptionPane.showMessageDialog(null, "Wrong employee ID readed! Employee data is not readed.");
			e.printStackTrace();
		}finally {		
			mainMenu = new GUIMainMenu();
			mainMenu.setVisible(true);
			
		};
		
		
		//set style 
		try {

		      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) { e.printStackTrace();

		}
	}
	
	
	
	
}
