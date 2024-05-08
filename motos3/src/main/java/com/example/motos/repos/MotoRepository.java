package com.example.motos.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.motos.Moto;
import java.util.List;
@RepositoryRestResource(path = "rest")
public interface MotoRepository extends JpaRepository<Moto, Long> {
	List<Moto> findByNomMoto(String nom);
	 List<Moto> findByNomMotoContains(String nom); 
	 @Query("select p from Moto p where p.nomMoto like %:nom and p.prixMoto > :prix")
	 List<Moto> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	 @Query("select p from Moto p where p.type  = ?1")
	 List<Moto> findByType (com.example.motos.Type categorie);
	 @Query("select p from Moto p where p.type.idtype = :id")
	 List<Moto> findByTypeIdType(@Param("id") Long id);
	 List<Moto> findByOrderByNomMotoAsc();
	 @Query("select p from Moto p order by p.nomMoto ASC, p.prixMoto DESC")
	 List<Moto> trierMotosNomsPrix ();
}
