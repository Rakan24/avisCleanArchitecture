package fr.esgi.avis.adapter.web;

import fr.esgi.avis.adapter.web.dto.JeuRequest;
import fr.esgi.avis.domain.model.Jeu;
import fr.esgi.avis.domain.usecase.AjouterJeu;
import fr.esgi.avis.domain.usecase.ListerJeux;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jeux")
public class JeuController {

    private final AjouterJeu ajouterJeu;
    private final ListerJeux listerJeux;

    public JeuController(AjouterJeu ajouterJeu, ListerJeux listerJeux) {
        this.ajouterJeu = ajouterJeu;
        this.listerJeux = listerJeux;
    }

    @PostMapping
    public void creerJeu(@RequestBody JeuRequest request) {
        Jeu nouveauJeu = new Jeu();
        nouveauJeu.setNom(request.getNom());
        nouveauJeu.setDescription(request.getDescription());
        nouveauJeu.setPrix(request.getPrix());

        ajouterJeu.executer(nouveauJeu);
    }

    @GetMapping
    public List<Jeu> listerTous() {
        return listerJeux.executer();
    }
}