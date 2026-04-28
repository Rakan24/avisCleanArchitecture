package fr.esgi.avis.domain.model;

import java.util.List;

public class Editeur {
    private Long id; //[cite: 57]
    private String nom; //[cite: 55]
    private List<Jeu> jeux; //[cite: 57]
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public List<Jeu> getJeux() { return jeux; }
    public void setJeux(List<Jeu> jeux) { this.jeux = jeux; }
}