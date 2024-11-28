package com.jihen.MyProject.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jihen.MyProject.entities.commande;
import com.jihen.MyProject.service.CommandeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CommandeRESTController {
	@Autowired
	CommandeService commandeService;

	@RequestMapping( path="all" , method = RequestMethod.GET)
	 public List<commande> getAllCommande() {
		return commandeService.getAllCommande();
	}

	@RequestMapping( value = "/getbyid/{id}", method = RequestMethod.GET)
	public commande getCommandetById(@PathVariable("id") Long id) {
		return commandeService.getCommande(id);
	}
	
	@RequestMapping(path="/addcom",method = RequestMethod.POST)
	public commande createCommande(@RequestBody commande commande) {
	return commandeService.saveCommande(commande);
	}
	
	@RequestMapping(path="/updatecom", method = RequestMethod.PUT)
	public commande updateCommande(@RequestBody commande commande) {
	return commandeService.updateCommande(commande);
	}
	
	@RequestMapping(value="/delcom/{id}",method = RequestMethod.DELETE)
	public void deleteCommande(@PathVariable("id") Long id)
	{
		commandeService.deleteCommandeById(id);
	}
	
	@RequestMapping(value="/comscli/{idCli}",method = RequestMethod.GET)
	public List<commande> getCommandesByCliId(@PathVariable("idCli") Long idCli) {
	return commandeService.findByClietIdCli(idCli);
	}

	@RequestMapping(value="/comsByName/{nom}",method = RequestMethod.GET)
	public List<commande> findByNomCommandeContains(@PathVariable("nom") String nom) {
	return commandeService.findByNomCommandeContains(nom);
	}


}
