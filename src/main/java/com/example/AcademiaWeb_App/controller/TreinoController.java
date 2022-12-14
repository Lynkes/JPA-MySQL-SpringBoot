package com.example.AcademiaWeb_App.controller;

import com.example.AcademiaWeb_App.entity.Treino;
import com.example.AcademiaWeb_App.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller//Isso significa que esta classe é uma controller
@RequestMapping(path = "/Treino")
public class TreinoController {

    @Autowired//Marcação do atributo que acessa o CRUD de Treino
    private TreinoRepository treinoRepository;

    @GetMapping("/index")
    public String cadastrarTreino(){

        return "Exemplo";
    }
    @GetMapping("/cadastrar")
    public String cadastrarTreino(Model model){
        //madar um objeto do tipo Treino para a pagina cadastro
        model.addAttribute("Treino", new Treino());
        //redirecionando para pagina cadastrarTreino.html
        return "cadastrarTreino";
    }
    @GetMapping("/listar")
    public String listarProdutos(@ModelAttribute Treino Treino, Model model) {
        List<Treino> listaTreino = (List<Treino>) treinoRepository.findAll();
        model.addAttribute("Treinos", listaTreino);
        return "listarTreinos";
    }

    @PostMapping ("/save")
    public String salvarTreino(@ModelAttribute Treino Treino, Model model){
        //Salva no banco o objeto do tipo Treino com as informações da pagina cadastro
        treinoRepository.save(Treino);
        //Cria uma lista atualizada das Treinos cadastradas
        List<Treino> listaTreino = (List<Treino>) treinoRepository.findAll();
        model.addAttribute("Treinos", listaTreino);
        return "listarTreinos";
    }
    @GetMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String excluirTreino(Model model, @PathVariable Long id) {
        treinoRepository.deleteById(Math.toIntExact(id));
        List<Treino> listaTreino = (List<Treino>) treinoRepository.findAll();
        model.addAttribute("Treinos", listaTreino);
        return "listarTreinos";
    }
    @GetMapping("/alterar/{id}")
    public String altTreino(@PathVariable Long id, Model model) {
        Treino p = treinoRepository.findById(Math.toIntExact(id)).get();
        model.addAttribute("Treino", p);
        return "alterarTreino";
    }
    @PostMapping("/alterar")
    public String alterarProduto(@ModelAttribute Treino novoTreino, Model model) {
        treinoRepository.save(novoTreino);
        List<Treino> listaTreino = (List<Treino>) treinoRepository.findAll();
        model.addAttribute("Treinos", listaTreino);
        return "listarTreinos";
    }
}
