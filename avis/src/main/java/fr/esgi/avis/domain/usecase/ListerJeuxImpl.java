package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.repository.JeuRepository;
import java.util.List;

public class ListerJeuxImpl implements ListerJeux {
    private final JeuRepository jeuRepository;

    public ListerJeuxImpl(JeuRepository jeuRepository) {
        this.jeuRepository = jeuRepository;
    }

    @Override
    public List<Jeu> executer() {
        return jeuRepository.recupererTous();
    }
}