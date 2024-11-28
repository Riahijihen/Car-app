package com.jihen.MyProject.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jihen.MyProject.entities.Client;
import com.jihen.MyProject.entities.commande;
import com.jihen.MyProject.repos.ClientRepository;
import com.jihen.MyProject.service.CommandeService;

@RestController
@RequestMapping("/api/cli")
@CrossOrigin("*")
public class ClientRESTController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Client> getAllCategories()
	{
	return clientRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Client getClientById(@PathVariable("id") Long id) {
	return clientRepository.findById(id).get();
	}
	






}
