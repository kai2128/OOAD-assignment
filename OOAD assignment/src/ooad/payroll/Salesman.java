package ooad.payroll;

import java.time.LocalDate;

public class Salesman extends Employee {
	
	private double payRatePerSales;
	private int salesMade;
	
	public double getPayRatePerSales() {
		return payRatePerSales;
	}

	public void setPayRatePerSales(double payRatePerSales) {
		if (payRatePerSales < 0)
			throw new NumberFormatException();
		this.payRatePerSales = payRatePerSales;
	}

	public int getSalesMade() {
		return salesMade;
	}

	public void setSalesMade(int salesMade) {
		if (salesMade < 0)
			throw new NumberFormatException();
		this.salesMade = salesMade;
	}

	@Override
	//Salesman salary is calculated by base salary + number of sales made * pay rate per sales
	public double computePay()
	{
		return getSalary() + ( payRatePerSales * salesMade);
	}
	
	@Override
	public String toFile()
	{
		return String.format("%s,%.2f,%d,", super.toFile(), this.getPayRatePerSales(), this.getSalesMade());
	}
	
	@Override
	public Object[] toTableRow() {
		
		Object[] row = {getEmpType(), getEmpId(), getName(), getGender(), getAge(), getHiredDate(), getSalary(), null, getPayRatePerSales(), null, getSalesMade()};
		return row;
	}
	
	//Generate new salesman
	public Salesman(String empType, String empId, String name, String gender, int age, double salary,
			LocalDate hiredDate, double payRatePerSales, int salesMade) throws NumberFormatException, IllegalIdFormatException{
		super(empType, empId, name, gender, age, salary, hiredDate);
		setPayRatePerSales(payRatePerSales);
		setSalesMade(salesMade);
	}
	
	//use to search
	public Salesman(String empType, String empId, String name) {
		super(empType, empId, name);
	}

	public Salesman() {
		super();
	}


}
