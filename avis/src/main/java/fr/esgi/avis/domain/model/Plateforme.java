package fr.esgi.avis.domain.model;

import java.time.LocalDate;

public class Plateforme {
    private Long id; //[cite: 48]
    private String nom; //[cite: 52]
    private LocalDate dateDeSortie; //[cite: 47]
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public LocalDate getDateDeSortie() { return dateDeSortie; }
    public void setDateDeSortie(LocalDate dateDeSortie) { this.dateDeSortie = dateDeSortie; }
}