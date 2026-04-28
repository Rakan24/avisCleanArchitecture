package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.repository.JeuRepository;

public class AjouterJeuImpl implements AjouterJeu {

    private final JeuRepository jeuRepository;

    public AjouterJeuImpl(JeuRepository jeuRepository) {
        this.jeuRepository = jeuRepository;
    }

    @Override
    public void executer(Jeu jeu) {
        // Tu peux ajouter ici une règle métier, par exemple :
        // Vérifier si un jeu avec le même nom existe déjà via le repository
        this.jeuRepository.sauvegarder(jeu);
    }
}