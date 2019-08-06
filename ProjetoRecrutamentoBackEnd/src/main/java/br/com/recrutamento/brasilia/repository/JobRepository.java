package br.com.recrutamento.brasilia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import br.com.recrutamento.brasilia.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

	@Transactional(readOnly=true)
	public Optional<Job> findByName(String name);
}
