package fr.esgi.avis.domain.repository;

import fr.esgi.avis.domain.model.Avis;
import java.util.Optional;
import java.util.List;

public interface AvisRepository {
    // Pour sauvegarder l'avis après modification (validation/rejet)
    void sauvegarder(Avis avis);

    // Pour retrouver l'avis à modérer via son ID
    Optional<Avis> recupererParId(Long id);

    // Utile pour afficher la liste des avis en attente aux modérateurs
    List<Avis> recupererTous();
}