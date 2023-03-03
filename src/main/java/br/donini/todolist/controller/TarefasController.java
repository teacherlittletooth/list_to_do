package br.donini.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.donini.todolist.model.Tarefas;
import br.donini.todolist.model.TarefasService;

@Controller
public class TarefasController {
    
    @Autowired
    private TarefasService tarefasService;

    @RequestMapping("/")
    public String viewIndex(Model model) {
        List<Tarefas> listaTarefas = tarefasService.listarTarefas();
        model.addAttribute("listaTarefas", listaTarefas); //Atributo enviado para a view

        System.out.println(">>> index <<<");
        return "index.xhtml";
    }

    @RequestMapping("/newtask")
    public String newTask(Model model) {
        Tarefas tarefa = new Tarefas();
        model.addAttribute("novaTarefa", tarefa);

        System.out.println(">>> newtask <<<");
        return "newtask.xhtml";
    }

    @RequestMapping(value="/savetask", method=RequestMethod.POST)
    public String saveTask(@ModelAttribute("novaTarefa") Tarefas task) {
                
        System.out.println(task);
        tarefasService.save(task);

        System.out.println(">>> salvando nova tarefa <<<");
        return "redirect:/";
    }
}
