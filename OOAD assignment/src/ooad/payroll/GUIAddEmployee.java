package ooad.payroll;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class GUIAddEmployee extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup empTypeButtonGroup = new ButtonGroup();
	
	private JRadioButton managerButton;
	private JRadioButton staffButton;
	private JRadioButton salesmanButton;
	
	private JLabel empSelectedLabel;
	private JLabel label2;
	private JLabel empIDLabel;
	private JLabel empNameLabel;
	private JLabel empGenderLabel;
	private JLabel empAgeLabel;
	private JLabel empSalaryLabel;
	private JLabel empHiredDateLabel;
	private JLabel label1;
	
	private JPanel empData;
	private JTextField empID;
	private JTextField empName;
	private JTextField empAge;
	private JTextField empSalary;
	private JTextField empHiredDate;
	private JTextField text1;
	private JTextField text2;
	
	private JButton addEmployeeButton;
	private JButton resetButton;
	private JPanel panel_2;
	private JRadioButton empMaleButton;
	private JRadioButton empFemaleButton;
	private final ButtonGroup genderButtonGroup = new ButtonGroup();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUIAddEmployee frame = new GUIAddEmployee();
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
	public GUIAddEmployee() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAddEmployee.class.getResource("/ooad/payroll/Images/add.png")));
		setTitle("Add an employee");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 35, 372, 23);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(10);
		
		JLabel lblNewLabel = new JLabel("Employee Type:");
		panel.add(lblNewLabel);
		
		managerButton = new JRadioButton("MANAGER");
		empTypeButtonGroup.add(managerButton);
		panel.add(managerButton);
		
		staffButton = new JRadioButton("STAFF");
		empTypeButtonGroup.add(staffButton);
		panel.add(staffButton);
		
		salesmanButton = new JRadioButton("SALESMAN");
		empTypeButtonGroup.add(salesmanButton);
		panel.add(salesmanButton);
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		empData = new JPanel();
		empData.setBounds(68, 69, 464, 384);
		contentPane.add(empData);
		empData.setLayout(new GridLayout(8, 2, 10, 20));
		
		empIDLabel = new JLabel("Employee ID:");
		empData.add(empIDLabel);
		
		empID = new JTextField();
		empID.setToolTipText("The ID is auto generated to prevent duplicate, ID can also set customly if there is no duplication");
		empID.setName("Employee ID");
		empData.add(empID);
		empID.setColumns(10);
		
		empNameLabel = new JLabel("Name:");
		empData.add(empNameLabel);
		
		empName = new JTextField();
		empName.setName("Employee Name");
		empData.add(empName);
		empName.setColumns(10);
		
		empGenderLabel = new JLabel("Gender:");
		empData.add(empGenderLabel);
		
		panel_2 = new JPanel();
		empData.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		empMaleButton = new JRadioButton("Male");
		empMaleButton.setActionCommand("Male");
		genderButtonGroup.add(empMaleButton);
		panel_2.add(empMaleButton);
		
		empFemaleButton = new JRadioButton("Female");
		empFemaleButton.setActionCommand("Female");
		genderButtonGroup.add(empFemaleButton);
		panel_2.add(empFemaleButton);
		
		empAgeLabel = new JLabel("Age:");
		empData.add(empAgeLabel);
		
		empAge = new JTextField();
		empAge.setName("Age");
		empData.add(empAge);
		empAge.setColumns(10);
		
		empSalaryLabel = new JLabel("Salary (RM) :");
		empData.add(empSalaryLabel);
		
		empSalary = new JTextField();
		empSalary.setToolTipText("This is the base salary for the employee");
		empSalary.setName("Salary");
		empData.add(empSalary);
		empSalary.setColumns(10);
		
		empHiredDateLabel = new JLabel("Hired Date (YYYY-MM-DD):");
		empData.add(empHiredDateLabel);
		
		empHiredDate = new JTextField();
		empHiredDate.setToolTipText("Please follow the date format");
		empHiredDate.setName("Hired Date");
		empData.add(empHiredDate);
		empHiredDate.setColumns(10);
		
		label1 = new JLabel("");
		empData.add(label1);
		
		text1 = new JTextField();
		text1.setEnabled(false);
		empData.add(text1);
		text1.setColumns(10);
		
		label2 = new JLabel("");
		empData.add(label2);
		
		text2 = new JTextField();
		text2.setEnabled(false);
		empData.add(text2);
		text2.setColumns(10);
		
		empSelectedLabel = new JLabel("Please select employe type first");
		empSelectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		empSelectedLabel.setBounds(184, 11, 240, 14);
		contentPane.add(empSelectedLabel);
		
		JButton empTypeGroupButton = new JButton("Select");
		empTypeGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectEmpButtonActionPerformed(arg0);
			}
		});
		empTypeGroupButton.setBounds(427, 26, 103, 35);
		contentPane.add(empTypeGroupButton);
		
		addEmployeeButton = new JButton("Add Employee");
		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEmpButtonActionPerformed(arg0);
			}
		});
		addEmployeeButton.setBounds(75, 470, 143, 45);
		contentPane.add(addEmployeeButton);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetButtonActionPerformed(arg0);
			}
		});
		resetButton.setBounds(370, 470, 143, 45);
		contentPane.add(resetButton);
	
		
		this.setLocationRelativeTo(null);
	}

	
	
	/**
	 * Add employee button 
	 */
	private void addEmpButtonActionPerformed(ActionEvent arg0) {
		
		if(managerButton.isSelected())
		{	
			text1.setName("Bonus");
			
			JTextField [] managerField = {empID, empName, empAge, empSalary, empHiredDate, text1};

			if(PayrollUtil.checkTextIsFilled(managerField))
			{
				String type = "MANAGER";
				String id = empID.getText();
				String name = empName.getText();
				String gender;
				
				if(genderButtonGroup.getSelection() == null)
				{
					JOptionPane.showMessageDialog(null, "Must select one of the gender type!");
					return;
				}
				else
				{	
					gender = genderButtonGroup.getSelection().getActionCommand();
				}
				
				String age = empAge.getText();
				String salary = empSalary.getText();
				String hiredDate = empHiredDate.getText();
				String bonus = text1.getText();
				
					try {
					Manager temp = new Manager(type, id, name, gender, Integer.parseInt(age), Double.parseDouble(salary), LocalDate.parse(hiredDate), Double.parseDouble(bonus));
					
					PayrollApplication.empDataList.addEmployee(temp);
					JOptionPane.showMessageDialog(null, "Employee Added.");
					resetValue();
					}
					catch (IllegalIdFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage() + " Employee Not Added.");
					}
					catch (DuplicateKeyException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage() + " is duplicated. Please enter a different one.");
					}
					catch (DateTimeParseException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong date format. Employee Not Added.");
					}
					catch (NumberFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong number format. Employee Not Added.");
					}
					catch (Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Employee Not Added.");
					}
				return;
			}
				
			
		}
		
		if(salesmanButton.isSelected())
		{
			text1.setName("Pay Rate Per Sales");
			text2.setName("Number of Sales Made");
		
			
			
			JTextField [] salesmanField = {empID, empName, empAge, empSalary, empHiredDate, text1, text2};

			if(PayrollUtil.checkTextIsFilled(salesmanField))
			{
				String type = "SALESMAN";
				String id = empID.getText();
				String name = empName.getText();
				String gender;
				
				if(genderButtonGroup.getSelection() == null)
				{
					JOptionPane.showMessageDialog(null, "Must select one of the gender type!");
					return;
				}
				else
				{	
					gender = genderButtonGroup.getSelection().getActionCommand();
				}
				
				String age = empAge.getText();
				String salary = empSalary.getText();
				String hiredDate = empHiredDate.getText();
				String payRatePerSales = text1.getText();
				String salesMade = text2.getText();
				
					try {
					Salesman temp = new Salesman(type, id, name, gender, Integer.parseInt(age), Double.parseDouble(salary), LocalDate.parse(hiredDate), Double.parseDouble(payRatePerSales), Integer.parseInt(salesMade));
					
					PayrollApplication.empDataList.addEmployee(temp);
					JOptionPane.showMessageDialog(null, "Employee Added.");
					resetValue();
					}
					catch (IllegalIdFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage() + " Employee Not Added.");
					}
					catch (DuplicateKeyException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage() + " is duplicated. Please enter a different one.");
					}
					catch (DateTimeParseException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong date format. Employee Not Added.");
					}
					catch (NumberFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong number format. Employee Not Added.");
					}
					catch (Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Employee Not Added.");
					}
				return;
			}
		}
		
		if(staffButton.isSelected())
		{
			text1.setName("Pay Rate Per Hour");
			text2.setName("Total Work Time per Day");
			
			JTextField [] staffField = {empID, empName, empAge, empSalary, empHiredDate, text1, text2};

			if(PayrollUtil.checkTextIsFilled(staffField))
			{
				String type = "STAFF";
				String id = empID.getText();
				String name = empName.getText();
				String gender;
				
				if(genderButtonGroup.getSelection() == null)
				{
					JOptionPane.showMessageDialog(null, "Must select one of the gender type!");
					return;
				}
				else
				{	
					gender = genderButtonGroup.getSelection().getActionCommand();
				}
				
				String age = empAge.getText();
				String salary = empSalary.getText();
				String hiredDate = empHiredDate.getText();
				String payRatePerHour = text1.getText();
				String totalWorkTime = text2.getText();
				
					try {
					Staff temp = new Staff(type, id, name, gender, Integer.parseInt(age), Double.parseDouble(salary), LocalDate.parse(hiredDate), Double.parseDouble(payRatePerHour), Integer.parseInt(totalWorkTime));
					
					PayrollApplication.empDataList.addEmployee(temp);	
					JOptionPane.showMessageDialog(null, "Employee Added.");
					resetValue();
					}
					catch (IllegalIdFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage() + " Employee Not Added.");
					}
					catch (DuplicateKeyException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage() + " is duplicated. Please enter a different one.");
					}
					catch (DateTimeParseException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong date format. Employee Not Added.");
					}
					catch (NumberFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong number format. Employee Not Added.");
					}
					catch (Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Employee Not Added.");
					}
				return;
			}
		}
			
	}

	/**
	 * Set employee button
	 * @param arg0
	 */
	private void selectEmpButtonActionPerformed(ActionEvent arg0) {
		
		if(empTypeButtonGroup.getSelection() == null)
		{
			JOptionPane.showMessageDialog(null, "Must select one of the employee type!");
		}
		
		if(managerButton.isSelected())
		{	
			empSelectedLabel.setText("Manager is selected.");
			empID.setText(PayrollApplication.empDataList.suggestEmpId(PayrollUtil.MANAGER));
			label1.setText("Bonus:");
			text1.setEnabled(true);
			text1.setToolTipText("Total salary is calculated by adding bonus.");
			label2.setText("");
			text2.setEnabled(false);
		}
		
		if(salesmanButton.isSelected())
		{
			empSelectedLabel.setText("Salesman is selected.");
			empID.setText(PayrollApplication.empDataList.suggestEmpId(PayrollUtil.SALESMAN));
			
			label1.setText("Pay Rate per Sales (RM):");
			text1.setEnabled(true);
			text1.setToolTipText("Salary for each sales made.");
			label2.setText("Number of Sales Made (times):");
			text2.setEnabled(true);
			text2.setToolTipText("Total sales made by the employee(per month).");
		}
		
		if(staffButton.isSelected())
		{
			empSelectedLabel.setText("Staff is selected.");
			empID.setText(PayrollApplication.empDataList.suggestEmpId(PayrollUtil.STAFF));
			label1.setText("Pay Rate per Hour (RM):");
			text1.setToolTipText("Salary for each hour worked.");
			text1.setEnabled(true);
			label2.setText("Total Work Time per Day (hour):");
			text2.setEnabled(true);
		}
	}
	
	/**
	 * Reset button 
	 * @param arg0
	 */
	private void resetButtonActionPerformed(ActionEvent arg0) {
		resetValue();
	}
	
	/**
	 * Reset all text fields method (does not reset employee type)
	 */
	private void resetValue() {
		empName.setText("");
		empID.setText("");
		empAge.setText("");
		empSalary.setText("");
		empHiredDate.setText("");
		text1.setText("");
		text2.setText("");
		genderButtonGroup.clearSelection();
		empSelectedLabel.setText("Please select employe type first");
	}
	
	

}
