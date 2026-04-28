package fr.esgi.avis.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurJpaRepository extends JpaRepository<JoueurEntity, Long> {
}