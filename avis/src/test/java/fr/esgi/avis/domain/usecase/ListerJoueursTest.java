package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Joueur;
import fr.esgi.avis.domain.repository.JoueurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListerJoueursTest {

    @Mock
    private JoueurRepository joueurRepository;

    private ListerJoueurs listerJoueurs;

    @BeforeEach
    void setUp() {
        listerJoueurs = new ListerJoueursImpl(joueurRepository);
    }

    @Test
    void devrait_retourner_la_liste_des_joueurs() {
        // GIVEN
        Joueur j1 = new Joueur();
        j1.setPseudo("Liam");

        Joueur j2 = new Joueur();
        j2.setPseudo("Alice");

        when(joueurRepository.recupererTous()).thenReturn(List.of(j1, j2));

        // WHEN
        List<Joueur> resultat = listerJoueurs.executer();

        // THEN
        assertThat(resultat).hasSize(2);
        assertThat(resultat.get(0).getPseudo()).isEqualTo("Liam");
        assertThat(resultat.get(1).getPseudo()).isEqualTo("Alice");
    }

    @Test
    void devrait_retourner_une_liste_vide_si_aucun_joueur() {
        // GIVEN
        when(joueurRepository.recupererTous()).thenReturn(List.of());

        // WHEN
        List<Joueur> resultat = listerJoueurs.executer();

        // THEN
        assertThat(resultat).isEmpty();
        verify(joueurRepository, times(1)).recupererTous();
    }
}