package com.example.motos;

import java.sql.Date;
import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.motos.repos.MotoRepository;
import com.example.motos.service.MotoService;


@SpringBootTest 
class ProduitsApplicationTests implements CommandLineRunner { 
	@Autowired  
	MotoService produitService; 
	public static void main(String[] args) { 
	SpringApplication.run(MotosApplication.class, args); 
	} 
	@Override 
	public void run(String... args) throws Exception { 
	produitService.saveMoto(new Moto("PC Dell", 2600.0, new Date(0))); 
	produitService.saveMoto(new Moto("PC Asus", 2800.0, new Date(0))); 
	produitService.saveMoto(new Moto("Imprimante Epson", 900.0, new Date(0))); 
	} 
}
