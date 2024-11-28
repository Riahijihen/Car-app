package com.jihen.MyProject.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Client {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCli;
private String nomCli;
private String adressCli;
private String telCli;
private String email;
@JsonIgnore
@OneToMany(mappedBy = "client")
private List<commande> commandes;


}