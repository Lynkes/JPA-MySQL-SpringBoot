package com.example.AcademiaWeb_App.controller;
import com.example.AcademiaWeb_App.entity.Equipamento;
import com.example.AcademiaWeb_App.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller//Isso significa que esta classe é uma controller
@RequestMapping(path = "/equipamento")
public class EquipamentoController {

    @Autowired//Marcação do atributo que acessa o CRUD de pessoa
    private EquipamentoRepository equipamentoRepository;

    @GetMapping("/")
    public String cadastrarEquipamento(){

        return "listarEquipamentos";
    }
    @GetMapping("/cadastrar")
    public String cadastrarEquipamento(Model model){
        //madar um objeto do tipo Pessoa para a pagina cadastro
        model.addAttribute("equipamento", new Equipamento());
        //redirecionando para pagina cadastrarEquipamento.html
        return "cadastrarEquipamento";
    }
    @GetMapping("/listar")
    public String listarEquipamento(@ModelAttribute Equipamento equipamento, Model model) {
        List<Equipamento> listaEquipamento = (List<Equipamento>) equipamentoRepository.findAll();
        model.addAttribute("Equipamentos", listaEquipamento);
        return "listarEquipamento";
    }

    @PostMapping ("/save")
    public String salvarEquipamento(@ModelAttribute Equipamento equipamento, Model model){
        //Salva no banco o objeto do tipo do equipamento com as informações da pagina cadastro
        equipamentoRepository.save(equipamento);
        //Cria uma lista atualizada das pessoas cadastradas
        List<Equipamento> listaEquipamento = (List<Equipamento>) equipamentoRepository.findAll();
        model.addAttribute("Equipamento", listaEquipamento);
        return "listarEquipamento";
    }
    @GetMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String excluirEquipamento(Model model, @PathVariable Long id) {
        equipamentoRepository.deleteById(Math.toIntExact(id));
        List<Equipamento> listaEquipamento = (List<Equipamento>) equipamentoRepository.findAll();
        model.addAttribute("equipamento", listaEquipamento);
        return "listarEquipamento";
    }
    @GetMapping("/alterar/{id}")
    public String altEquipamento(@PathVariable Long id, Model model) {
        Equipamento e = equipamentoRepository.findById(Math.toIntExact(id)).get();
        model.addAttribute("equipamento");
        return "alterarEquipamento";
    }
    @PostMapping("/alterar")
    public String alterarEquipamento(@ModelAttribute Equipamento novaPessoa, Model model) {
        equipamentoRepository.save(novaPessoa);
        List<Equipamento> listaEquipamento = (List<Equipamento>) equipamentoRepository.findAll();
        model.addAttribute("equipamento", listaEquipamento);
        return "listarEquipamento";
    }
}
