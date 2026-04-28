package fr.esgi.avis.domain.model;

public abstract class Utilisateur {
    private Long id; //[cite: 68]
    private String pseudo; //[cite: 61]
    private String email; //[cite: 64]
    private String motDePasse; //[cite: 59]
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPseudo() { return pseudo; }
    public void setPseudo(String pseudo) { this.pseudo = pseudo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
}