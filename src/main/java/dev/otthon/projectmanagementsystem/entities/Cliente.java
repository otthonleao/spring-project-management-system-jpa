package dev.otthon.projectmanagementsystem.entities;

import jakarta.persistence.*;

@Entity
public class Cliente extends Pessoa {
    /*
    * Usando a herança, a classe Cliente está extendendo a classe Pessoa,
    * puxando os atributos Id, nome, cpf, dataNascimento, endereco
    * */
}
