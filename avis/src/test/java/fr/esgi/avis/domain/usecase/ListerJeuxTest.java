package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.repository.JeuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListerJeuxTest {

    @Mock
    private JeuRepository jeuRepository;

    private ListerJeux listerJeux;

    @BeforeEach
    void setUp() {
        listerJeux = new ListerJeuxImpl(jeuRepository);
    }

    @Test
    void devrait_retourner_la_liste_des_jeux() {
        // GIVEN
        Jeu jeu1 = new Jeu();
        jeu1.setNom("Angry Birds");

        Jeu jeu2 = new Jeu();
        jeu2.setNom("Minecraft");

        when(jeuRepository.recupererTous()).thenReturn(List.of(jeu1, jeu2));

        // WHEN
        List<Jeu> resultat = listerJeux.executer();

        // THEN
        assertThat(resultat).hasSize(2);
        assertThat(resultat.get(0).getNom()).isEqualTo("Angry Birds");
        assertThat(resultat.get(1).getNom()).isEqualTo("Minecraft");
    }

    @Test
    void devrait_retourner_une_liste_vide_si_aucun_jeu() {
        // GIVEN
        when(jeuRepository.recupererTous()).thenReturn(List.of());

        // WHEN
        List<Jeu> resultat = listerJeux.executer();

        // THEN
        assertThat(resultat).isEmpty();
        verify(jeuRepository, times(1)).recupererTous();
    }
}