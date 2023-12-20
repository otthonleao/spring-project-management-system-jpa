package dev.otthon.projectmanagementsystem.repository;

import dev.otthon.projectmanagementsystem.entities.Funcionario;
import dev.otthon.projectmanagementsystem.entities.Projeto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    /*
     * Durante a busca de entidades que possuam relacionamentos podemos acabar
     * enfrentando um problema bem comum que é chamado de N+1, porém um Spring
     * Data JPA disponibiliza uma annotation @EntityGraph que consegue resolver
     * esse problema de forma simples
     * */
    @EntityGraph(attributePaths = { "cliente", "lider" })
    List<Projeto> findAll();

}
