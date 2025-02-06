package com.example.service;

import java.util.List;

import com.example.DAO.UsuarioDAO;
import com.example.Model.Usuario;
import com.example.util.Validador;

public class UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    // 1. Bug potencial: No se valida si el usuario es nulo
    public void agregarUsuario(Usuario usuario) {
        if (usuario.getNombre() != null) {
            // Lógica para agregar usuario (simulada)
            System.out.println("Usuario agregado: " + usuario.getNombre());
        }
    }

    // 2. Método largo y complejo
    public List<Usuario> buscarUsuarios(String criterio, String valor) {
        if (criterio.equals("nombre")) {
            return usuarioDAO.buscarPorNombre(valor);
        } else if (criterio.equals("email")) {
            return usuarioDAO.buscarPorEmail(valor);
        } else {
            throw new IllegalArgumentException("Criterio no válido");
        }
    }

    // 3. Falta de validación de entrada
    public boolean validarEmail(String email) {
        return Validador.esEmailValido(email); // Delegar a una clase de utilidad
    }
}
