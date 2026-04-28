package fr.esgi.avis.adapter.web.dto;

import jakarta.validation.constraints.*;

public class AvisRequest {

    @NotBlank(message = "La description est obligatoire")
    private String description;

    @Min(value = 0, message = "La note minimum est 0")
    @Max(value = 5, message = "La note maximum est 5")
    private Float note;

    @NotNull(message = "L'ID du jeu est obligatoire")
    private Long jeuId;

    @NotNull(message = "L'ID du joueur est obligatoire")
    private Long joueurId;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Float getNote() { return note; }
    public void setNote(Float note) { this.note = note; }

    public Long getJeuId() { return jeuId; }
    public void setJeuId(Long jeuId) { this.jeuId = jeuId; }

    public Long getJoueurId() { return joueurId; }
    public void setJoueurId(Long joueurId) { this.joueurId = joueurId; }
}