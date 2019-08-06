package br.com.recrutamento.brasilia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.recrutamento.brasilia.model.User;
import br.com.recrutamento.brasilia.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public void save(User user) {
		user.setId(null);
		repository.save(user);
	}

	public void update(User user) {
		repository.save(user);
	}

	public void delete(int id) {
		if (find(id) == null)
			throw new IllegalArgumentException("Objeto não existe");
		repository.deleteById(id);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User find(int id) {
		return repository.findById(id).get();
	}

}
