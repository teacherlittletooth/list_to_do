package br.donini.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

        System.out.println(">>> Página inicial <<<");
        return "index";
    }

    @RequestMapping("/newtask")
    public String newTask(Model model) {
        Tarefas tarefa = new Tarefas();
        model.addAttribute("novaTarefa", tarefa);

        System.out.println(">>> Nova tarefa <<<");
        return "newtask";
    }

    @RequestMapping(value="/savetask", method=RequestMethod.POST)
    public String saveTask(@ModelAttribute("novaTarefa") Tarefas task) {
        tarefasService.save(task);

        System.out.println(">>> Salvando <<<");
        return "redirect:/";
    }

    @RequestMapping("/edittask/{id}")
    public ModelAndView editTask(@PathVariable(name="id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edittask");
        
        Tarefas task = tarefasService.getOne(id);
        
        modelAndView.addObject("task", task);

        System.out.println(modelAndView);
        

        System.out.println(">>> Editando tarefa <<<");
        return modelAndView;
    }

    @RequestMapping("/deletetask/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
                
        tarefasService.delete(id);

        System.out.println(">>> Tarefa nº "+ id +" excluída <<<");
        return "redirect:/";
    }
}
