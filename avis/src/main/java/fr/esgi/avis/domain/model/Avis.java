package fr.esgi.avis.domain.model;

import java.time.LocalDateTime;

public class Avis {
    private Long id;
    private String description;
    private Float note;
    private LocalDateTime dateDenvoi;
    private Jeu jeu;
    private Joueur joueur;

    // Nouvel attribut pour la modération
    private StatutAvis statut = StatutAvis.EN_ATTENTE;

    // Logique métier : Un avis ne peut être validé que s'il est en attente
    public void valider() {
        if (this.statut == StatutAvis.EN_ATTENTE) {
            this.statut = StatutAvis.VALIDE;
        }
    }

    public void rejeter() {
        this.statut = StatutAvis.REJETE;
    }

    // N'oublie pas les getters/setters pour le statut
    public StatutAvis getStatut() { return statut; }
    public void setStatut(StatutAvis statut) { this.statut = statut; }





    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Float getNote() { return note; }
    public void setNote(Float note) { this.note = note; }

    public LocalDateTime getDateDenvoi() { return dateDenvoi; }
    public void setDateDenvoi(LocalDateTime dateDenvoi) { this.dateDenvoi = dateDenvoi; }

    public Jeu getJeu() { return jeu; }
    public void setJeu(Jeu jeu) { this.jeu = jeu; }

    public Joueur getJoueur() { return joueur; }
    public void setJoueur(Joueur joueur) { this.joueur = joueur; }
}