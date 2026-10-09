package vallegrande.edu.pe.miperfil.model;

public class Perfil {
    private String nombre;
    private String carrera;
    private String semestre;
    private String juegoFavorito;

    public Perfil(String nombre, String carrera, String semestre, String juegoFavorito){
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.juegoFavorito = juegoFavorito;
    }

    public String getNombre(){ return nombre; }
    public String getCarrera(){ return carrera; }
    public String getSemestre(){ return semestre; }
    public String getJuegoFavorito(){ return juegoFavorito; }

    public String obtenerPresentacion(){
        return "Hola, soy " + nombre +
                "\nCarrera: " + carrera +
                "\nSemestre: " + semestre +
                "\nJuego Favorito: " + juegoFavorito;
    }
}