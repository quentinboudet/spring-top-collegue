package dev.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tc_collegue")
public class Collegue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "pseudo")
	private String pseudo;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "score")
	private int score;

	public Collegue(String pseudo, String imageUrl, int score) {
		this(pseudo, imageUrl);
		this.score = score;
	}

	public Collegue(String pseudo, String imageUrl) {
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
		this.score = 0;
	}
	
	public Collegue() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
