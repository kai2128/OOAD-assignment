package ooad.payroll;

import java.time.LocalDate;


public abstract  class Employee implements Comparable<Employee>{
	
	
	
	private String empType;
	private String empId;
	private String name;
	private String gender;
	private int age;
	private double salary;
	private LocalDate hiredDate;
	


	public String getEmpType() {
		return empType;
	}


	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) throws IllegalIdFormatException {
		
		if (empId.matches("^[MA]{2}[0-9]{4}$") || empId.matches("^[ST]{2}[0-9]{4}$") || empId.matches("^[SL]{2}[0-9]{4}$"))
			this.empId = empId;
		else
			throw new IllegalIdFormatException("Wrong ID format entered!");
	}

	public String getName() {
		return name;
	}


	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0)
			throw new NumberFormatException();
		
		this.age = age;
	}

	public LocalDate getHiredDate() {
		return hiredDate;
	}


	public void setSalary(double salary) {
		if (salary < 0)
			throw new NumberFormatException();
		
		this.salary = salary;
	}

	public double getSalary()
	{
		return salary;
	}

	public abstract Object[] toTableRow();
	
	public  Object[] toSortTableRow()
	{
		Object[] row = {getEmpType(), getEmpId(), getName(), getGender(), getAge(),  getHiredDate(), getSalary(), computePay()};
		return row;
	}
	
	public abstract double computePay();
	
	public String toFile()
	{
		return String.format("%s,%s,%s,%s,%d,%.2f,%s", getEmpType(), getEmpId(), getName(), getGender(), getAge(), getSalary(), getHiredDate());
	}
	
	
	@Override
	public String toString() {
		return "Employee [empType=" + empType + ", empId=" + empId + ", name=" + name + ", gender=" + gender + ", age="
				+ age + ", salary=" + salary + ", hiredDate=" + hiredDate + "]";
	}

	
	//default comparator
	@Override
	public int compareTo(Employee other) {
		return this.empId.compareTo(other.getEmpId());
	}

	public boolean isEquals(Employee emp) {
		
		boolean isEquals = false;
		
		if(PayrollUtil.stringIsNotEmpty(emp.getEmpType()))
		{
			if(empType.equalsIgnoreCase(emp.getEmpType()))
				isEquals = true;
		}
		
		if (PayrollUtil.stringIsNotEmpty(emp.getEmpId()))
		{
			if (empId.matches(".*"+ emp.getEmpId() +".*"))
				isEquals = true;
		}
		
		if (PayrollUtil.stringIsNotEmpty(emp.getName()))
		{

			if(name.matches(".*"+ emp.getName() + ".*"))
				isEquals = true;
		}
		
		
		return isEquals;
	}

	//Construct new employee with custom id
	public Employee(String empType, String empId, String name, String gender, int age, double salary,
			LocalDate hiredDate) throws NumberFormatException, IllegalIdFormatException {
		this.empType = empType;
		setEmpId(empId);;
		this.name = name;
		this.gender = gender;
		setAge(age);
		setSalary(salary);
		this.hiredDate = hiredDate;
	}
	

	//use to search employee
	public Employee(String empType, String empId, String name) {
		this.empType = empType;
		this.empId = empId;
		this.name = name;
	}

	public Employee()
	{
		
	}

}
