package ooad.payroll;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

@SuppressWarnings("serial")
public class GUIHelp extends JFrame {
	

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtrThisIsA;


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUIHelp frame = new GUIHelp();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUIHelp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIHelp.class.getResource("/ooad/payroll/Images/help.png")));
		setTitle("Help");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 491);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		txtrThisIsA = new JTextArea();
		txtrThisIsA.setWrapStyleWord(true);
		txtrThisIsA.setLineWrap(true);
		txtrThisIsA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrThisIsA.setText("This is a employee payroll application.\r\n\r\nThere are 3 types of employee, which is Manager, Staff and Salesman.\r\n\r\nFor employee ID format please follow AADDDD the first two alphabet only can consist of MA(manager), ST(staff) or SL(salesman) and follow up with four digit numbers.\r\n\r\nManager salary is calculated by adding up base salary and bonus.\r\n\r\nStaff's salary is calculated by adding up base salary and pay rate per hour times work hour per day times 31 days. \r\n\r\nSalesman's salary is calculated by adding up base salary and pay rate per sales times sales made in one month.\r\n\r\nManage employee is use to search employee and modify employee.\r\nSearch employee shows result if any one of the fields match.\r\nName and id with partially matched string will show up.\r\n\r\nModify employee cannot change employee type.\r\n\r\nSort employee will also change the arrangement of current list in the program.\r\nTo revert back the list, read the list from the file.\r\n\r\nCalculate salary can input value to calculate.\r\n\r\nThe employee data is read from a text file named \"employeeData\" in the source floder.\r\n  \r\nAll modification to the employee data in the program will only be saved into the text file using the read/write file function or select save when exit the program.");
		txtrThisIsA.setBackground(new Color(240, 240, 240));
		scrollPane.setViewportView(txtrThisIsA);
		contentPane.setLayout(gl_contentPane);
		

		
		this.setLocationRelativeTo(null);
	}
}
