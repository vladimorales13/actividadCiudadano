package app.servicios.controllers;

import app.servicios.config.DatabaseConfig;
import app.servicios.models.Ciudadano;
import io.javalin.http.Context;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CiudadanoController {
    public static void guardarCiudadano(Context ctx) {
        // Extrae los datos del atributo 'name' del formulario HTML
        Ciudadano ciudadano = new Ciudadano(
            ctx.formParam("nombre"),
            ctx.formParam("apellidos"),
            ctx.formParam("correo"),
            ctx.formParam("curp"),
            ctx.formParam("telefono"),
            ctx.formParam("direccion")
        );

        try (Connection conn = DatabaseConfig.getConnection()) {
            String sql = "INSERT INTO ciudadanos (nombre, apellidos, correo, curp, telefono, direccion) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ciudadano.getNombre());
            pstmt.setString(2, ciudadano.getApellidos());
            pstmt.setString(3, ciudadano.getCorreo());
            pstmt.setString(4, ciudadano.getCurp());
            pstmt.setString(5, ciudadano.getTelefono());
            pstmt.setString(6, ciudadano.getDireccion());
            pstmt.executeUpdate();
            
            // Respuesta directa al navegador
            ctx.html("<h1>Registro exitoso</h1><a href='/'>Volver al formulario</a>");
        } catch (Exception e) {
            ctx.status(500).result("Error interno: " + e.getMessage());
        }
    }
}