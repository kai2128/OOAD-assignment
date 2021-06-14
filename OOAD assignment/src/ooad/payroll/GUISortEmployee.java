package ooad.payroll;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class GUISortEmployee extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel buttonSouthPanel;
	private JButton sortIDButton;
	private JButton sortTotalSalaryButton;
	private JTable employeeTable;
	
	private EmployeeManage tempList;
	private JButton sortIDNumberButton;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUISortEmployee frame = new GUISortEmployee();
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
	public GUISortEmployee() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUISortEmployee.class.getResource("/ooad/payroll/Images/sort.png")));
		setTitle("Sort Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		employeeTable = new JTable();
		employeeTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Type", "ID", "Name", "Gender", "Age", "Date Hired", "Base salary", "Total salary"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(employeeTable);
		
		buttonSouthPanel = new JPanel();
		FlowLayout fl_buttonSouthPanel = (FlowLayout) buttonSouthPanel.getLayout();
		fl_buttonSouthPanel.setVgap(20);
		fl_buttonSouthPanel.setHgap(40);
		contentPane.add(buttonSouthPanel, BorderLayout.SOUTH);
		
		sortIDButton = new JButton("Sort using Type and ID");
		sortIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortIDButtonActionPerformed(e);
			}
		});
		buttonSouthPanel.add(sortIDButton);
		
		sortIDNumberButton = new JButton("Sort using ID number only");
		sortIDNumberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sortIDNumberButtonActionPerformed(arg0);
			}
		});
		buttonSouthPanel.add(sortIDNumberButton);
		
		sortTotalSalaryButton = new JButton("Sort using Total Salary");
		sortTotalSalaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sortTotalSalaryButtonActionPerformed(arg0);
			}
		});
		buttonSouthPanel.add(sortTotalSalaryButton);
		
		this.setLocationRelativeTo(null);
		
		
		fillTable(PayrollApplication.empDataList.getEmployeeList());
		
		tempList = (EmployeeManage) PayrollApplication.empDataList;

	}


	/**
	 * Sort employee list using total salary
	 * @param arg0
	 */
	private void sortTotalSalaryButtonActionPerformed(ActionEvent arg0) {
		
		Object[] options = {"Ascending", "Descending"};


		
		int n = JOptionPane.showOptionDialog(null, "Sort?","Sort using employee salary", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		
		if (n == JOptionPane.YES_OPTION)
		{
			Collections.sort(tempList.getEmployeeArrayList(), new Comparator<Employee> () {
				@Override
				public int compare(Employee e1, Employee e2) {
					return (int) (e1.computePay() - e2.computePay());
				}	
			});
		}else {
			Collections.sort(tempList.getEmployeeArrayList(), Collections.reverseOrder(new Comparator<Employee> () {
				@Override
				public int compare(Employee e1, Employee e2) {
					return (int) (e1.computePay() - e2.computePay());
				}	
			}));
			
		}
		
		fillTable(tempList.getEmployeeList());
	}






	/**
	 * Sort list using ID number only
	 * @param arg0
	 */
	private void sortIDNumberButtonActionPerformed(ActionEvent arg0) {
		
		Collections.sort(tempList.getEmployeeArrayList(), new Comparator<Employee> () {
			@Override
			public int compare(Employee e1, Employee e2) {
				
				int id1 = Integer.parseInt(e1.getEmpId().substring(2));
				int id2 = Integer.parseInt(e2.getEmpId().substring(2));
				
				return id1 - id2;
			}	
		});
		fillTable(tempList.getEmployeeList());
		
	}







	/**
	 * Sort list using ID and type
	 * @param e
	 */
	private void sortIDButtonActionPerformed(ActionEvent e) {
		
		//use default comparator
		Collections.sort(tempList.getEmployeeArrayList());
		
		fillTable(tempList.getEmployeeList());
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
			dtm.addRow(emp.toSortTableRow());
		}
		}else
			JOptionPane.showInternalMessageDialog(contentPane, "No result found.");

	}

}
