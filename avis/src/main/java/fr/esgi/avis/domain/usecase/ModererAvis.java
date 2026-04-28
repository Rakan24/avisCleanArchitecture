package fr.esgi.avis.domain.usecase;

public interface ModererAvis {
    void validerAvis(Long idAvis);
    void rejeterAvis(Long idAvis);
}