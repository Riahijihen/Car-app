package com.jihen.MyProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.jihen.MyProject.entities.Client;

@RepositoryRestResource(path = "cli")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular 
public interface ClientRepository extends JpaRepository<Client, Long>{

}
