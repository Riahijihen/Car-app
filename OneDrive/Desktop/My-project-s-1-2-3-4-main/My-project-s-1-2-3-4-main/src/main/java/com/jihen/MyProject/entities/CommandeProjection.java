package com.jihen.MyProject.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomCom", types = { commande.class })
public interface CommandeProjection {
	public String getNomCommande();


}
