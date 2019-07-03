package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;


public class Worker {
	
	private String name;
	
	// WorkerLevel é um enum com os valores de: JUNIOR, MID_LEVEL, SENIOR;
	private WorkerLevel level;
	private Double baseSalary;
	
	//Segundo o diagrama um Worker(trabalhador) tem um departamento:
	private Department department;
	
	
	/* Segundo o diagrama um Worker pode possuir vários contratos, então instanciamos 
	 * um ArrayList da classe HourContract.
	 */
	private List<HourContract> contracts = new ArrayList<>();
	
	
	//Contructors:
	public Worker() {
	}
	
	//ATENÇÃO: O constructor NÃO pode ter atributos do tipo List (contracts).
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	//Getters and setters:
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	//Métodos:
	
	/* Busca a List de contracts instanciada acima e adiciona o contrato do tipo HourContract 
	 * recebido argumento.
	 * */
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	
	//Remove da list de contratos do trabalhador o contrato recebido como argumento.
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	
	//Calcula quanto a pessoa ganhou no ano e mês informado no parâmetro.
	public double income(int year, int month) {
		double sum = baseSalary;
		
		//Não precisamos instanciar com new pois o Java já possui um calendar. getInstance(); instancia.
		Calendar cal = Calendar.getInstance();
		
		//Laço for each:
		for(HourContract c : contracts) {
			/* cal.setTime seta a data de cada contrato tipo "c = nome no forEach" como sendo uma data 
			 * de calendário. getDate() é um getter de HourContract que retorna data do contrato.
			*/
			cal.setTime(c.getDate());
			
			//cal.get(Calendar.YEAR) obtem o ano da data e cal.get(Calendar.MONTH) obtem o mês.
			//OBSERVAÇÃO: Somamos 1 ao Calendar.MONTH pois no Java os meses começam em 0 (janeiro = 0).
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			//Testamos a condição e adicionamos ou não o valor do contrato a soma total:
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum; 
	}

}
