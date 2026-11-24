package com.example.apiempleados.repositories;

import com.example.apiempleados.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
Empleado findByEmail(String email);

}
