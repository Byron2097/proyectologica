//Semana 6: Modelo de objetos (TEMA 6)
//Esta clase representa una zona del hogar.
//Almacena el nombre de la zona, el nivel de luz,
//la hora registrada y si existe presencia de personas.

public class Zona {

    String nombre;
    int nivelLuz;
    int hora;
    boolean presencia;

        //Constructor que inicializa los datos de una zona.


    public  Zona(String nombre,
                int nivelLuz,
                int hora,
                boolean presencia) {

        this.nombre = nombre;
        this.nivelLuz = nivelLuz;
        this.hora = hora;
        this.presencia = presencia;
    }


    //Muestra la información de la zona.

    public void mostrarInformacion() {

        System.out.println("Zona: " + nombre);
        System.out.println("Hora: " + hora);
        System.out.println("Nivel de luz: " + nivelLuz);
        System.out.println("Presencia: " + (presencia ? "Sí la hay":"No la hay" ));
    }
}
