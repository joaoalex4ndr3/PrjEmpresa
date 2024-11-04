package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
   
   private final UsuarioRepository usuarioRepository;
   
   
   @Autowired
   public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
   }
   
   public Usuario salvarUsuario(Usuario usuario) {
       return usuarioRepository.save(usuario);
       
   }
   
   public Usuario buscarUsuarioPorId(Long id) {
       return usuarioRepository.findById(id).orElse(null);
   }
   
   public List<Usuario> buscarTodosUsuarios(){
       return usuarioRepository.findAll();
   }
   
   public void excluirUsuario(Long id) {
       usuarioRepository.deleteById(id);
   }
   public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
       Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
       if(usuarioExistente.isPresent()) {
           Usuario usuario = usuarioExistente.get();
           usuario.setNome(usuarioAtualizado.getNome());
           usuario.setEmail(usuarioAtualizado.getEmail());
           usuario.setSenha(usuarioAtualizado.getSenha());
           return usuarioRepository.save(usuario);
       }
       else
       {
           return null;
       }
   }
}