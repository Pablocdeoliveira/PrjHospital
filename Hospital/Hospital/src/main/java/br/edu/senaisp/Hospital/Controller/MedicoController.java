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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.edu.senaisp.Hospital.Model.Medico;
import br.edu.senaisp.Hospital.Repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	MedicoRepository repositorio;

	 @GetMapping()
	 public ResponseEntity<List<Medico>> listarTudo() {
		return ResponseEntity.ok(repositorio.findAll());
	 }

	// @GetMapping("/{id}")
		//public ResponseEntity<Medico> BuscaPorId(@PathVariable int id) {
		//	Optional<Medico> medico = repository.findById(id);
	 
		//	if (medico.isEmpty())
		//		return ResponseEntity.notFound().build();
		//	else
		//		return ResponseEntity.ok(medico.get());
		//}
	
	
	//@PostMapping
	//public String Insere(@RequestBody Medico medico) {
	//	return String.valueOf(repositorio.save(medico));
	//}

	
	@PostMapping
	public ResponseEntity<Medico>gravar(
			@RequestBody @Valid Medico medico){
		return ResponseEntity.ok(repositorio.save(medico));
	}
	
	
	//@PutMapping("/{id}")
	//public void Altera(@RequestBody Medico medico, @PathVariable Integer id) {
		//Medico tmp = repositorio.getById(id);

		//tmp.setNome(medico.getNome());
		//tmp.setCrm(medico.getCrm());

		//repositorio.save(tmp);

	//}

	@PutMapping("/{id}")
	public ResponseEntity<Medico> Altera(@RequestBody @Valid Medico medico, @PathVariable int id) {
 
		try {
			Medico tmp = repositorio.findById(id).orElseThrow();
			tmp.setNome(medico.getNome());
			tmp.setCrm(medico.getCrm());
			repositorio.save(tmp);
			return ResponseEntity.ok(tmp);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Medico> excluir(@PathVariable int id) {
 
		try {
			Medico medico = repositorio.findById(id).orElseThrow();
			repositorio.deleteById(id);
			return ResponseEntity.ok(medico);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	

	//@DeleteMapping("/{id}")
	//public void deleta(@PathVariable Integer id) {
	//	repositorio.deleteById(id);
	//}
	
	
	

}
