package dev.otthon.projectmanagementsystem.repository;

import dev.otthon.projectmanagementsystem.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
