package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.model.StatutAvis;
import fr.esgi.avis.domain.repository.AvisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListerAvisTest {

    @Mock
    private AvisRepository avisRepository;

    private ListerAvis listerAvis;

    @BeforeEach
    void setUp() {
        listerAvis = new ListerAvisImpl(avisRepository);
    }

    @Test
    void devrait_retourner_la_liste_des_avis() {
        // GIVEN
        Avis avis1 = new Avis();
        avis1.setDescription("Super jeu !");
        avis1.setNote(5f);
        avis1.setStatut(StatutAvis.VALIDE);

        Avis avis2 = new Avis();
        avis2.setDescription("Pas terrible...");
        avis2.setNote(2f);
        avis2.setStatut(StatutAvis.EN_ATTENTE);

        when(avisRepository.recupererTous()).thenReturn(List.of(avis1, avis2));

        // WHEN
        List<Avis> resultat = listerAvis.executer();

        // THEN
        assertThat(resultat).hasSize(2);
        assertThat(resultat.get(0).getStatut()).isEqualTo(StatutAvis.VALIDE);
        assertThat(resultat.get(1).getNote()).isEqualTo(2f);
    }

    @Test
    void devrait_retourner_une_liste_vide_si_aucun_avis() {
        // GIVEN
        when(avisRepository.recupererTous()).thenReturn(List.of());

        // WHEN
        List<Avis> resultat = listerAvis.executer();

        // THEN
        assertThat(resultat).isEmpty();
        verify(avisRepository, times(1)).recupererTous();
    }
}