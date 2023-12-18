package dev.otthon.projectmanagementsystem.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente extends Pessoa {
    /*
    * Usando a herança, a classe Cliente está extendendo a classe Pessoa,
    * puxando os atributos Id, nome, cpf, dataNascimento, endereco
    * */

    @OneToMany(mappedBy = "cliente")
    private List<Projeto> projetos;

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
