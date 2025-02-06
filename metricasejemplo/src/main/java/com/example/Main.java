package com.example;

import com.example.Model.Usuario;
import com.example.service.UsuarioService;


public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();

        // Agregar usuario sin validación
        usuarioService.agregarUsuario(new Usuario(1, null, "correo@example.com"));

        // Buscar usuarios con SQL Injection
        System.out.println(usuarioService.buscarUsuarios("nombre", "admin' OR '1'='1"));

        // Validar email incorrectamente
        System.out.println("Email válido: " + usuarioService.validarEmail("correo@"));
    }
}