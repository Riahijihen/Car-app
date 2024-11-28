package com.jihen.MyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jihen.MyProject.entities.Client;
import com.jihen.MyProject.entities.Image;
import com.jihen.MyProject.entities.commande;
import com.jihen.MyProject.repos.CommandeRepository;
import com.jihen.MyProject.repos.ImageRepository;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    ImageRepository imageRepository;

    @Override
    public commande saveCommande(commande c) {
        return commandeRepository.save(c);
    }

    @Override
    public commande updateCommande(commande c) {
return commandeRepository.save(c);
    }

    @Override
    public void deleteCommande(commande c) {
        commandeRepository.delete(c);
    }

    @Override
    public void deleteCommandeById(Long id) {
        commande commande = commandeRepository.findById(id).orElse(null);

        if (commande != null) {
            // Iterate over the list of images and delete each one
            List<Image> images = commande.getImages();
            if (images != null) {
                for (Image image : images) {
                    // Delete the image from the database
                    imageRepository.deleteById(image.getIdImage());
                }
            }

            // Finally, delete the commande
            commandeRepository.deleteById(id);
        }
    }

    @Override
    public commande getCommande(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public List<commande> findByNomCommande(String nom) {
        // Implement this method based on your repository's query methods
        return null;
    }

    @Override
    public List<commande> findByNomCommandeContains(String nom) {
        // Implement this method based on your repository's query methods
        return null;
    }

    @Override
    public List<commande> findByNomPrix(String nom, Double prix) {
        // Implement this method based on your repository's query methods
        return null;
    }

    @Override
    public List<commande> findByClient(Client client) {
        // Implement this method based on your repository's query methods
        return null;
    }

    @Override
    public List<commande> findByClietIdCli(Long id) {
        // Implement this method based on your repository's query methods
        return commandeRepository.findByClientIdCli(id);
    }

    @Override
    public List<commande> findByOrderByNomCommandeAsc() {
        // Implement this method based on your repository's query methods
        return null;
    }

    @Override
    public List<commande> trierCommandesNomsPrix() {
        // Implement this method based on your repository's query methods
        return null;
    }
}
