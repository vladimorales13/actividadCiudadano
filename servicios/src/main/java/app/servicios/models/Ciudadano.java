package app.servicios.models;

public class Ciudadano {
    
    int id;
    String nombre;
    String apellidos;
    String correo;
    String curp;
    String telefono;
    String direccion;

    public Ciudadano(){

    }

    public Ciudadano(String nombre, String apellidos, String correo, String curp, String telefono, String direccion){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.correo=correo;
        this.curp=curp;
        this.telefono=telefono;
        this.direccion=direccion;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getCurp(){
        return curp;
    }

    public void setCurp(String curp){
        this.curp = curp;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

}
