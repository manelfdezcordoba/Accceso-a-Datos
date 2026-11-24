package com.example.apiempleados.controllers;

import com.example.apiempleados.entities.Empleado;
import com.example.apiempleados.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadosController {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @GetMapping("/empleados")
    public List<Empleado> findAllEmpleados(){
        return empleadoRepository.findAll();
    }
    @GetMapping("/empleados/{id}")
    public Empleado findEmpleado(@PathVariable Long id){
        return empleadoRepository.findById(id).orElse(null);
    }
    @DeleteMapping("/empleados/{id}")
    public void deleteEmpleado(@PathVariable Long id){
        empleadoRepository.deleteById(id);
    }
    @PostMapping("/empleados")
    public Empleado createEmpleado(@RequestBody Empleado empleado){
         return empleadoRepository.save(empleado);

    }
    @PutMapping("/emplado/{id}")
    public Empleado updateEmpleado(@RequestBody Empleado empleado, @PathVariable Long id){
        Optional<Empleado> emp1 = empleadoRepository.findById(id);
        if (emp1.isPresent()){
            emp1.get().setApellidos(empleado.getApellidos());
            emp1.get().setEmail(empleado.getEmail());
            emp1.get().setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoRepository.save(emp1.get());
        return emp1.get();
        }else{
        return null;
        }


    }
}
