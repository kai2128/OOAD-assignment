package ooad.payroll;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class is use to store employee into an array list and manipulate them
 *
 */
public class EmployeeManage {
	
	private ArrayList<Employee> employeeList;
	
	
	//suggest a employee id 
	public String suggestEmpId (int empType)
	{
		String type = PayrollUtil.typeToString(empType);
		switch(type)
		{
		case "MANAGER":
			{
				return String.format("%s%04d", "MA", (getNumberOfEmployee()+1));
			}
		case "STAFF":
			{
				return String.format("%s%04d", "ST", (getNumberOfEmployee()+1));	
			}
		case "SALESMAN":
			{
				return String.format("%s%04d", "SL", (getNumberOfEmployee()+1));
			}
		default:
				return null;
		}
	}
	
	
	public void modifyEmployee (int index, Employee emp) throws DuplicateKeyException
	{
		String id = emp.getEmpId();
		
		//if ID is the same no need check for duplication
		if (id.equalsIgnoreCase(employeeList.get(index).getEmpId()))
		{
			employeeList.set(index,emp);
		}
		else {
			for (Employee e:employeeList)
			{
				if (id.equalsIgnoreCase(e.getEmpId()))
					throw new DuplicateKeyException(emp.getEmpId());
			}
			employeeList.set(index,emp);
		}	
	}
	
	//add employee to the list after checking no duplicate on id
	public void addEmployee(Employee emp) throws DuplicateKeyException
	{
		String id = emp.getEmpId();
		
		for (Employee e:employeeList)
		{
			if (id.equalsIgnoreCase(e.getEmpId()))
				throw new DuplicateKeyException(emp.getEmpId());
		}
		
		employeeList.add(emp);
	}
	
	public void deleteEmployee(int num)
	{
		employeeList.remove(num);
	}
	
	//return an index in array for specific employee
	public int getIndex (Employee e)
	{
		return employeeList.indexOf(e);
	}
	
	//return total number of employee
	public int getNumberOfEmployee ()
	{
		return employeeList.size();
	}
	
	//return employee list to array
	public Employee[] getEmployeeList ()
	{
		Employee [] empArray = new Employee [employeeList.size()];
		empArray = employeeList.toArray(empArray);
		return empArray;		
	}

	public ArrayList<Employee> getEmployeeArrayList()
	{
		return employeeList;
	}
	
	//search employee using employee id
	public Employee findEmployeeId(String id)
	{
		Employee emp = null;
		for (Employee e:employeeList)
		{
			if (id.equalsIgnoreCase(e.getEmpId()))
			{
				emp = e;
			}
		}
		
		return emp;
	}
	
	
	
	//write from array list to file
	public void writeFile() throws IOException
	{
		
		PrintWriter pw = new PrintWriter("employeeData.txt", "UTF-8");

	    for (Employee e:employeeList)
	    {
	    	pw.println(e.toFile());
	    }
	    
	    pw.close();
		 
	}
	
	
	// read from file to array list
	public void readFile() throws IOException, NumberFormatException, IllegalIdFormatException {

		Scanner fin = new Scanner(Paths.get("employeeData.txt"), "UTF-8");

		fin.useDelimiter(",");
		while (fin.hasNext()) {
			String type = fin.next();
			switch (type) {
			case "MANAGER": {
				String empType = type;
				String empId = fin.next();
				String name = fin.next();
				String gender = fin.next();
				int age = Integer.parseInt(fin.next());
				double salary = Double.parseDouble(fin.next());
				LocalDate hiredDate = LocalDate.parse(fin.next());
				double bonus = Double.parseDouble(fin.next());
				fin.nextLine();

				Manager temp = new Manager(empType, empId, name, gender, age, salary, hiredDate, bonus);
				employeeList.add(temp);
				break;
			}
			case "STAFF": {
				String empType = type;
				String empId = fin.next();
				String name = fin.next();
				String gender = fin.next();
				int age = Integer.parseInt(fin.next());
				double salary = Double.parseDouble(fin.next());
				LocalDate hiredDate = LocalDate.parse(fin.next());
				double payRatePerHour = Double.parseDouble(fin.next());
				int totalWorkTimePerDay = Integer.parseInt(fin.next());
				fin.nextLine();

				Staff temp = new Staff(empType, empId, name, gender, age, salary, hiredDate, payRatePerHour,
						totalWorkTimePerDay);
				employeeList.add(temp);
				break;
			}
			case "SALESMAN": {
				String empType = type;
				String empId = fin.next();
				String name = fin.next();
				String gender = fin.next();
				int age = Integer.parseInt(fin.next());
				double salary = Double.parseDouble(fin.next());
				LocalDate hiredDate = LocalDate.parse(fin.next());
				double payRatePerSales = Double.parseDouble(fin.next());
				int salesMade = Integer.parseInt(fin.next());
				fin.nextLine();

				Salesman temp = new Salesman(empType, empId, name, gender, age, salary, hiredDate, payRatePerSales,
						salesMade);
				employeeList.add(temp);
				break;
			}
			}
		}
		fin.close();
	}
	
	
	//initialize the array list 
	public void init() throws IOException, NumberFormatException, IllegalIdFormatException
	{
		employeeList = new ArrayList<Employee>();
		readFile();
	}
	
	
	public EmployeeManage(){
		
	}



}
