package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.model.StatutAvis;
import fr.esgi.avis.domain.repository.AvisRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ModererAvisTest {
    private final AvisRepository avisRepository = mock(AvisRepository.class);
    private final ModererAvis modererAvis = new ModererAvisImpl(avisRepository);

    @Test
    void doitPasserUnAvisEnValide() {
        // Given : Un avis existant en attente
        Long idAvis = 1L;
        Avis avis = new Avis();
        avis.setId(idAvis);
        avis.setStatut(StatutAvis.EN_ATTENTE);

        // On simule le comportement du repository
        when(avisRepository.recupererParId(idAvis)).thenReturn(Optional.of(avis));

        // When : On demande la validation
        modererAvis.validerAvis(idAvis);

        // Then : Le statut doit être VALIDE et l'avis doit être sauvegardé
        assertEquals(StatutAvis.VALIDE, avis.getStatut());
        verify(avisRepository, times(1)).sauvegarder(avis);
    }
}