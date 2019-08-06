package br.com.recrutamento.brasilia;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.recrutamento.brasilia.service.DBService;

@SpringBootApplication
public class ProjetoRecrutamentoApplication {
	
	
	  @Autowired 
	  private  DBService dbService;
	 
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoRecrutamentoApplication.class, args);
	}

	
	
	  @Bean 
	  public boolean instantiateDatabase() throws ParseException {
		  dbService.instantiateTestDatabase(); return true; }
	 
	 
}
