package fr.esgi.avis.adapter.web;

import fr.esgi.avis.adapter.web.dto.JoueurRequest;
import fr.esgi.avis.domain.model.Joueur;
import fr.esgi.avis.domain.usecase.CreerJoueur;
import fr.esgi.avis.domain.usecase.ListerJoueurs;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurController {

    private final CreerJoueur creerJoueur;
    private final ListerJoueurs listerJoueurs;

    public JoueurController(CreerJoueur creerJoueur, ListerJoueurs listerJoueurs) {
        this.creerJoueur = creerJoueur;
        this.listerJoueurs = listerJoueurs;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creerJoueur(@RequestBody @Valid JoueurRequest request) {
        Joueur joueur = new Joueur();
        joueur.setPseudo(request.getPseudo());
        joueur.setEmail(request.getEmail());
        joueur.setMotDePasse(request.getMotDePasse());

        creerJoueur.executer(joueur);
    }

    @GetMapping
    public List<Joueur> listerTous() {
        return listerJoueurs.executer();
    }
}