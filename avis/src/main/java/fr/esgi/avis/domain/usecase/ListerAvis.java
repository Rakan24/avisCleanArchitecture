package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Avis;
import java.util.List;

public interface ListerAvis {
    List<Avis> executer();
}