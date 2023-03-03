package br.donini.todolist.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefasService {
    
    @Autowired
    private TarefasRepository tarefasRepo;

    public List<Tarefas> listarTarefas() {
        return tarefasRepo.findAll();
    }

    public Tarefas listarUmaTarefa(Long id) {
        return tarefasRepo.findById(id).get();
    }

    public void save(Tarefas task) {
        tarefasRepo.save(task);
    }

}
