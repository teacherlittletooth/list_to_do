package br.donini.todolist.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tarefas")
public class Tarefas {
    private Long id_tarefa;
    private String tarefa;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_inicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_fim;

    private int status;

    public Tarefas(){}

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public Long getIdTarefa() {
        return id_tarefa;
    }

    public String getTarefa() {
        return tarefa;
    }

    public LocalDate getDataInicio() {
        return data_inicio;
    }

    public LocalDate getDataFim() {
        return data_fim;
    }

    public int getStatusTarefa() {
        return status;
    }

    public void setIdTarefa(Long id_tarefa) {
        this.id_tarefa = id_tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public void setDataInicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public void setDataFim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public void setStatusTarefa(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Data inicio: "+ this.data_inicio + "\nData fim: " + this.data_fim;
    }

}
