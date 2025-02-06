package com.example.service;

import org.junit.jupiter.api.Test;

import com.example.Model.Usuario;

class UsuarioServiceTest {

    @Test
    void testAgregarUsuario() {
        UsuarioService service = new UsuarioService();
        service.agregarUsuario(new Usuario(1, "Juan", "juan@example.com"));
        // Falta aserción para verificar el comportamiento
    }
}