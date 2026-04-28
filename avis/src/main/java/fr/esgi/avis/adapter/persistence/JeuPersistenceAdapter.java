package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.repository.JeuRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JeuPersistenceAdapter implements JeuRepository {

    private final JeuJpaRepository jpaRepository;
    private final JeuPersistenceMapper mapper; // ← ajouter

    public JeuPersistenceAdapter(JeuJpaRepository jpaRepository, JeuPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void sauvegarder(Jeu jeu) {
        JeuEntity entity = mapper.toEntity(jeu); // ← utiliser le mapper
        jpaRepository.save(entity);
    }

    @Override
    public List<Jeu> recupererTous() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Jeu> recupererParId(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }
}