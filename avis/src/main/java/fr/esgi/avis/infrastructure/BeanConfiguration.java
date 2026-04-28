package fr.esgi.avis.infrastructure;

import fr.esgi.avis.domain.repository.AvisRepository;
import fr.esgi.avis.domain.repository.JeuRepository;
import fr.esgi.avis.domain.repository.JoueurRepository;
import fr.esgi.avis.domain.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AjouterJeu ajouterJeu(JeuRepository jeuRepository) {
        return new AjouterJeuImpl(jeuRepository);
    }

    @Bean
    public ListerJeux listerJeux(JeuRepository jeuRepository) {
        return new ListerJeuxImpl(jeuRepository);
    }

    @Bean
    public ModererAvis modererAvis(AvisRepository avisRepository) {
        return new ModererAvisImpl(avisRepository);
    }

    @Bean
    public RedigerAvis redigerAvis(AvisRepository avisRepository) {
        return new RedigerAvisImpl(avisRepository);
    }

    @Bean
    public ListerAvis listerAvis(AvisRepository avisRepository) {
        return new ListerAvisImpl(avisRepository);
    }

    @Bean
    public CreerJoueur creerJoueur(JoueurRepository joueurRepository) {
        return new CreerJoueurImpl(joueurRepository);
    }

    @Bean
    public ListerJoueurs listerJoueurs(JoueurRepository joueurRepository) {
        return new ListerJoueursImpl(joueurRepository);
    }
}