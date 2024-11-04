package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Usuario;
import com.example.demo.Services.UsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

   private final UsuarioService usuarioService;

   @Autowired
   public UsuarioController(UsuarioService usuarioService) {
       this.usuarioService = usuarioService;
   }

   @PostMapping
   public Usuario criarUsuario(@RequestBody Usuario usuario) {
       return usuarioService.salvarUsuario(usuario);
   }

   @GetMapping
   public List<Usuario> buscarTodos() {
       return usuarioService.buscarTodosUsuarios();
   }

   @GetMapping("/{id}")
   public Usuario buscarPorId(@PathVariable Long id) {
       return usuarioService.buscarUsuarioPorId(id);
   }

   @DeleteMapping("/{id}")
   public void deletarUsuario(@PathVariable Long id) {
       usuarioService.excluirUsuario(id);
   }

   @PutMapping
   public ResponseEntity<Usuario> UsuarioAtualizado(@PathVariable Long id, @RequestBody Usuario usuario) {
       Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
       if (usuarioAtualizado != null) {
           return ResponseEntity.ok(usuarioAtualizado);
       } else {
           return null;
       }
   }
}