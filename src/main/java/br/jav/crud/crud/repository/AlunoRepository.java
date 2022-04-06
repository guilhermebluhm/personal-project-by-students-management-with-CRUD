package br.jav.crud.crud.repository;

import br.jav.crud.crud.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
