package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Jeu;
import java.util.List;

public interface ListerJeux {
    List<Jeu> executer();
}