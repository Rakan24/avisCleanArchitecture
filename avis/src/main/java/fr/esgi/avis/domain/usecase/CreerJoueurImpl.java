package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Joueur;
import fr.esgi.avis.domain.repository.JoueurRepository;

public class CreerJoueurImpl implements CreerJoueur {

    private final JoueurRepository joueurRepository;

    public CreerJoueurImpl(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    @Override
    public void executer(Joueur joueur) {
        joueurRepository.sauvegarder(joueur);
    }
}