package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.repository.AvisRepository;
import fr.esgi.avis.domain.exception.EntityNotFoundException; // Nouvel import nécessaire

public class ModererAvisImpl implements ModererAvis {
    private final AvisRepository avisRepository;

    public ModererAvisImpl(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    @Override
    public void validerAvis(Long idAvis) {
        Avis avis = avisRepository.recupererParId(idAvis)
                .orElseThrow(() -> new EntityNotFoundException("L'avis avec l'ID " + idAvis + " n'a pas été trouvé."));

        avis.valider();
        avisRepository.sauvegarder(avis);
    }

    @Override
    public void rejeterAvis(Long idAvis) {
        Avis avis = avisRepository.recupererParId(idAvis)
                .orElseThrow(() -> new EntityNotFoundException("L'avis avec l'ID " + idAvis + " n'a pas été trouvé."));

        avis.rejeter();
        avisRepository.sauvegarder(avis);
    }
}