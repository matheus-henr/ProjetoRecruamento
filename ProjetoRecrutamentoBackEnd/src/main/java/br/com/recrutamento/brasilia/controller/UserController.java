package br.com.recrutamento.brasilia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.recrutamento.brasilia.model.User;
import br.com.recrutamento.brasilia.service.UserService;

@RestController()
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<User> save(@Valid @RequestBody User user){
		service.save(user);
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> find(@PathVariable int id){
		User User = service.find(id);
		return ResponseEntity.ok().body(User);
	}
	
}
