package dev.otthon.projectmanagementsystem.controller;

import dev.otthon.projectmanagementsystem.entities.Funcionario;
import dev.otthon.projectmanagementsystem.enums.UF;
import dev.otthon.projectmanagementsystem.repository.CargoRepository;
import dev.otthon.projectmanagementsystem.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    /* Faz com que o Spring faça a injeção de dependência de forma automática */
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("funcionario/home");
        try {
            modelAndView.addObject("funcionarios", funcionarioRepository.findAll());
        } catch (Exception e) {
            System.out.println("home");
        }
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("funcionario/detalhes");
        try {
            modelAndView.addObject("funcionario", funcionarioRepository.getOne(id));
        } catch (Exception e) {
            System.out.println("detalhes");
        }
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("funcionario/formulario");
        try {
            modelAndView.addObject("funcionario", new Funcionario());
            modelAndView.addObject("cargos", cargoRepository.findAll());
            modelAndView.addObject("ufs", UF.values());
        } catch (Exception e) {
            System.out.println("cadastrar");
        }
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("funcionario/formulario");
        try {
            modelAndView.addObject("funcionario", funcionarioRepository.getOne(id));
            modelAndView.addObject("cargos", cargoRepository.findAll());
            modelAndView.addObject("ufs", UF.values());
        } catch (Exception e) {
            System.out.println("editar > funcionario/formulario");
        }
        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Funcionario funcionario) {
        try {
            funcionarioRepository.save(funcionario);
        } catch (Exception e) {
            System.out.println("Cadastrar Funcionario");
        }
        return "redirect:/funcionarios";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        try {
            funcionarioRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Excluir");
        }
        return "redirect:/funcionarios";
    }
}
