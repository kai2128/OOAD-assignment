package ooad.payroll;

import java.time.LocalDate;

public class Manager extends Employee{
	
	private double bonus;
	
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toFile()
	{
		return String.format("%s,%.2f,", super.toFile(), this.getBonus());
	}
	
	@Override
	public Object[] toTableRow() {
		
		Object[] row = {getEmpType(), getEmpId(), getName(), getGender(), getAge(), getHiredDate(), getSalary(), getBonus(),null, null, null};
		return row;
	}

	@Override
	public double computePay() {
		return getSalary() + bonus;
	}

	public Manager(String empType, String empId, String name, String gender, int age, double salary, LocalDate hiredDate, double bonus) throws NumberFormatException, IllegalIdFormatException {
		super(empType, empId, name, gender, age, salary, hiredDate);
		this.bonus = bonus;
	}

	//use to search
	public Manager(String empType, String empId, String name) {
		super(empType, empId, name);
	}

	
	public Manager() {
		super();
	}
	
	

}
