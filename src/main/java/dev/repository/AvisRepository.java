package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Avis;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
	public List<Avis> findByIdGreaterThan(int id);
	public List<Avis> findFirst3OrderById(int id);
	public List<Avis> findById(int id);
}
