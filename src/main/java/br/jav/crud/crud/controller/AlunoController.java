package br.jav.crud.crud.controller;

import br.jav.crud.crud.model.Aluno;
import br.jav.crud.crud.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository repo;

    @GetMapping("/")
    public String paginaInicial(Model model){
        model.addAttribute("alunos",repo.findAll());
        return "index";
    }

    @GetMapping("/salvarNovoAluno")
    public String salvarNovoAluno(Model model){
        Aluno aluno = new Aluno();
        model.addAttribute("alunos",aluno);
        return "salvar_aluno";
    }

    @PostMapping("/gravarAluno")
    public String gravarAluno(@ModelAttribute("alunos") Aluno alunos){
        repo.save(alunos);
        return "redirect:/";
    }

    @GetMapping("/editarAluno/{id}")
    public String editarAluno(@PathVariable("id") int id, Model model){
        Optional<Aluno> temp = repo.findById(id);
        Aluno aluno = temp.get();
        model.addAttribute("alunos",aluno);
        return "editar_aluno";
    }

    @GetMapping("/removerAluno/{id}")
    public String removerAluno(@PathVariable("id") int id){
        repo.deleteById(id);
        return "redirect:/";
    }

}
