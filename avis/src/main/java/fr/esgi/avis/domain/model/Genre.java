package fr.esgi.avis.domain.model;

import java.util.List; // Import obligatoire pour utiliser List

public class Genre {
    private Long id; //[cite: 43]
    private String nom; //[cite: 43]
    private List<Jeu> jeux; //[cite: 44]

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public List<Jeu> getJeux() { return jeux; }
    public void setJeux(List<Jeu> jeux) { this.jeux = jeux; }
}