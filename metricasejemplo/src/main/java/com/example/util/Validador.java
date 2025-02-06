package com.example.util;

public class Validador {

    // 1. Validación de email incorrecta
    public static boolean esEmailValido(String email) {
        return email.contains("@"); // Validación muy básica
    }
}
