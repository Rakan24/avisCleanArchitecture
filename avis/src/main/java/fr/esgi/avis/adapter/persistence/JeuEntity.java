package fr.esgi.avis.adapter.persistence;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jeu")
public class JeuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private float prix;
    private String image;
    private LocalDate dateDeSortie;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public float getPrix() { return prix; }
    public void setPrix(float prix) { this.prix = prix; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public LocalDate getDateDeSortie() { return dateDeSortie; }
    public void setDateDeSortie(LocalDate dateDeSortie) { this.dateDeSortie = dateDeSortie; }
}