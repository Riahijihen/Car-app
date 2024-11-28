package com.jihen.MyProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jihen.MyProject.entities.Client;
import com.jihen.MyProject.entities.commande;
import com.jihen.MyProject.repos.CommandeRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class MyProjectApplicationTests {
	@Autowired
	private CommandeRepository CommandeRepository;
	
	@Test
	public void testCreateCommande() {
	commande com = new commande();
	CommandeRepository.save(com);
	}
	
	@Test
	public void testFindCommande()
	{
	commande c = CommandeRepository.findById(2L).get();
	System.out.println(c);
	}
	
	@Test
	public void testDeleteProduit()
	{
		CommandeRepository.deleteById(2L);;
	}

	@Test
	public void testListerTousCommandes()
	{
	List<commande> com = CommandeRepository.findAll();
	for (commande p : com)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindByNomCommande()
	{
	List<commande> coms = CommandeRepository.findByNomCom("l");
	for (commande c : coms)
	{
	System.out.println(c);
	}}
	
	
	@Test
	public void testFindByNomComContains()
	{
	List<commande> coms=CommandeRepository.findByNomComContains("l");
	for (commande c :coms)
	{
	System.out.println(c);
	}} 
	
	
	@Test
	public void testfindByNomPrix()
	{
	List<commande> coms = CommandeRepository.findByNomPrix("l", 1000.0);
	for (commande c : coms)
	{
	System.out.println(c);
	}
	} 
	
	
	@Test
	public void testfindByClient()
	{
	Client cli = new Client();
	cli.setIdCli(1L);
	List<commande> coms = CommandeRepository.findByClient(cli);
	for (commande c : coms)
	{
	System.out.println(c);
	}
	}
	
	@Test
	public void findByClientIdCli()
	{
	List<commande> coms = CommandeRepository.findByClientIdCli(1L);
	for (commande c : coms)
	{
	System.out.println(c);
	}}
	
	@Test
	public void testfindByOrderByNomComAsc()
	{
	List<commande> coms = CommandeRepository.findByOrderByNomComAsc();
	for (commande c : coms)
	{
	System.out.println(c);
	}
	 }





	
	
	}
	

	


