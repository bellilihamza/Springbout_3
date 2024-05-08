package com.example.motos.service;

import com.example.motos.Moto;
import com.example.motos.Type;
import com.example.motos.repos.MotoRepository;
import com.example.motos.repos.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoServiceImpl implements MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Override
    public Moto saveMoto(Moto moto) {
        return motoRepository.save(moto);
    }

    @Override
    public Moto updateMoto(Moto moto) {
        return motoRepository.save(moto);
    }

    @Override
    public void deleteMoto(Moto moto) {
        motoRepository.delete(moto);
    }

    @Override
    public void deleteMotoById(Long id) {
        motoRepository.deleteById(id);
    }
  
    @Override
    public List<Moto> getAllMotos() {
        return motoRepository.findAll();
    }
	@Override
    public Page<Moto> getAllMotosParPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return motoRepository.findAll(pageable);
    }

	@Override
	public Moto getMoto(Long id) {
	    return motoRepository.findById(id).orElse(null);
	}
	@Override
	public List<Moto> findByNomMoto(String nom) {
	    return motoRepository.findByNomMoto(nom);
	}

	@Override
	public List<Moto> findByNomMotoContains(String nom) {
	    return motoRepository.findByNomMotoContains(nom);
	}

	@Override
	public List<Moto> findByNomPrix(String nom, Double prix) {
	    return motoRepository.findByNomPrix(nom, prix);
	}

	

	

	@Override
	public List<Moto> findByOrderByNomMotoAsc() {
	    return motoRepository.findByOrderByNomMotoAsc();
	}

	@Override
	public List<Moto> trierMotosNomsPrix() {
	    return motoRepository.trierMotosNomsPrix();
	}

	@Override
	public List<Moto> findByType(Type categorie) {
		     return motoRepository.findByType(categorie);

	}

	@Override
	public List<Moto> findByTypeIdType(Long id) {
	    return motoRepository.findByTypeIdType(id);

	}
	@Autowired
	TypeRepository categorieRepository;
	@Override
	public List<Type> getAllTypes() {
	return categorieRepository.findAll();
	}


	

}
