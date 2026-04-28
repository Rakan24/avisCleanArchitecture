package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Joueur;
import java.util.List;

public interface ListerJoueurs {
    List<Joueur> executer();
}