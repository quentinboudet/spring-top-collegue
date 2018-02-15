package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Collegue;

public interface ColleguesRepository extends JpaRepository<Collegue, Integer> {
	public Collegue findByPseudo(String pseudo);
}
