package sn.set.ut.controleurs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.set.ut.services.ServiceRendezVous;
import sn.set.ut.modele.RendezVous;
@RestController
@RequestMapping("/api")
public class RendezVousControleur {
	ServiceRendezVous serviceRendezVous;
	
	
	public RendezVousControleur(ServiceRendezVous serviceRendezVous) {
		this.serviceRendezVous = serviceRendezVous;
	}
	/*
	@GetMapping("/")
	public String index() {
		return "Bienvenue sur mon back-end";
	}
	*/
	
	@GetMapping(value = {
			"/",
			"/getrvs"
	})
	public ResponseEntity<List<RendezVous>> getAllRvs(){
		List<RendezVous> rvs=serviceRendezVous.getAllRvs();
		return new ResponseEntity<List<RendezVous>>(rvs, HttpStatus.OK);
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<RendezVous> chercherRv(@PathVariable("id") Long id){
		RendezVous rv=serviceRendezVous.trouverRvById(id);
		return new ResponseEntity<RendezVous>(rv, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimerRv(@PathVariable("id") Long id){
		serviceRendezVous.supprimerRvById(id);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<RendezVous> ajouterRv(@RequestBody RendezVous rv){
		RendezVous newRv=serviceRendezVous.ajouterRV(rv);
		return new ResponseEntity<RendezVous>(rv, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<RendezVous> updateRv(@RequestBody RendezVous rv){
		RendezVous newRv=serviceRendezVous.updateRV(rv);
		return new ResponseEntity<RendezVous>(rv, HttpStatus.OK);
	}
}
