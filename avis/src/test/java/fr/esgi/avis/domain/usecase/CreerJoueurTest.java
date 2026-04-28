package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Joueur;
import fr.esgi.avis.domain.repository.JoueurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreerJoueurTest {

    @Mock
    private JoueurRepository joueurRepository;

    private CreerJoueur creerJoueur;

    @BeforeEach
    void setUp() {
        creerJoueur = new CreerJoueurImpl(joueurRepository);
    }

    @Test
    void devrait_sauvegarder_un_joueur() {
        // GIVEN
        Joueur joueur = new Joueur();
        joueur.setPseudo("Liam");
        joueur.setEmail("liam@email.fr");
        joueur.setMotDePasse("1234");

        // WHEN
        creerJoueur.executer(joueur);

        // THEN
        verify(joueurRepository, times(1)).sauvegarder(joueur);
    }

    @Test
    void devrait_appeler_le_repository_une_seule_fois() {
        // GIVEN
        Joueur joueur = new Joueur();
        joueur.setPseudo("Alice");

        // WHEN
        creerJoueur.executer(joueur);

        // THEN
        verify(joueurRepository, times(1)).sauvegarder(any(Joueur.class));
        verifyNoMoreInteractions(joueurRepository);
    }
}