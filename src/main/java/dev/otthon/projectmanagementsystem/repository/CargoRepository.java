package dev.otthon.projectmanagementsystem.repository;

import dev.otthon.projectmanagementsystem.entities.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
