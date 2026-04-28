package fr.esgi.avis.domain.repository;

import fr.esgi.avis.domain.model.Jeu;
import java.util.List;
import java.util.Optional;

public interface JeuRepository {
    void sauvegarder(Jeu jeu);
    List<Jeu> recupererTous();
    Optional<Jeu> recupererParId(Long id);
}