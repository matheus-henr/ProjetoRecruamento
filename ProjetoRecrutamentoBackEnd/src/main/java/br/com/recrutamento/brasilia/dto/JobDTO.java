package br.com.recrutamento.brasilia.dto;

import java.io.Serializable;
import java.util.List;

import br.com.recrutamento.brasilia.model.Job;
import br.com.recrutamento.brasilia.model.Task;

public class JobDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private boolean active;
	private ParentJobDTO parentJob;
	private List<Task> tasks;

	public JobDTO(Integer id, String name, boolean active, Job parentJob, List<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.parentJob = null;
		this.active = active;
		this.tasks = tasks;
		
		if(parentJob != null)
			this.parentJob = new ParentJobDTO(parentJob.getId(),parentJob.getName(), parentJob.isActive());
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

	public ParentJobDTO getParentJob() {
		return parentJob;
	}

	public void setParentJob(ParentJobDTO parentJob) {
		this.parentJob = parentJob;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
