package fr.esgi.avis.domain.model;

import java.time.LocalDate;

public class Jeu {
    private Long id;
    private String nom;
    private String description;
    private LocalDate dateDeSortie;
    private float prix;
    private String image;
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDateDeSortie() { return dateDeSortie; }
    public void setDateDeSortie(LocalDate dateDeSortie) { this.dateDeSortie = dateDeSortie; }

    public float getPrix() { return prix; }
    public void setPrix(float prix) { this.prix = prix; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}