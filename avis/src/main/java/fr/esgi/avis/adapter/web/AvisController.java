package fr.esgi.avis.adapter.web;

import fr.esgi.avis.adapter.web.dto.AvisRequest;
import fr.esgi.avis.domain.exception.EntityNotFoundException;
import fr.esgi.avis.domain.model.Avis;
import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.model.Joueur;
import fr.esgi.avis.domain.repository.AvisRepository;
import fr.esgi.avis.domain.repository.JeuRepository;
import fr.esgi.avis.domain.repository.JoueurRepository;
import fr.esgi.avis.domain.usecase.ListerAvis;
import fr.esgi.avis.domain.usecase.ModererAvis;
import fr.esgi.avis.domain.usecase.RedigerAvis;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis")
public class AvisController {

    private final ModererAvis modererAvis;
    private final RedigerAvis redigerAvis;
    private final ListerAvis listerAvis;
    private final JeuRepository jeuRepository;
    private final JoueurRepository joueurRepository;
    private final AvisRepository avisRepository;

    public AvisController(ModererAvis modererAvis,
                          RedigerAvis redigerAvis,
                          ListerAvis listerAvis,
                          JeuRepository jeuRepository,
                          JoueurRepository joueurRepository,
                          AvisRepository avisRepository) {
        this.modererAvis = modererAvis;
        this.redigerAvis = redigerAvis;
        this.listerAvis = listerAvis;
        this.jeuRepository = jeuRepository;
        this.joueurRepository = joueurRepository;
        this.avisRepository = avisRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody @Valid AvisRequest request) {
        Jeu jeu = jeuRepository.recupererParId(request.getJeuId())
                .orElseThrow(() -> new EntityNotFoundException("Jeu introuvable : " + request.getJeuId()));
        Joueur joueur = joueurRepository.recupererParId(request.getJoueurId())
                .orElseThrow(() -> new EntityNotFoundException("Joueur introuvable : " + request.getJoueurId()));

        Avis avis = new Avis();
        avis.setDescription(request.getDescription());
        avis.setNote(request.getNote());
        avis.setJeu(jeu);
        avis.setJoueur(joueur);

        redigerAvis.executer(avis);
    }

    @GetMapping
    public List<Avis> listerTous() {
        return listerAvis.executer();
    }

    @PostMapping("/{id}/valider")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void valider(@PathVariable Long id) {
        modererAvis.validerAvis(id);
    }

    @PostMapping("/{id}/rejeter")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void rejeter(@PathVariable Long id) {
        modererAvis.rejeterAvis(id);
    }
}