package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.Model.Usuario;

public class UsuarioDAO {

    // 1. Vulnerabilidad de seguridad: SQL Injection
    public List<Usuario> buscarPorNombre(String nombre) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conexion.createStatement();
            String query = "SELECT * FROM usuarios WHERE nombre = '" + nombre + "'"; // SQL Injection
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // 2. Código duplicado
    public List<Usuario> buscarPorEmail(String email) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conexion.createStatement();
            String query = "SELECT * FROM usuarios WHERE email = '" + email + "'"; // Código duplicado y SQL Injection
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}