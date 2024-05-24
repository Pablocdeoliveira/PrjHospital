package br.edu.senaisp.Hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Hospital.Model.Medico;
import br.edu.senaisp.Hospital.Repository.MedicoRepository;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	MedicoRepository repositorio;

	@GetMapping()
	public ResponseEntity<List<Medico>> listarTudo() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	@PostMapping
	public String Insere(@RequestBody Medico medico) {
		return String.valueOf(repositorio.save(medico));
	}

	@PutMapping("/{id}")
	public void Altera(@RequestBody Medico medico, @PathVariable Integer id) {
		Medico tmp = repositorio.getById(id);

		tmp.setNome(medico.getNome());
		tmp.setCrm(medico.getCrm());

		repositorio.save(tmp);

	}

	@DeleteMapping("/{id}")
	public void deleta(@PathVariable Integer id) {
		repositorio.deleteById(id);
	}

}
