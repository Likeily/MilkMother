package com.milkmother.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.milkmother.app.domain.Beneficiario;
import com.milkmother.app.domain.Categoria;
import com.milkmother.app.domain.Cidade;
import com.milkmother.app.domain.Estado;
import com.milkmother.app.repositories.BeneficiarioRepository;
import com.milkmother.app.repositories.CategoriaRepository;
//import com.milkmother.app.repositories.CidadeRepository;
//import com.milkmother.app.repositories.EstadoRepository;
import com.milkmother.app.repositories.CidadeRepository;
import com.milkmother.app.repositories.EstadoRepository;

@SpringBootApplication
public class MilkmotherApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	/********************************************************
	   
	    a gloriosa função MAIN! :)
	    
	    Não precisa receber argumento nenhuma, ela se vira sozinha ;)
	    é gente grande... :P
    
	 ********************************************************/
	
	public static void main(String[] args) {
		SpringApplication.run(MilkmotherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Estudante");
		Categoria cat2 = new Categoria(null, "Alimentação");
		
		Beneficiario b1 = new Beneficiario(null, "José Clementino", "090.987.900-11", 30, true);
		Beneficiario b2 = new Beneficiario(null, "Bianca Espirito Santo", "828.973.121-00", 30, true);
		Beneficiario b3 = new Beneficiario(null, "Eder Barbarlho", "290.019.243-99", 30, false);
		
		cat1.getBenefiario().addAll(Arrays.asList(b3));
		cat2.getBenefiario().addAll(Arrays.asList(b1, b2, b3));
		
		b1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		b2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		b3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		beneficiarioRepository.saveAll(Arrays.asList(b1, b2, b3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Santo andré", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}
	
}
