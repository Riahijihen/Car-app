package com.jihen.MyProject.service;

import java.util.List;

import com.jihen.MyProject.entities.Client;
import com.jihen.MyProject.entities.commande;


public interface CommandeService {
	commande saveCommande(commande c);
	commande updateCommande(commande c);
	void deleteCommande(commande c);
	void deleteCommandeById(Long id);
	commande getCommande(Long id);
	List<commande> getAllCommande();
	List<commande> findByNomCommande(String nom);
	List<commande> findByNomCommandeContains(String nom);
	List<commande> findByNomPrix (String nom, Double prix);
	List<commande> findByClient (Client client);
	List<commande> findByClietIdCli(Long id);
	List<commande> findByOrderByNomCommandeAsc();
	List<commande> trierCommandesNomsPrix();

}
