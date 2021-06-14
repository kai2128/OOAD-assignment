package ooad.payroll;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class GUIManageEmployee extends JFrame {
	

	private JPanel contentPane;
	private JScrollPane employeeTablePanel;
	private JPanel searchPanel;
	private JLabel s_idLabel;
	private JLabel s_nameLabel;
	private JButton searchButton;
	private JTextField s_idTextField;
	private JTextField s_nameTextField;
	private JLabel s_typeLabel;
	private JComboBox<String> s_typeComboBox;
	private JPanel modifyPanel;
	private JLabel empTypeLabel;
	private JLabel empIDLabel;
	private JLabel empNameLabel;
	private JLabel empGenderLabel;
	private JLabel empAgeLabel;
	private JLabel empSalaryLabel;
	private JLabel empDateHiredLabel;
	private JLabel empLabel1;
	private JLabel empLabel2;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField salaryTextField;
	private JTextField dateHiredTextField;
	private JTextField textField1;
	private JTextField textField2;
	private JComboBox<String> typeComboBox;
	private JComboBox<String> genderComboBox;
	private JButton modifyEmpButton;
	private JButton deleteEmpButton;
	private JTable employeeTable;
	
	private int indexOfSelectedEmp;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUIManageEmployee frame = new GUIManageEmployee();
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
	public GUIManageEmployee() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIManageEmployee.class.getResource("/ooad/payroll/Images/modify.png")));
		setTitle("Modify Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		employeeTablePanel = new JScrollPane();
		
		employeeTable = new JTable();
		employeeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				employeeTableMousePressed(arg0);
			}
		});
		employeeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Type", "ID", "Name", "Gender", "Age", "Date Hired", "Salary", "Bonus", "Pay Rate", "Work Hour", "Sales Made"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		employeeTable.getColumnModel().getColumn(0).setPreferredWidth(56);
		employeeTable.getColumnModel().getColumn(1).setPreferredWidth(58);
		employeeTable.getColumnModel().getColumn(3).setPreferredWidth(58);
		employeeTable.getColumnModel().getColumn(4).setPreferredWidth(39);
		employeeTable.getColumnModel().getColumn(5).setPreferredWidth(71);
		employeeTable.getColumnModel().getColumn(7).setPreferredWidth(53);
		employeeTable.getColumnModel().getColumn(8).setPreferredWidth(62);
		employeeTable.getColumnModel().getColumn(9).setPreferredWidth(71);
		employeeTablePanel.setViewportView(employeeTable);
		
		searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(null, "Search employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setLayout(null);
		
		s_idLabel = new JLabel("ID:");
		s_idLabel.setBounds(224, 38, 21, 14);
		searchPanel.add(s_idLabel);
		
		s_nameLabel = new JLabel("Name:");
		s_nameLabel.setBounds(407, 38, 39, 14);
		searchPanel.add(s_nameLabel);
		
		searchButton = new JButton("Search");
		searchButton.setIcon(new ImageIcon(GUIManageEmployee.class.getResource("/ooad/payroll/Images/search.png")));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchbuttonActionPerformed(arg0);
			}
		});
		searchButton.setBounds(610, 29, 120, 33);
		searchPanel.add(searchButton);
		
		s_idTextField = new JTextField();
		s_idTextField.setBounds(253, 35, 113, 20);
		searchPanel.add(s_idTextField);
		s_idTextField.setColumns(10);
		
		s_nameTextField = new JTextField();
		s_nameTextField.setBounds(447, 35, 153, 20);
		searchPanel.add(s_nameTextField);
		s_nameTextField.setColumns(10);
		
		s_typeLabel = new JLabel("Type:");
		s_typeLabel.setBounds(10, 38, 81, 14);
		searchPanel.add(s_typeLabel);
		
		s_typeComboBox = new JComboBox<String>();
		s_typeComboBox.addItem("");
		s_typeComboBox.addItem("MANAGER");
		s_typeComboBox.addItem("STAFF");
		s_typeComboBox.addItem("SALESMAN");
		s_typeComboBox.setBounds(62, 35, 113, 20);
		searchPanel.add(s_typeComboBox);
		
		lblNewLabel = new JLabel("Any one match will show up in the table. If no input, search will display all data.");
		lblNewLabel.setBounds(10, 63, 644, 14);
		searchPanel.add(lblNewLabel);
		
		modifyPanel = new JPanel();
		modifyPanel.setBorder(new TitledBorder(null, "Modify employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		modifyPanel.setLayout(null);
		
		empTypeLabel = new JLabel("Type:");
		empTypeLabel.setBounds(10, 35, 46, 14);
		modifyPanel.add(empTypeLabel);
		
		empIDLabel = new JLabel("ID:");
		empIDLabel.setBounds(10, 71, 46, 14);
		modifyPanel.add(empIDLabel);
		
		empNameLabel = new JLabel("Name:");
		empNameLabel.setBounds(10, 108, 46, 14);
		modifyPanel.add(empNameLabel);
		
		empGenderLabel = new JLabel("Gender:");
		empGenderLabel.setBounds(10, 151, 46, 14);
		modifyPanel.add(empGenderLabel);
		
		empAgeLabel = new JLabel("Age:");
		empAgeLabel.setBounds(10, 195, 46, 14);
		modifyPanel.add(empAgeLabel);
		
		empSalaryLabel = new JLabel("Salary:");
		empSalaryLabel.setBounds(262, 71, 140, 14);
		modifyPanel.add(empSalaryLabel);
		
		empDateHiredLabel = new JLabel("Date Hire(YYYY-MM-DD):");
		empDateHiredLabel.setBounds(262, 35, 140, 14);
		modifyPanel.add(empDateHiredLabel);
		
		empLabel1 = new JLabel("");
		empLabel1.setBounds(262, 108, 140, 14);
		modifyPanel.add(empLabel1);
		
		empLabel2 = new JLabel("");
		empLabel2.setBounds(262, 151, 140, 14);
		modifyPanel.add(empLabel2);
		
		idTextField = new JTextField();
		idTextField.setBounds(81, 68, 171, 20);
		modifyPanel.add(idTextField);
		idTextField.setColumns(10);
		idTextField.setName("ID");
		
		nameTextField = new JTextField();
		nameTextField.setBounds(81, 105, 171, 20);
		modifyPanel.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setName("Name");
		
		ageTextField = new JTextField();
		ageTextField.setBounds(81, 192, 171, 20);
		modifyPanel.add(ageTextField);
		ageTextField.setColumns(10);
		ageTextField.setName("Age");
		
		salaryTextField = new JTextField();
		salaryTextField.setBounds(412, 68, 142, 20);
		modifyPanel.add(salaryTextField);
		salaryTextField.setColumns(10);
		salaryTextField.setName("Salary");
		
		dateHiredTextField = new JTextField();
		dateHiredTextField.setBounds(412, 32, 142, 20);
		modifyPanel.add(dateHiredTextField);
		dateHiredTextField.setColumns(10);
		dateHiredTextField.setName("Date Hired");
		
		textField1 = new JTextField();
		textField1.setEnabled(false);
		textField1.setBounds(412, 108, 142, 20);
		modifyPanel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setEnabled(false);
		textField2.setBounds(412, 151, 142, 20);
		modifyPanel.add(textField2);
		textField2.setColumns(10);
		
		typeComboBox = new JComboBox<String>();
		typeComboBox.setEnabled(false);
		typeComboBox.setEditable(false);
		typeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"MANAGER", "STAFF", "SALESMAN"}));
		typeComboBox.setBounds(81, 32, 171, 20);
		modifyPanel.add(typeComboBox);
		
		
		genderComboBox = new JComboBox<String>();
		genderComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Male", "Female"}));
		genderComboBox.setBounds(81, 148, 171, 20);
		modifyPanel.add(genderComboBox);
		
		modifyEmpButton = new JButton("Modify ");
		modifyEmpButton.setIcon(new ImageIcon(GUIManageEmployee.class.getResource("/ooad/payroll/Images/change.png")));
		modifyEmpButton.setEnabled(false);
		modifyEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modifyEmpButtonActionPerfomed(arg0);
			}
		});
		modifyEmpButton.setBounds(595, 32, 128, 62);
		modifyPanel.add(modifyEmpButton);
		
		deleteEmpButton = new JButton("Delete ");
		deleteEmpButton.setRolloverIcon(new ImageIcon(GUIManageEmployee.class.getResource("/ooad/payroll/Images/delete_selected.png")));
		deleteEmpButton.setIcon(new ImageIcon(GUIManageEmployee.class.getResource("/ooad/payroll/Images/delete.png")));
		deleteEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteEmpButtonActionPerformed(arg0);
			}
		});
		deleteEmpButton.setEnabled(false);
		deleteEmpButton.setBounds(595, 148, 128, 62);
		modifyPanel.add(deleteEmpButton);
		
		lblNewLabel_1 = new JLabel("Select one of the row in the table to select employee.");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(searchPanel, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(employeeTablePanel, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(modifyPanel, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(searchPanel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(employeeTablePanel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addComponent(modifyPanel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		
		fillTable(PayrollApplication.empDataList.getEmployeeList());
		
		this.setLocationRelativeTo(null);
		
	}

	/**
	 * Delete employee
	 * @param arg0
	 */
	private void deleteEmpButtonActionPerformed(ActionEvent arg0) {
		int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Employee", JOptionPane.YES_NO_OPTION);
		
		switch (choice)
		{
		case JOptionPane.YES_OPTION:
		{
			PayrollApplication.empDataList.deleteEmployee(indexOfSelectedEmp);
			JOptionPane.showMessageDialog(null, "Employee Deleted");
			return;
		}
		case JOptionPane.NO_OPTION:
		{
			return;
		}
		}
		
	}
	
	/**
	 * Modify Selected employee 
	 * @param arg0
	 */
	private void modifyEmpButtonActionPerfomed(ActionEvent arg0) {
		

		if(typeComboBox.getSelectedIndex() == 0)
		{	
			JTextField [] managerField = {idTextField, nameTextField, ageTextField, salaryTextField, dateHiredTextField, textField1};
			
			if(PayrollUtil.checkTextIsFilled(managerField))
			{
				String type = "MANAGER";
				String id = idTextField.getText();
				String name = nameTextField.getText();
				String gender = (String) genderComboBox.getSelectedItem();	
				String age = ageTextField.getText();
				String salary = salaryTextField.getText();
				String hiredDate = dateHiredTextField.getText();
				
				String bonus = textField1.getText();
				
					try {
					Manager temp = new Manager(type, id, name, gender, Integer.parseInt(age), Double.parseDouble(salary), LocalDate.parse(hiredDate), Double.parseDouble(bonus));
					
					PayrollApplication.empDataList.modifyEmployee(indexOfSelectedEmp, temp);
					JOptionPane.showMessageDialog(null, "Employee Modified.");
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
						JOptionPane.showMessageDialog(null, "Wrong date format. Employee Not Modified.");
					}
					catch (NumberFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong number format. Employee Not Modified.");
					}
					catch (Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Employee Not Modified.");
					}
					return;
			}	
		}
		
		if(typeComboBox.getSelectedIndex() == 1)
		{
			JTextField [] staffField = {idTextField, nameTextField, ageTextField, salaryTextField, dateHiredTextField, textField1, textField2};

			if(PayrollUtil.checkTextIsFilled(staffField))
			{
				String type = "STAFF";
				String id = idTextField.getText();
				String name = nameTextField.getText();
				String gender = (String) genderComboBox.getSelectedItem();
				String age = ageTextField.getText();
				String salary = salaryTextField.getText();
				String hiredDate = dateHiredTextField.getText();
				
				String payRatePerHour = textField1.getText();
				String totalWorkTime = textField2.getText();
	
				
					try {
					Staff temp = new Staff(type, id, name, gender, Integer.parseInt(age), Double.parseDouble(salary), LocalDate.parse(hiredDate), Double.parseDouble(payRatePerHour), Integer.parseInt(totalWorkTime));
					
					PayrollApplication.empDataList.modifyEmployee(indexOfSelectedEmp, temp);
					JOptionPane.showMessageDialog(null, "Employee Modified.");
					
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
						JOptionPane.showMessageDialog(null, "Wrong date format. Employee Not Modified.");
					}
					catch (NumberFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong number format. Employee Not Modified.");
					}
					catch (Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Employee Not Modified.");
					}
				return;
			}
		}
		
		if(typeComboBox.getSelectedIndex() == 2)
		{
						
			JTextField [] salesmanField = {idTextField, nameTextField, ageTextField, salaryTextField, dateHiredTextField, textField1, textField2};

			if(PayrollUtil.checkTextIsFilled(salesmanField))
			{
				String type = "STAFF";
				String id = idTextField.getText();
				String name = nameTextField.getText();
				String gender = (String) genderComboBox.getSelectedItem();
				String age = ageTextField.getText();
				String salary = salaryTextField.getText();
				String hiredDate = dateHiredTextField.getText();
				
				String payRatePerSales = textField1.getText();
				String salesMade = textField2.getText();
				
					try {
					Salesman temp = new Salesman(type, id, name, gender, Integer.parseInt(age), Double.parseDouble(salary), LocalDate.parse(hiredDate), Double.parseDouble(payRatePerSales), Integer.parseInt(salesMade));
					
					PayrollApplication.empDataList.modifyEmployee(indexOfSelectedEmp, temp);
					JOptionPane.showMessageDialog(null, "Employee Modified.");
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
						JOptionPane.showMessageDialog(null, "Wrong date format. Employee Not Modified.");
					}
					catch (NumberFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Wrong number format. Employee Not Modified.");
					}
					catch (Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Employee Not Modified.");
					}
				return;
			}
		}
		
	}
	
	/**
	 * Select employee from table
	 * @param arg0
	 */
	private void employeeTableMousePressed(MouseEvent arg0) {
		int i = this.employeeTable.getSelectedRow();
		
		String selectedID = (String) employeeTable.getValueAt(i, 1);
		
		Employee selectedEmp = PayrollApplication.empDataList.findEmployeeId(selectedID);
		indexOfSelectedEmp = PayrollApplication.empDataList.getIndex(selectedEmp);
		modifyEmpButton.setEnabled(true);
		deleteEmpButton.setEnabled(true);
		
	
		if (selectedEmp instanceof Manager)
		{
			resetText();
			
			
			typeComboBox.setSelectedItem("MANAGER");
			idTextField.setText(selectedEmp.getEmpId());
			nameTextField.setText(selectedEmp.getName());
			genderComboBox.setSelectedItem(selectedEmp.getGender());
			ageTextField.setText(Integer.toString(selectedEmp.getAge()));
			dateHiredTextField.setText(selectedEmp.getHiredDate().toString());
			salaryTextField.setText(Double.toString(selectedEmp.getSalary()));
			
			empLabel1.setText("Bonus:");
			textField1.setText(Double.toString(((Manager) selectedEmp).getBonus()));
			
			textField1.setEditable(true);
			textField1.setEnabled(true);
			
			textField1.setName("Bonus");
			
		}
		else if (selectedEmp instanceof Salesman)
		{
			resetText();
			
			typeComboBox.setSelectedItem("SALESMAN");
			idTextField.setText(selectedEmp.getEmpId());
			nameTextField.setText(selectedEmp.getName());
			genderComboBox.setSelectedItem(selectedEmp.getGender());
			ageTextField.setText(Integer.toString(selectedEmp.getAge()));
			dateHiredTextField.setText(selectedEmp.getHiredDate().toString());
			salaryTextField.setText(Double.toString(selectedEmp.getSalary()));
			
			empLabel1.setText("Pay Rate Per Sales:");
			textField1.setText(Double.toString(((Salesman) selectedEmp).getPayRatePerSales()));
			
			empLabel2.setText("Number of Sales Made:");
			textField2.setText(Integer.toString(((Salesman) selectedEmp).getSalesMade()));
			
			textField1.setEditable(true);
			textField1.setEnabled(true);
		
			textField2.setEditable(true);
			textField2.setEnabled(true);
			
			textField1.setName("Pay Rate Per Sales");
			textField2.setName("Number of Sales Made");
			
		}
		else 
		{
			resetText();
			
			typeComboBox.setSelectedItem("STAFF");
			idTextField.setText(selectedEmp.getEmpId());
			nameTextField.setText(selectedEmp.getName());
			genderComboBox.setSelectedItem(selectedEmp.getGender());
			ageTextField.setText(Integer.toString(selectedEmp.getAge()));
			dateHiredTextField.setText(selectedEmp.getHiredDate().toString());
			salaryTextField.setText(Double.toString(selectedEmp.getSalary()));
			
			empLabel1.setText("Pay Rate Per Hour:");
			textField1.setText(Double.toString(((Staff) selectedEmp).getPayRatePerHour()));
			
			empLabel2.setText("Work Time: ");
			textField2.setText(Integer.toString(((Staff) selectedEmp).getTotalWorkTimePerDay()));
					
			textField1.setEditable(true);
			textField1.setEnabled(true);
			
			textField2.setEditable(true);
			textField2.setEnabled(true);
			
			textField1.setName("Pay Rate Per Hour");
			textField2.setName("Work Time");
			
		}
		
	}

	/**
	 * Search Employee using type, ID or name 
	 * @param arg0
	 */
	private void searchbuttonActionPerformed(ActionEvent arg0) {
		
		String type = this.s_typeComboBox.getSelectedItem().toString();
		
		String id = this.s_idTextField.getText();
		
		String name = this.s_nameTextField.getText();
		
	
		ArrayList <Employee> s_empResult = new ArrayList<Employee>();
		
		//if no input is entered, table is filled with default list
		if (PayrollUtil.stringIsEmpty(type) && PayrollUtil.stringIsEmpty(id) && PayrollUtil.stringIsEmpty(name))
		{
			fillTable(PayrollApplication.empDataList.getEmployeeList());
		}else
		{
			Employee s_emp =  new Staff(type, id, name);
			
			
			for (Employee empList:PayrollApplication.empDataList.getEmployeeList())
			{
				if (empList.isEquals(s_emp))
				{
					s_empResult.add(empList);
				}
			}
				
			Employee [] empArray = new Employee [s_empResult.size()];	
			fillTable(s_empResult.toArray(empArray));
		}
		
	}
	
	
	/**
	 * Initialize table
	 * @param employee
	 */
	private void fillTable(Employee [] empArr)
	{
		DefaultTableModel dtm = (DefaultTableModel) employeeTable.getModel();
		dtm.setRowCount(0);

		if (empArr.length > 0) {
		for(Employee emp:empArr)
		{
			dtm.addRow(emp.toTableRow());
		}
		}else
			JOptionPane.showInternalMessageDialog(contentPane, "No result found.");

	}
	
	/**
	 * Reset text field and label
	 */
	private void resetText ()
	{

		idTextField.setText("");
		nameTextField.setText("");
		genderComboBox.setSelectedItem("");
		ageTextField.setText("");
		dateHiredTextField.setText("");
		salaryTextField.setText("");
		
		empLabel1.setText("");
		textField1.setText("");
		
		empLabel2.setText("");
		textField2.setText("");
	
		textField1.setEditable(false);
		textField1.setEnabled(false);
		
		textField2.setEditable(false);
		textField2.setEnabled(false);
	}
}
