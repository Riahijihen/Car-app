package com.jihen.MyProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jihen.MyProject.entities.Client;
import com.jihen.MyProject.entities.commande;
@RepositoryRestResource(path = "rest")
public interface CommandeRepository extends JpaRepository<commande, Long>{

		List<commande> findByNomCom(String nom);
		List<commande> findByNomComContains(String nom);
		
		@Query("select c from commande c where c.nomCom like %?1 and c.prixCom > ?2")
		List<commande> findByNomPrix (String nom, Double prix);
		
		@Query("select c from commande c where c.client = ?1")
		List<commande> findByClient (Client client);
		
		List<commande> findByClientIdCli(Long id);
		
		List<commande> findByOrderByNomComAsc();
		
		



		
		}




