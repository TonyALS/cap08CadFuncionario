package entities;

public class Department {
	
	//A classe department tem somente o nome do departamento (vide diagrama):
	private String name;
	
	
	//Contructors:
	public Department() {	
	}
	
	public Department (String name) {
		this.name = name;
	}
	
	//Getters and setters:
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
