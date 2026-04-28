package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.model.StatutAvis;
import fr.esgi.avis.domain.repository.AvisRepository;
import java.time.LocalDateTime;

public class RedigerAvisImpl implements RedigerAvis {

    private final AvisRepository avisRepository;

    public RedigerAvisImpl(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    @Override
    public void executer(Avis avis) {
        // Logique métier : tout nouvel avis est mis en attente par défaut
        avis.setStatut(StatutAvis.EN_ATTENTE);
        avis.setDateDenvoi(LocalDateTime.now());

        avisRepository.sauvegarder(avis);
    }
}