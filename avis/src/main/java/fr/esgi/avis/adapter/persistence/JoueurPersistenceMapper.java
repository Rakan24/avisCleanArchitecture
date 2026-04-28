package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.domain.model.Joueur;
import org.springframework.stereotype.Component;

@Component
public class JoueurPersistenceMapper {

    public JoueurEntity toEntity(Joueur joueur) {
        JoueurEntity entity = new JoueurEntity();
        entity.setId(joueur.getId());
        entity.setPseudo(joueur.getPseudo());
        entity.setEmail(joueur.getEmail());
        entity.setMotDePasse(joueur.getMotDePasse());
        entity.setDateDeNaissance(joueur.getDateDeNaissance());
        return entity;
    }

    public Joueur toDomain(JoueurEntity entity) {
        Joueur joueur = new Joueur();
        joueur.setId(entity.getId());
        joueur.setPseudo(entity.getPseudo());
        joueur.setEmail(entity.getEmail());
        joueur.setMotDePasse(entity.getMotDePasse());
        joueur.setDateDeNaissance(entity.getDateDeNaissance());
        return joueur;
    }
}