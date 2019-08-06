package br.com.recrutamento.brasilia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.recrutamento.brasilia.dto.JobDTO;
import br.com.recrutamento.brasilia.model.Job;
import br.com.recrutamento.brasilia.model.Task;
import br.com.recrutamento.brasilia.repository.JobRepository;
import br.com.recrutamento.brasilia.service.exception.ObjectNotFoundException;

@Service
public class JobService {

	@Autowired
	private JobRepository repository;

	public void save(Job job) {
		if(parentNotSelf(job))
		    job.setId(null);
		
			if (job.getTasks() != null)
				configTalk(job);

			repository.save(job);

	}

	public void update(Job job) {
		repository.save(job);
	}

	public void delete(int id) {
		find(id);
		repository.deleteById(id);
	}

	public List<Job> findAll() {
		return repository.findAll();
	}

	public Job find(int id) {
		
		Optional<Job> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Job.class.getName()));
	}

	private void configTalk(Job job) {
		for (Task task : job.getTasks()) {
			task.setJob(job);
		}
	}

	public boolean parentNotSelf(Job job) {
		if(job.getParentJob() != null && job.getName().equals(job.getParentJob().getName()))
			return false;

		return true;
	}
	
	public JobDTO toDTO(Job job) {
		return new JobDTO(job.getId(), job.getName(),job.isActive(), job.getParentJob(), job.getTasks());
	}
	
	public List<JobDTO> toDTO(List<Job> jobs){
		List<JobDTO> dtos = jobs.stream().map(job -> 
						new JobDTO(job.getId(), job.getName(),job.isActive(), job.getParentJob(), job.getTasks()))
						.collect(Collectors.toList());
		
		return dtos;
	}

}
