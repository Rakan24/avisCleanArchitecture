package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.repository.AvisRepository;
import java.util.List;

public class ListerAvisImpl implements ListerAvis {

    private final AvisRepository avisRepository;

    public ListerAvisImpl(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    @Override
    public List<Avis> executer() {
        return avisRepository.recupererTous();
    }
}