package com.milkmother.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.milkmother.app.domain.Beneficiarios;
import com.milkmother.app.domain.Categoria;
import com.milkmother.app.repositories.BeneficiarioRepository;
import com.milkmother.app.repositories.CategoriaRepository;

@SpringBootApplication
public class MilkmotherApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MilkmotherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Estudante");
		Categoria cat2 = new Categoria(null, "Alimentação");
		
		Beneficiarios b1 = new Beneficiarios(null, "José Clementino", "090.987.900-11", 30, true);
		Beneficiarios b2 = new Beneficiarios(null, "Bianca Espirito Santo", "828.973.121-00", 30, true);
		Beneficiarios b3 = new Beneficiarios(null, "Eder Barbarlho", "290.019.243-99", 30, false);
		
		cat1.getBenefiarios().addAll(Arrays.asList(b3));
		cat2.getBenefiarios().addAll(Arrays.asList(b1, b2, b3));
		
		b1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		b2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		b3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		beneficiarioRepository.saveAll(Arrays.asList(b1, b2, b3));
		
	}
	
}
