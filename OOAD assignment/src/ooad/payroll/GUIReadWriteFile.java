package ooad.payroll;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GUIReadWriteFile extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton readFromFile;
	private JButton writeToFile;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUIReadWriteFile frame = new GUIReadWriteFile();
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
	public GUIReadWriteFile() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIReadWriteFile.class.getResource("/ooad/payroll/Images/save.png")));
		setTitle("Read/Write File");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 446, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 48, 410, 91);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 2, 40, 10));
		
		readFromFile = new JButton("Read data ");
		readFromFile.setIcon(new ImageIcon(GUIReadWriteFile.class.getResource("/ooad/payroll/Images/load.png")));
		readFromFile.setRolloverIcon(new ImageIcon(GUIReadWriteFile.class.getResource("/ooad/payroll/Images/loadSelected.png")));
		readFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readFromFileActionPerformed(e);
			}
		});
		panel.add(readFromFile);
		
		writeToFile = new JButton("Write data ");

		writeToFile.setIcon(new ImageIcon(GUIReadWriteFile.class.getResource("/ooad/payroll/Images/write.png")));
		writeToFile.setRolloverIcon(new ImageIcon(GUIReadWriteFile.class.getResource("/ooad/payroll/Images/writeSelected.png")));
		writeToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeToFileActionPerformed(e);
			}
		});
		panel.add(writeToFile);
		
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Read from text file
	 * @param e
	 */
	private void readFromFileActionPerformed(ActionEvent e) {
		try {
			PayrollApplication.empDataList.init();
			JOptionPane.showMessageDialog(null, "Data readed.");
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "employeeData.txt not found! Employee data is not readed.");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Wrong number format readed! Employee data is not readed.");
			e1.printStackTrace();
		} catch (IllegalIdFormatException e1) {
			JOptionPane.showMessageDialog(null, "Wrong employee ID readed! Employee data is not readed.");
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Write to text file 
	 * @param e
	 */
	private void writeToFileActionPerformed(ActionEvent e) {
		try {
			PayrollApplication.empDataList.writeFile();
			JOptionPane.showMessageDialog(null, "Data wrote.");
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null,"employeeData.txt text file not found!");
			e1.printStackTrace();
		}
		
	}

}
