package app.servicios;


import app.servicios.controllers.UsuarioController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {
        // Prepara la base de datos antes de iniciar el servidor
        app.servicios.config.DatabaseConfig.initDb();

        Javalin app = Javalin.create(config -> {
            // Sirve los archivos de la carpeta resources/public/ automáticamente
            config.staticFiles.add("/public", Location.CLASSPATH);
        }).start(8080);

        // Rutas POST para manejar los formularios
        app.post("/api/usuarios", UsuarioController::guardarUsuario);
    }
}