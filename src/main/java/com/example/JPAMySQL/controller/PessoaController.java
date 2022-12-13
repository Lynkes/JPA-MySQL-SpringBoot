package com.example.JPAMySQL.controller;

import com.example.JPAMySQL.model.Pessoa;
import com.example.JPAMySQL.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller//Isso significa que esta classe é uma controller
@RequestMapping(path = "/site")
public class PessoaController {

    @Autowired//Marcação do atributo que acessa o CRUD de pessoa
    private PessoaRepository pessoaRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/cadastrar")
    public String cadastrarPessoa(Model model){
        //madar um objeto do tipo Pessoa para a pagina cadastro
        model.addAttribute("pessoa", new Pessoa());
        //redirecionando para pagina cadastrarPessoa.html
        return "cadastrarPessoa";
    }
    @GetMapping("/listar")
    public String listarProdutos(@ModelAttribute Pessoa pessoa, Model model) {
        List<Pessoa> listaPessoa = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", listaPessoa);
        return "listarPessoas";
    }

    @PostMapping ("/save")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa, Model model){
        //Salva no banco o objeto do tipo Pessoa com as informações da pagina cadastro
        pessoaRepository.save(pessoa);
        //Cria uma lista atualizada das pessoas cadastradas
        List<Pessoa> listaPessoa = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", listaPessoa);
        return "listarPessoas";
    }
    @GetMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String excluirPessoa(Model model, @PathVariable Long id) {
        pessoaRepository.deleteById(Math.toIntExact(id));
        List<Pessoa> listaPessoa = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", listaPessoa);
        return "listarPessoas";
    }
    @GetMapping("/alterar/{id}")
    public String altPessoa(@PathVariable Long id, Model model) {
        Pessoa p = pessoaRepository.findById(Math.toIntExact(id)).get();
        model.addAttribute("pessoa", p);
        return "alterarPessoa";
    }
    @PostMapping("/alterar")
    public String alterarProduto(@ModelAttribute Pessoa novaPessoa, Model model) {
        pessoaRepository.save(novaPessoa);
        List<Pessoa> listaPessoa = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", listaPessoa);
        return "listarPessoas";
    }
}
