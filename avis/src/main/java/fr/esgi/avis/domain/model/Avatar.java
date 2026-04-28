package fr.esgi.avis.domain.model;

public class Avatar {
    private Long id; //[cite: 74]
    private String nom; //[cite: 73]
    private Joueur joueur; //[cite: 76]

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Joueur getJoueur() { return joueur; }
    public void setJoueur(Joueur joueur) { this.joueur = joueur; }
}