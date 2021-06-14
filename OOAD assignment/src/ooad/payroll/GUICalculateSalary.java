package ooad.payroll;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GUICalculateSalary extends JFrame {


	private JPanel contentPane;
	private JPanel panel;
	private JLabel s_empIDLabel;
	private JTextField s_empIDText;
	private JButton searchButton;
	private JPanel panel_1;
	private JLabel dateHiredLabel;
	private JLabel empTypeLabel;
	private JLabel empIDLabel;
	private JLabel empNameLabel;
	private JLabel empGenderLabel;
	private JLabel empAgeLabel;
	private JTextField empTypeText;
	private JTextField empIDText;
	private JTextField empNameText;
	private JTextField empGenderText;
	private JTextField empAgeText;
	private JTextField empDateHiredText;
	private JTextField salaryText;
	private JLabel baseSalaryLabel;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField salaryPerMonthText;
	private JLabel salaryPerMonthLabel;
	private JButton calculateButton;
	private JLabel searchResultLabel;
	private JLabel label1;
	private JLabel label2;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUICalculateSalary frame = new GUICalculateSalary();
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
	public GUICalculateSalary() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUICalculateSalary.class.getResource("/ooad/payroll/Images/calculate.png")));
		setTitle("Calculate Salary");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search Employee using ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 11, 661, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		s_empIDLabel = new JLabel("Employee ID:");
		s_empIDLabel.setBounds(21, 35, 64, 14);
		panel.add(s_empIDLabel);
		
		s_empIDText = new JTextField();
		s_empIDText.setBounds(123, 32, 232, 20);
		panel.add(s_empIDText);
		s_empIDText.setColumns(10);
		
		searchButton = new JButton("Search");
		searchButton.setIcon(new ImageIcon(GUICalculateSalary.class.getResource("/ooad/payroll/Images/search.png")));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchButtonActionPerformed(e);
			}
		});
		searchButton.setBounds(425, 21, 120, 42);
		panel.add(searchButton);
		
		searchResultLabel = new JLabel("");
		searchResultLabel.setBounds(123, 59, 232, 14);
		panel.add(searchResultLabel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(31, 116, 302, 342);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 10, 30));
		
		empTypeLabel = new JLabel("Type");
		panel_1.add(empTypeLabel);
		
		empTypeText = new JTextField();
		empTypeText.setEditable(false);
		panel_1.add(empTypeText);
		empTypeText.setColumns(10);
		
		empIDLabel = new JLabel("ID");
		panel_1.add(empIDLabel);
		
		empIDText = new JTextField();
		empIDText.setEditable(false);
		panel_1.add(empIDText);
		empIDText.setColumns(10);
		
		empNameLabel = new JLabel("Name");
		panel_1.add(empNameLabel);
		
		empNameText = new JTextField();
		empNameText.setEditable(false);
		panel_1.add(empNameText);
		empNameText.setColumns(10);
		
		empGenderLabel = new JLabel("Gender");
		panel_1.add(empGenderLabel);
		
		empGenderText = new JTextField();
		empGenderText.setEditable(false);
		panel_1.add(empGenderText);
		empGenderText.setColumns(10);
		
		empAgeLabel = new JLabel("Age");
		panel_1.add(empAgeLabel);
		
		empAgeText = new JTextField();
		empAgeText.setEditable(false);
		panel_1.add(empAgeText);
		empAgeText.setColumns(10);
		
		dateHiredLabel = new JLabel("Date Hired");
		panel_1.add(dateHiredLabel);
		
		empDateHiredText = new JTextField();
		empDateHiredText.setEditable(false);
		panel_1.add(empDateHiredText);
		empDateHiredText.setColumns(10);
		
		salaryText = new JTextField();
		salaryText.setBounds(537, 116, 136, 20);
		contentPane.add(salaryText);
		salaryText.setColumns(10);
		
		baseSalaryLabel = new JLabel("Base Salary:");
		baseSalaryLabel.setBounds(343, 119, 184, 14);
		contentPane.add(baseSalaryLabel);
		
		textField1 = new JTextField();
		textField1.setEnabled(false);
		textField1.setBounds(537, 169, 136, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setEnabled(false);
		textField2.setBounds(537, 218, 136, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		salaryPerMonthText = new JTextField();
		salaryPerMonthText.setEditable(false);
		salaryPerMonthText.setBounds(537, 270, 136, 31);
		contentPane.add(salaryPerMonthText);
		salaryPerMonthText.setColumns(10);
		
		salaryPerMonthLabel = new JLabel("Total salary per month (RM):");
		salaryPerMonthLabel.setBounds(343, 278, 184, 20);
		contentPane.add(salaryPerMonthLabel);
		
		calculateButton = new JButton("Calculate");
		calculateButton.setIcon(new ImageIcon(GUICalculateSalary.class.getResource("/ooad/payroll/Images/calculator.png")));
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateButtonActionPerformed(e);
			}
		});
		calculateButton.setBounds(467, 332, 136, 68);
		contentPane.add(calculateButton);
		
		label1 = new JLabel("");
		label1.setBounds(343, 172, 184, 14);
		contentPane.add(label1);
		
		label2 = new JLabel("");
		label2.setBounds(343, 221, 184, 14);
		contentPane.add(label2);
		
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Search employee using ID and show current salary per month
	 * @param e
	 */
	private void searchButtonActionPerformed(ActionEvent e) {
		
		String searchID = s_empIDText.getText();
		
		Employee emp = PayrollApplication.empDataList.findEmployeeId(searchID);
		
		if(emp == null)
		{
			JOptionPane.showInternalMessageDialog(contentPane, "Employee not found");
			return;
		}
		else
		{
			resetText();
			
			if (emp instanceof Manager)
			{
				empTypeText.setText(emp.getEmpType());
				empIDText.setText(emp.getEmpId());
				empNameText.setText(emp.getName());
				empGenderText.setText(emp.getGender());
				empAgeText.setText(Integer.toString(emp.getAge()));
				empDateHiredText.setText(emp.getHiredDate().toString());
				salaryText.setText(Double.toString(emp.getSalary()));
				
				label1.setText("Bonus:");
				textField1.setText(Double.toString(((Manager) emp).getBonus()));
				salaryPerMonthText.setText(Double.toString(emp.computePay()));
				
				label1.setEnabled(true);
				textField1.setEditable(true);
				textField1.setEnabled(true);
				
				
			
			}
			else if (emp instanceof Salesman)
			{
				empTypeText.setText(emp.getEmpType());
				empIDText.setText(emp.getEmpId());
				empNameText.setText(emp.getName());
				empGenderText.setText(emp.getGender());
				empAgeText.setText(Integer.toString(emp.getAge()));
				empDateHiredText.setText(emp.getHiredDate().toString());
				salaryText.setText(Double.toString(emp.getSalary()));
				
				label1.setText("Pay Rate Per Sales:");
				textField1.setText(Double.toString(((Salesman) emp).getPayRatePerSales()));
				
				label2.setText("Number of Sales Made:");
				textField2.setText(Integer.toString(((Salesman) emp).getSalesMade()));
				salaryPerMonthText.setText(Double.toString(emp.computePay()));
				
				label1.setEnabled(true);
				textField1.setEditable(true);
				textField1.setEnabled(true);
			
				
				label2.setEnabled(true);
				textField2.setEditable(true);
				textField2.setEnabled(true);
				
				
				
			}
			else 
			{
				empTypeText.setText(emp.getEmpType());
				empIDText.setText(emp.getEmpId());
				empNameText.setText(emp.getName());
				empGenderText.setText(emp.getGender());
				empAgeText.setText(Integer.toString(emp.getAge()));
				empDateHiredText.setText(emp.getHiredDate().toString());
				salaryText.setText(Double.toString(emp.getSalary()));
				
				label1.setText("Pay Rate Per Sales:");
				textField1.setText(Integer.toString(((Staff) emp).getTotalWorkTimePerDay()));
				
				label2.setText("Number of Sales Made:");
				textField2.setText(Double.toString(((Staff) emp).getPayRatePerHour()));
				salaryPerMonthText.setText(Double.toString(emp.computePay()));
				
				label1.setEnabled(true);
				textField1.setEditable(true);
				textField1.setEnabled(true);
				
				label2.setEnabled(true);
				textField2.setEditable(true);
				textField2.setEnabled(true);
				
			}
		}
		
		
	}
	
	
	/**
	 * Reset all text value
	 * @param e
	 */
	private void resetText()
	{
		empTypeText.setText("");
		empIDText.setText("");
		empNameText.setText("");
		empGenderText.setText("");
		empAgeText.setText("");
		empDateHiredText.setText("");
		salaryText.setText("");
		
		label1.setText("");
		textField1.setText("");
		
		label2.setText("");
		textField2.setText("");
		
		
		label1.setEnabled(false);
		label2.setEnabled(false);
		textField1.setEditable(false);
		textField2.setEditable(false);
		textField1.setEnabled(false);
		textField2.setEnabled(false);
		
		salaryPerMonthText.setText("");

	}
	
	/**
	 * Calculate salary base on user input
	 * @param e
	 */
	private void calculateButtonActionPerformed(ActionEvent e) {
		
		Double total;
		
		Double baseSalary = Double.parseDouble(salaryText.getText());
		
		if (PayrollUtil.stringIsEmpty(textField2.getText()))
		{
			try {
				total = baseSalary + Double.parseDouble(textField1.getText());
				
				salaryPerMonthText.setText(Double.toString(total));
			} catch (Exception e2) {
				JOptionPane.showInternalMessageDialog(contentPane, "Please enter the correct format of number.");
			}
			
		}
		else if (empTypeText.getText().equals(PayrollUtil.typeToString(PayrollUtil.SALESMAN)))
		{
			
			
			try {
				total = baseSalary + Double.parseDouble(textField1.getText()) * Double.parseDouble(textField2.getText());
				
				salaryPerMonthText.setText(Double.toString(total));
			}catch (Exception e2) {
				JOptionPane.showInternalMessageDialog(contentPane, "Please enter the correct format of number.");
			}
				
		}
		else 
		{
			try {
				total = baseSalary + ( Double.parseDouble(textField1.getText()) * Double.parseDouble(textField2.getText()) * 31);
				
				salaryPerMonthText.setText(Double.toString(total));
			}catch (Exception e2) {
				JOptionPane.showInternalMessageDialog(contentPane, "Please enter the correct format of number.");
			}
		}
		
		
	}
}
