package com.example.demo.controller;


import com.example.demo.entity.Jueces;
import com.example.demo.repository.JuezRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JuezController {

    @Autowired
    private JuezRepository juezRep;


    @GetMapping("/jueces")
    public List<Jueces> lista(){
        return juezRep.findAll();
    }

    @GetMapping("/jueces/{id}")
    public ResponseEntity<Jueces> buscarId(@PathVariable Long id){
        return juezRep.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/jueces")
    public ResponseEntity<Jueces> crear(@RequestBody Jueces juez) {
        juez.setId(null);
        Jueces guardado = juezRep.save(juez);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);

    }
    @PutMapping("jueces/{id}")
    public ResponseEntity<Jueces> modificar(@PathVariable Long id, @RequestBody Jueces juez){
        Optional<Jueces> opt= juezRep.findById(id);
        if (opt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Jueces jueces = opt.get();
        jueces.setNombre(juez.getNombre());
        jueces.setFecha(juez.getFecha());
        jueces.setAbogado(juez.getAbogado());
        return ResponseEntity.ok(juezRep.save(jueces));
    }
    @DeleteMapping("/jueces/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id){
        Optional<Jueces> opt = juezRep.findById(id);
        if (opt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Jueces jueces= opt.get();
       juezRep.delete(jueces);
       return ResponseEntity.noContent().build();

    }


}
