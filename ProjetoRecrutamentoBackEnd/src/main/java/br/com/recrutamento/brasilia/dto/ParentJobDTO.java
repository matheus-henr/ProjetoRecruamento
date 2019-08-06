package br.com.recrutamento.brasilia.dto;

public class ParentJobDTO {

	private Integer id;
	private String name;
	private boolean active;
	
	
	public ParentJobDTO(Integer id, String name, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
