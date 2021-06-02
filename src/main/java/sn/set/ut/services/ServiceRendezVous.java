package sn.set.ut.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.set.ut.exceptions.RendezVousException;
import sn.set.ut.modele.RendezVous;
import sn.set.ut.repos.RendezVousRepo;

@Service
public class ServiceRendezVous {
	private RendezVousRepo rendezVousRepo;

	@Autowired
	public ServiceRendezVous(RendezVousRepo rvrepo) {
		// TODO Auto-generated constructor stub
		rendezVousRepo = rvrepo;
	}

	public RendezVous ajouterRV(RendezVous rv) {
		rv.setCodeRv(UUID.randomUUID().toString());
		return rendezVousRepo.save(rv);
	}

	public List<RendezVous> getAllRvs() {
		return rendezVousRepo.findAll();
	}

	public void supprimerRvById(Long id) {
		rendezVousRepo.deleteById(id);
	}

	public RendezVous trouverRvById(Long id) {
		return rendezVousRepo.findById(id)
			.orElseThrow(() -> new RendezVousException(
					"Un Rv avec l'ID"+id+" n'existe pas !!"));
	}
	
	public RendezVous updateRV(RendezVous rv) {
		return rendezVousRepo.save(rv);
	}

}
