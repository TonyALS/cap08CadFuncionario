package entities;

import java.util.Date;

public class HourContract {
	
	/*	
	 * Essa classe possui os atributos necessários para termos valor de um contrato.
	 * Todos os atributos foram criados utilizando wrapper class para que possamos tratar os 
	 * tipos primitivos como classes e utilizar os recursos de OO.
	 */
	
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	
	
	//Contructors
	public HourContract() {
	}
	
	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	//Getters and setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	//Método que calcula o valor total do contrato:
	public double totalValue() {
		return valuePerHour * hours;
	}

}
