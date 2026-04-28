package fr.esgi.avis.domain.usecase;

import fr.esgi.avis.domain.model.Avis;

public interface RedigerAvis {
    void executer(Avis avis);
}