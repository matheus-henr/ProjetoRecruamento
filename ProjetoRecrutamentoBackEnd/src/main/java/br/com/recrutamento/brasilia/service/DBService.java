package br.com.recrutamento.brasilia.service;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.recrutamento.brasilia.model.Job;
import br.com.recrutamento.brasilia.model.Task;
import br.com.recrutamento.brasilia.model.User;
import br.com.recrutamento.brasilia.model.enums.Role;
import br.com.recrutamento.brasilia.util.ConvertDateUtil;

@Service
public class DBService {

	@Autowired
	private JobService JobService;
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDatabase() {

		Task t1 = new Task();

		t1.setName("Formatar");
		t1.setCompleted(true);
		t1.setWeight(5);
		t1.setCreatedAt(ConvertDateUtil.convert(LocalDate.now()));
	

		Task t2 = new Task();

		t2.setName("Amontar");
		t2.setCompleted(false);
		t2.setWeight(2);
		t1.setCreatedAt(ConvertDateUtil.convert(LocalDate.now()));
		
		
		Job j = new Job(); 
		
		j.setActive(true);
		j.setName("Job1");

		t1.setJob(j);
		t2.setJob(j);

		j.setTasks(Arrays.asList(t1, t2));

		JobService.save(j);
		
		
		userService.save(new User(null, "admin", pe.encode("admin"), Role.ADMIN.getCod())); 
		userService.save(new User(null, "test",  pe.encode("test"), Role.PUBLIC.getCod())); 


	}

}
