package fr.esgi.avis.domain.model;

public class Classification {
    private Long id; //[cite: 67]
    private String nom; //[cite: 69]
    private String couleurRGB; //[cite: 66]
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getCouleurRGB() { return couleurRGB; }
    public void setCouleurRGB(String couleurRGB) { this.couleurRGB = couleurRGB; }
}