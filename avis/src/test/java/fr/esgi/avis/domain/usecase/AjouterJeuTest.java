package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.repository.JeuRepository; // Vérifie que cet import pointe bien sur le nouveau package repository
import org.junit.jupiter.api.Test;

// On force les imports statiques pour verify, mock et times
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class AjouterJeuTest {
    private final JeuRepository jeuRepository = mock(JeuRepository.class);
    private final AjouterJeu ajouterJeu = new AjouterJeuImpl(jeuRepository);

    @Test
    void doitSauvegarderUnJeu() {
        Jeu jeu = new Jeu();
        jeu.setNom("Zelda");

        ajouterJeu.executer(jeu);

        verify(jeuRepository, times(1)).sauvegarder(jeu);
    }
}