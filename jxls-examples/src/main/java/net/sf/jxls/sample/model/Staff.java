package net.sf.jxls.sample.model;

public class Staff {
	private String name;
	private Double payment;
	private Double bonus;
	public Staff() {}
	public Staff(String name, Double payment, Double bonus) {
		super();
		this.name = name;
		this.payment = payment;
		this.bonus = bonus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	
	
	
}
