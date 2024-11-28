package com.jihen.MyProject.entities;

	import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
	@Entity
	@Data
	public class commande {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCom;
	private String nomCom;
	private Double prixCom;
	private Date dateCreation;
	
	@ManyToOne private Client client;

	@OneToOne private Image image;
	
	@OneToMany (mappedBy = "commande")
	 private List<Image> images;
	
	
	
	
	
	
	
	public commande() {
	super();
	}

	
	

}
