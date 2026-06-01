//Semana 6: Modelo de objetos (TEMA 6)
//Esta clase simula un sensor de iluminación.
//Su función es calcular un nivel de luz recomendado
//según la hora del día.

public class Sensor {

    public static int calcularNivelLuz(int hora) {

        if (hora >= 6 && hora < 18) {
            return 80;
        }
        else if (hora >= 18 && hora < 22) {
            return 50;
        }
        else {
            return 10;
        }
    }
}
