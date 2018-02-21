package dev.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tc_avis")
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "type")
	private AvisType type ;
	
	@Column(name = "score_rendu")
	private Integer scoreRendu;
	
	@ManyToOne
	private Collegue collegue;

	public Avis(AvisType type, Integer scoreRendu, Collegue collegue) {
		this.type = type;
		this.scoreRendu = scoreRendu;
		this.collegue = collegue;
	}

	public Avis() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AvisType getType() {
		return type;
	}

	public void setType(AvisType type) {
		this.type = type;
	}

	public Integer getScoreRendu() {
		return scoreRendu;
	}

	public void setScoreRendu(Integer scoreRendu) {
		this.scoreRendu = scoreRendu;
	}

	public Collegue getCollegue() {
		return collegue;
	}

	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

}
