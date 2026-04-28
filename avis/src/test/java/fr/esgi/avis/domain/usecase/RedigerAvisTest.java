package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.model.StatutAvis;
import fr.esgi.avis.domain.repository.AvisRepository;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RedigerAvisTest {
    private final AvisRepository avisRepository = mock(AvisRepository.class);
    private final RedigerAvis redigerAvis = new RedigerAvisImpl(avisRepository);

    @Test
    void doitInitialiserAvisCorrectementAvantSauvegarde() {
        // Given
        Avis avis = new Avis();
        avis.setDescription("Super jeu !");

        // When
        redigerAvis.executer(avis);

        // Then
        assertEquals(StatutAvis.EN_ATTENTE, avis.getStatut());
        assertNotNull(avis.getDateDenvoi());
        verify(avisRepository, times(1)).sauvegarder(avis);
    }
}