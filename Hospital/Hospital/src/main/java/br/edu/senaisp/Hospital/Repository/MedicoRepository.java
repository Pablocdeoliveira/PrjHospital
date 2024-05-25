package br.edu.senaisp.Hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Hospital.Model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	


}
