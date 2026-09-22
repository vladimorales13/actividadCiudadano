package app.servicios.controllers;

import app.servicios.config.DatabaseConfig;
import app.servicios.models.Usuario;
import io.javalin.http.Context;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioController {
    public static void guardarUsuario(Context ctx) {
        // Extrae los datos del atributo 'name' del formulario HTML
        Usuario nuevoUsuario = new Usuario(ctx.formParam("nombre"), ctx.formParam("email"));
        

        try (Connection conn = DatabaseConfig.getConnection()) {
            String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nuevoUsuario.getNombre());
            pstmt.setString(2, nuevoUsuario.getEmail());
            pstmt.executeUpdate();
            
            // Respuesta directa al navegador
            ctx.html("<h1>Registro exitoso</h1><a href='/'>Volver al formulario</a>");
        } catch (Exception e) {
            ctx.status(500).result("Error interno: " + e.getMessage());
        }
    }
}