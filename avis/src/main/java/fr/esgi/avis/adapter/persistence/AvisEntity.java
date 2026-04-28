package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.domain.model.StatutAvis;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avis")
public class AvisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Float note;
    private LocalDateTime dateDenvoi;

    @Enumerated(EnumType.STRING)
    private StatutAvis statut;

    private Long jeuId;
    private Long joueurId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Float getNote() { return note; }
    public void setNote(Float note) { this.note = note; }

    public LocalDateTime getDateDenvoi() { return dateDenvoi; }
    public void setDateDenvoi(LocalDateTime dateDenvoi) { this.dateDenvoi = dateDenvoi; }

    public StatutAvis getStatut() { return statut; }
    public void setStatut(StatutAvis statut) { this.statut = statut; }

    public Long getJeuId() { return jeuId; }
    public void setJeuId(Long jeuId) { this.jeuId = jeuId; }

    public Long getJoueurId() { return joueurId; }
    public void setJoueurId(Long joueurId) { this.joueurId = joueurId; }
}