package fr.esgi.avis.domain.repository;

import fr.esgi.avis.domain.model.Joueur;
import java.util.Optional;
import java.util.List;

public interface JoueurRepository {
    void sauvegarder(Joueur joueur);
    Optional<Joueur> recupererParId(Long id);
    List<Joueur> recupererTous();
}