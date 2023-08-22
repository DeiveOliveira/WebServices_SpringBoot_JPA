package com.example.curso.resources;

import com.example.curso.entities.User;
import com.example.curso.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices services;

    //Retorna todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = services.findAll();
         return ResponseEntity.ok().body(list);
    }
    // Retorna o usuário cpnfprme o ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByid(@PathVariable Long id){
        User obj = services.finById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Inserir no banco
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = services.insert(obj);
        // para retornar o código certo 201
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //deletando no banco
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        services.delete(id);
        //Código para resposta vázia
        return ResponseEntity.noContent().build();
    }

    //Atualizar no banco
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = services.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
