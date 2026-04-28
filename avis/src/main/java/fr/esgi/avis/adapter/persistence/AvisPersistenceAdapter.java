package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.model.Joueur;
import fr.esgi.avis.domain.repository.AvisRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AvisPersistenceAdapter implements AvisRepository {

    private final AvisJpaRepository avisJpaRepository;
    private final AvisPersistenceMapper mapper;
    private final JeuJpaRepository jeuJpaRepository;
    private final JeuPersistenceMapper jeuMapper;
    private final JoueurJpaRepository joueurJpaRepository;
    private final JoueurPersistenceMapper joueurMapper;

    public AvisPersistenceAdapter(AvisJpaRepository avisJpaRepository,
                                  AvisPersistenceMapper mapper,
                                  JeuJpaRepository jeuJpaRepository,
                                  JeuPersistenceMapper jeuMapper,
                                  JoueurJpaRepository joueurJpaRepository,
                                  JoueurPersistenceMapper joueurMapper) {
        this.avisJpaRepository = avisJpaRepository;
        this.mapper = mapper;
        this.jeuJpaRepository = jeuJpaRepository;
        this.jeuMapper = jeuMapper;
        this.joueurJpaRepository = joueurJpaRepository;
        this.joueurMapper = joueurMapper;
    }

    @Override
    public void sauvegarder(Avis avis) {
        AvisEntity entity = mapper.toEntity(avis);
        avisJpaRepository.save(entity);
    }

    @Override
    public Optional<Avis> recupererParId(Long id) {
        return avisJpaRepository.findById(id)
                .map(this::enrichir);
    }

    @Override
    public List<Avis> recupererTous() {
        return avisJpaRepository.findAll().stream()
                .map(this::enrichir)
                .collect(Collectors.toList());
    }

    /**
     * Convertit une AvisEntity en Avis domaine,
     * en allant chercher le Jeu et le Joueur complets en base.
     */
    private Avis enrichir(AvisEntity entity) {
        Avis avis = mapper.toDomain(entity);

        // Charger le Jeu complet si l'ID est présent
        if (entity.getJeuId() != null) {
            Jeu jeu = jeuJpaRepository.findById(entity.getJeuId())
                    .map(jeuMapper::toDomain)
                    .orElse(avis.getJeu()); // fallback sur l'objet minimaliste
            avis.setJeu(jeu);
        }

        // Charger le Joueur complet si l'ID est présent
        if (entity.getJoueurId() != null) {
            Joueur joueur = joueurJpaRepository.findById(entity.getJoueurId())
                    .map(joueurMapper::toDomain)
                    .orElse(avis.getJoueur()); // fallback sur l'objet minimaliste
            avis.setJoueur(joueur);
        }

        return avis;
    }
}