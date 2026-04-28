package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.repository.AvisRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AvisPersistenceAdapter implements AvisRepository {

    private final AvisJpaRepository jpaRepository;
    private final AvisPersistenceMapper mapper; // Ajout du mapper

    public AvisPersistenceAdapter(AvisJpaRepository jpaRepository, AvisPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void sauvegarder(Avis avis) {
        // On utilise le mapper pour transformer le domaine en entité avant de sauvegarder
        AvisEntity entity = mapper.toEntity(avis);
        jpaRepository.save(entity);
    }

    @Override
    public Optional<Avis> recupererParId(Long id) {
        // On récupère l'entité et on utilise le mapper pour revenir vers le domaine
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Avis> recupererTous() {
        // On transforme toute la liste via le mapper
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}