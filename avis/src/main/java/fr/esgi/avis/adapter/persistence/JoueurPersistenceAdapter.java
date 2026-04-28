package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.domain.model.Joueur;
import fr.esgi.avis.domain.repository.JoueurRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JoueurPersistenceAdapter implements JoueurRepository {

    private final JoueurJpaRepository jpaRepository;
    private final JoueurPersistenceMapper mapper;

    public JoueurPersistenceAdapter(JoueurJpaRepository jpaRepository, JoueurPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void sauvegarder(Joueur joueur) {
        jpaRepository.save(mapper.toEntity(joueur));
    }

    @Override
    public Optional<Joueur> recupererParId(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Joueur> recupererTous() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}