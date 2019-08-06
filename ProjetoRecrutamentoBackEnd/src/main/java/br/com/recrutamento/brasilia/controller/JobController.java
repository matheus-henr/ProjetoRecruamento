package br.com.recrutamento.brasilia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.recrutamento.brasilia.dto.JobDTO;
import br.com.recrutamento.brasilia.model.Job;
import br.com.recrutamento.brasilia.service.JobService;

@RestController()
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService service;
	
	@PostMapping
	public ResponseEntity<Job> save(@Valid @RequestBody Job job){
		service.save(job);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Job> update(@Valid @RequestBody Job job){
		service.update(job);
		return ResponseEntity.ok().build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Job> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<JobDTO>> findAll(){
		List<Job> jobs = service.findAll();
		List<JobDTO> jobsDTO = service.toDTO(jobs);
		return  ResponseEntity.ok().body(jobsDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JobDTO> find(@PathVariable int id){
		Job job = service.find(id);
		JobDTO dto = service.toDTO(job);
		return ResponseEntity.ok().body(dto);
	}
	
}
