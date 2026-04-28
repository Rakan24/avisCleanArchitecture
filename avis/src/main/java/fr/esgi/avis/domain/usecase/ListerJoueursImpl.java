package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Joueur;
import fr.esgi.avis.domain.repository.JoueurRepository;
import java.util.List;

public class ListerJoueursImpl implements ListerJoueurs {

    private final JoueurRepository joueurRepository;

    public ListerJoueursImpl(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    @Override
    public List<Joueur> executer() {
        return joueurRepository.recupererTous();
    }
}