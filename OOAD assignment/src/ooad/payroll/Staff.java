package ooad.payroll;

import java.time.LocalDate;

public class Staff extends Employee{
	
	private double payRatePerHour;
	private int totalWorkTimePerDay;
	
	public double getPayRatePerHour() {
		return payRatePerHour;
	}


	public void setPayRatePerHour(double payRatePerHour) {
		if (payRatePerHour < 0)
			throw new NumberFormatException();
		
		this.payRatePerHour = payRatePerHour;
	}


	public int getTotalWorkTimePerDay() {
		return totalWorkTimePerDay;
	}


	public void setTotalWorkTimePerDay(int totalWorkTimePerDay) {
		if (totalWorkTimePerDay < 0)
			throw new NumberFormatException();
		
		this.totalWorkTimePerDay = totalWorkTimePerDay;
	}
	
	@Override
	public Object[] toTableRow() {
		
		Object[] row = {getEmpType(), getEmpId(), getName(), getGender(), getAge(),  getHiredDate(), getSalary(), null, getPayRatePerHour(), getTotalWorkTimePerDay(), null};
		return row;
	}
	
	@Override
	//Compute salary for one month
	public double computePay()
	{
		return getSalary() + ( payRatePerHour * totalWorkTimePerDay * 31);
	}
	
	public String toFile()
	{
		return String.format("%s,%.2f,%d,", super.toFile(), this.getPayRatePerHour(), this.getTotalWorkTimePerDay());
	}

	
	//Generate new staff
	public Staff(String empType, String empId, String name, String gender, int age, double salary, LocalDate hiredDate,
			double payRatePerHour, int totalWorkTimePerDay) throws NumberFormatException, IllegalIdFormatException{
		super(empType, empId, name, gender, age, salary, hiredDate);
		setPayRatePerHour(payRatePerHour);
		setTotalWorkTimePerDay(totalWorkTimePerDay);
	}
	
	

	public Staff(String empType, String empId, String name) {
		super(empType, empId, name);
	}


	public Staff()
	{
		super();
	}




}
