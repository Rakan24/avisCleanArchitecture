package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.model.Joueur;
import org.springframework.stereotype.Component;

@Component
public class AvisPersistenceMapper {

    public AvisEntity toEntity(Avis avis) {
        if (avis == null) return null;

        AvisEntity entity = new AvisEntity();
        entity.setId(avis.getId());
        entity.setDescription(avis.getDescription());
        entity.setNote(avis.getNote());
        entity.setDateDenvoi(avis.getDateDenvoi());
        entity.setStatut(avis.getStatut());

        if (avis.getJeu() != null) {
            entity.setJeuId(avis.getJeu().getId());
        }
        if (avis.getJoueur() != null) {
            entity.setJoueurId(avis.getJoueur().getId());
        }

        return entity;
    }

    public Avis toDomain(AvisEntity entity) {
        if (entity == null) return null;

        Avis avis = new Avis();
        avis.setId(entity.getId());
        avis.setDescription(entity.getDescription());
        avis.setNote(entity.getNote());
        avis.setDateDenvoi(entity.getDateDenvoi());
        avis.setStatut(entity.getStatut());

        // Ajoute ceci pour ne pas perdre les liens vers le Jeu et le Joueur
        if (entity.getJeuId() != null) {
            // On crée un objet Jeu minimaliste avec juste l'ID
            // car le domaine en a besoin pour identifier le jeu
            Jeu jeu = new Jeu();
            jeu.setId(entity.getJeuId());
            avis.setJeu(jeu);
        }

        if (entity.getJoueurId() != null) {
            Joueur joueur = new Joueur();
            joueur.setId(entity.getJoueurId());
            avis.setJoueur(joueur);
        }

        return avis;
    }
}