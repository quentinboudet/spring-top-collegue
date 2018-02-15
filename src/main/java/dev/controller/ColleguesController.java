package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.entite.Collegue;
import dev.repository.ColleguesRepository;

@Component
@RequestMapping("/collegues")
@CrossOrigin
public class ColleguesController {
	
	@Autowired
	ColleguesRepository colR;

	@Transactional
	@GetMapping
	@ResponseBody
	public List<Collegue> getCollegues(){
		if(colR.findAll().size() == 0) {
			System.out.println("if passe");
			List<Collegue> collegues = new ArrayList<>();
		    collegues.add(new Collegue("freak", "truc/imgf.png", 50));
		    collegues.add(new Collegue("drodo", "truc/imgf.png", 20));
		    collegues.add(new Collegue("piko", "truc/imgf.png", 100));
		    collegues.add(new Collegue("groop", "truc/imgf.png", 120));
		    collegues.add(new Collegue("veuti", "truc/imgf.png", 40));
		    
		    for(Collegue c : collegues) {
		    	colR.save(c);
		    }
		}
	    
	    
		return colR.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public String ajoutCollegue(@RequestBody Collegue collegue) {
		colR.save(collegue);
		
		return "ok";
	}
	
	@PatchMapping(value="/{pseudo}")
	@ResponseBody
	public Collegue noterCollegue(@RequestBody Map<String, String> note, @PathVariable String pseudo) {
		Collegue c = colR.findByPseudo(pseudo);
		if(note.containsKey("action")) {
			String n = note.get("action");
			int score = c.getScore();
			if("aimer".equals(n)) {
				c.setScore(score+10);
			}
			else if("detester".equals(n)) {
				c.setScore(score-5);
			}
			else {
//				return "Veillez donner en parametre 'aimer' ou 'detester'";
			}
			colR.save(c);
		}

		return c;
//		return "Veillez mettre 'action' en clé";
	}
}
