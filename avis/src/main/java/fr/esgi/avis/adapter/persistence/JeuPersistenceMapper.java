package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.domain.model.Jeu;
import org.springframework.stereotype.Component;

@Component
public class JeuPersistenceMapper {
    public JeuEntity toEntity(Jeu jeu) {
        JeuEntity entity = new JeuEntity();
        entity.setId(jeu.getId());
        entity.setNom(jeu.getNom());
        entity.setDescription(jeu.getDescription());
        return entity;
    }

    public Jeu toDomain(JeuEntity entity) {
        Jeu jeu = new Jeu();
        jeu.setId(entity.getId());
        jeu.setNom(entity.getNom());
        jeu.setDescription(entity.getDescription());
        return jeu;
    }
}