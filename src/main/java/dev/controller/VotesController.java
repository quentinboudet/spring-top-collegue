package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.entite.Avis;
import dev.repository.AvisRepository;

@Component
@RequestMapping("/votes")
@CrossOrigin
public class VotesController {
	
	@Autowired
	AvisRepository avisR;
	
	@GetMapping
	@ResponseBody
	public List<Avis> getVotes(@RequestParam(value="since", required = false) Integer since){
		if(since != null) {
			System.out.println("since" + avisR.findByIdGreaterThan(since));
			return avisR.findByIdGreaterThan(since);
		}
		else {
			System.out.println("no since" + avisR.findFirst3OrderById(0));
			return avisR.findFirst3OrderById(0);
		}
	}
}
