package ooad.payroll;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

/**
 * Main menu of the application
 *
 */
@SuppressWarnings("serial")
public class GUIMainMenu extends JFrame {
	
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel versionLabel;
	private JButton sortEmployeeButton;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUIMainMenu frame = new GUIMainMenu();
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
	public GUIMainMenu() {
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIMainMenu.class.getResource("/ooad/payroll/Images/payroll 4.png")));
		setForeground(Color.LIGHT_GRAY);
		
		
		setResizable(false);
		setTitle("Payroll Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255, 212, 161));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color (255, 212, 161));
		panel.setBounds(422, 475, 537, 172);
		panel.setLayout(new GridLayout(2, 3, 10, 10));
		
		JButton addEmpButton = new JButton("Add Employee");
		addEmpButton.setForeground(Color.BLACK);
		addEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIAddEmployee guiAddEmployee = new GUIAddEmployee();
				guiAddEmployee.setVisible(true);
			}
		});
		addEmpButton.setIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/add.png")));
		panel.add(addEmpButton);
		
		JButton manageEmployeeButton = new JButton("Manage Employee");
		manageEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIManageEmployee guiManageEmployee = new GUIManageEmployee();
				guiManageEmployee.setVisible(true);
			}
		});
		manageEmployeeButton.setIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/modify.png")));
		panel.add(manageEmployeeButton);
	
		JButton readWriteFileButton = new JButton("Read/Write File");
		readWriteFileButton.setIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/save.png")));
		readWriteFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIReadWriteFile guiReadWriteFile = new GUIReadWriteFile();
				guiReadWriteFile.setVisible(true);
			}
		});
		
		JButton calcSalaryButton = new JButton("Calculate Salary");
		calcSalaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUICalculateSalary guiCalculateSalary = new GUICalculateSalary();
				guiCalculateSalary.setVisible(true);
			}
		});
		
		sortEmployeeButton = new JButton("Sort Employee");
		sortEmployeeButton.setIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/sort.png")));
		sortEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUISortEmployee guiSortEmployee = new GUISortEmployee();
				guiSortEmployee.setVisible(true);
			}
		});
		panel.add(sortEmployeeButton);
		calcSalaryButton.setIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/calculate.png")));
		panel.add(calcSalaryButton);
		panel.add(readWriteFileButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/exit.png")));
		exitButton.setRolloverIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/exit_selected.png")));
		//Exit option
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					exitComfirm();
				}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exitComfirm();
			}
		});
		
		panel.add(exitButton);
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(154, 74, 626, 390);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/background2(orange).png")));
		
		versionLabel = new JLabel("");
		versionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		versionLabel.setForeground(Color.GRAY);
		versionLabel.setBounds(44, 607, 276, 40);
		versionLabel.setText(PayrollApplication.VERSION);
		contentPane.add(versionLabel);
		
		JButton helpButton = new JButton("Help");
		helpButton.setBounds(861, 424, 98, 40);
		contentPane.add(helpButton);
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIHelp guiHelp = new GUIHelp();
				guiHelp.setVisible(true);
			}
		});
		helpButton.setIcon(new ImageIcon(GUIMainMenu.class.getResource("/ooad/payroll/Images/help.png")));
		
		this.setLocationRelativeTo(null);
		
		
	}
	
	
	/**
	 * Show exit option
	 */
	private void exitComfirm() {
		Object[] options = {"Save and Exit", "Exit", "Cancel"}; 
		
		int n = JOptionPane.showOptionDialog(null,
				"Save before exit?",
			    null,
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[2]);
		
		switch (n)
		{
			case JOptionPane.YES_OPTION:
			{
				try {
					PayrollApplication.empDataList.writeFile();
					System.exit(1);
				}catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "employeeData.txt not found!");
					return; 
				}
				break;
			}
			case JOptionPane.NO_OPTION:
			{
				System.exit(1);
				break;
			}
		
		}
	}
}
