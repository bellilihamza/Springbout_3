package com.example.motos.service;

import com.example.motos.Moto;
import com.example.motos.Type;

import org.springframework.data.domain.Page;

import java.util.List;

public interface MotoService {
	Moto saveMoto(Moto moto);

	Moto updateMoto(Moto moto);

	void deleteMoto(Moto moto);

	void deleteMotoById(Long id);

	Moto getMoto(Long id);

	List<Moto> getAllMotos();

	Page<Moto> getAllMotosParPage(int page, int size);

    List<Moto> findByNomMoto(String nom);
    List<Moto> findByNomMotoContains(String nom);
    List<Moto> findByNomPrix(String nom, Double prix);
    List<Moto> findByType(Type categorie); 
    List<Moto> findByTypeIdType(Long id);
    List<Moto> findByOrderByNomMotoAsc();
    List<Moto> trierMotosNomsPrix();
    List<Type> getAllTypes();

}
