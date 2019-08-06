package br.com.recrutamento.brasilia.service;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.com.recrutamento.brasilia.model.Job;

public class JobServiceTest {

	
	private JobService service = new JobService();
	
	@Test
	public void test_depencia_job() {
		Job job =  new Job(1, "job1", false, null);
		job.setParentJob(job);
		
		assertFalse(service.parentNotSelf(job));
	}
}
