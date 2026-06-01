// Nombres: Ericka Yissel Chajón Chocojay 
//DITH MELANI MARIA IXPATAC ARÉVALO 
//LINDA YAMILETH MENDEZ LÓPEZ 
//BYRON ESAU NORIEGA MERIDA 
//JUDITH MELANI MARIA IXPATAC ARÉVALO 
//Fecha de inicio: 24 de abril 2026 
//Descripción:En este programa crearemos opciones domóticos que podrán 
//yudarnos a controlar cada 
//zona del hogar mediante un menú interactivo donde se especificarán instrucciones 
import java.util.Scanner; 
public class prueba{ 
public static void main(String[] args){ 
Scanner teclado = new Scanner(System.in); 
//Semana 1: Declaro las variables (Panel de estado TEMA1) 
//Como escogimos el escenario A entonces las variables serán las siguientes. 
int ciclosMenu = 0; // contador de cuantas veces se utilizará el menú  
 
        //Esto nos ayudará a elegir la cantidad de zonas que queremos ingresar 
        System.out.println("Ingrese la cantidad de zonas: "); 
        int totalZonas= teclado.nextInt(); 
 
        //Estos son los arrays para que me pueda permitir ingresar mis datos en cada zona 
        String [] zonas  = new String[totalZonas]; 
        int[] niveles = new int [totalZonas]; 
        boolean []presencias = new boolean [totalZonas]; 
        int[] horas = new int [totalZonas]; 
 
        //Semana 3: Sistema de monitoreo continuo (Menú TEMA3) 
 
        int opcion = 0; 
        do{ 
            ciclosMenu++; 
            System.out.println(); 
             System.out.println("-----MENÚ-----"); 
            System.out.println(); 
            System.out.println("1. Ingresar lecturas"); 
            System.out.println("2. Mostrar panel"); 
            System.out.println("3. Mostrar estadísticas"); 
            System.out.println("4. Demostrar objetos"); 
            System.out.println("0. Apagar Sistema"); 
            System.out.println(); 
            //Esto sirve en caso de que ingresen algún número fuera del rango 
            while(!teclado.hasNextInt()) {  
                    System.out.println ("ERROR : Debe ingresar un número 
válido"); 
                    teclado.next(); 
                    System.out.print("Seleccione otra opción: "); 
            } 
         opcion = teclado.nextInt(); //para que pueda leer la accion 
 
        //De acuerdo a una opción seleccionada se va a presentar lo siguiente 
         switch (opcion){ 
            case 1:  
            ingresarLecturas(teclado,zonas,niveles,horas,presencias); 
            break; 
 
            case 2:  
            mostrarPanel(zonas,niveles,horas,presencias); 
            break; 
 
            case 3: 
            mostrarEstadisticas(niveles,zonas); 
                break; 
 
            case 4: 
 
    for (int i = 0; i < zonas.length; i++) { 
 
        Zona zonaObjeto = new Zona( 
                zonas[i], 
                niveles[i], 
                horas[i], 
                presencias[i]  
        ); 
 
        System.out.println(); 
        System.out.println("----- DEMOSTRACIÓN DE OBJETOS -----"); 
 
        zonaObjeto.mostrarInformacion(); 
 
     
    } 
 
    break; 
         } 
        }while(opcion != 0);{  
        System.out.println(); 
        System.out.println("El total de ciclos ejecutados fueron: " + 
ciclosMenu); 
        System.out.println("Sistema detenido, hasta pronto"); 
 
        teclado.close(); 
 
        }} 
 
        //1. Muestra el estado de todas las zonas 
        //Acá nos recopila la información ingresada de las zonas 
        public static void mostrarPanel(String [] zonas, int[] niveles, int[] 
horas,boolean [] presencias) { 
                System.out.println(); 
                System.out.println("-----PANEL DE ESTADO ----"); 
                System.out.printf( "%-15s | %-6s |%-6s | %-20s%n", 
                " Zona","Hora", "Nivel", "Recomendación"); 
                 
               System.out.println("------------------------------------------------------------"); 
                for( int i = 0; i < zonas.length; i++) { 
                    String recomendacion = recomendarIluminacion (horas[i], 
presencias[i]); 
                    System.out.printf("%-15s  | %-6d  | %-6d | %-20s%n", 
                    zonas [i], horas [i], niveles [i], recomendacion); 
                     
                    } 
                } 
            //2. Para recomendar la iluminación 
            //Dependiendo el rango que se establezca va a cumplir las siguientes condiciones 
             public static String recomendarIluminacion ( int hora, boolean 
presencia){ 
                        if(!presencia) { 
                            return "Apagar"; 
                        } 
                        if (hora >= 19 || hora < 7) { 
                        return "Encender"; 
                    } 
                    return "Aprovecha la luz natural"; 
                } 
                
        //3. Lee datos del usuario para cada zona 
        //Esto nos permitirá que el usuario pueda ingresar los datos correspondientes 
        public static void ingresarLecturas ( Scanner sc, String [] zonas, 
int [] niveles, int[] horas, boolean [] presencias) 
            { 
                for ( int i = 0; i < zonas.length; i++){ 
                    sc.nextLine(); 
 
                    System.out.println("-----ESTIMADO USUARIO INGRESE LOS DATOS----"); 
                    System.out.print(" Nombre de la zona" + (i+1) + " : "); 
                    zonas [i] = sc.nextLine(); 
 
                    System.out.print("La hora (0-23): "); 
                    horas [i] = sc.nextInt(); 
 
                    System.out.print("Nivel de luz (0-100): "); 
                    niveles[i] = sc.nextInt(); 
 
                    System.out.print("¿Hay presencia? (Si/No): "); 
                    presencias[i] = sc.next().equalsIgnoreCase("Si"); 
                } 
            } 
        //4. Métodos de calculos 
        //Acá es para mostrar la estadística, sobre el promedio y que indice (el puesto de la zona) 
        //que se encuentra con más y menos nivel 
        public static void mostrarEstadisticas( int [] niveles, String 
[]zonas){ 
            double[] nivelesDouble = new double [niveles.length]; 
            for (int i = 0; i < niveles.length; i++) { 
                nivelesDouble[i] = niveles [i]; 
            } 
     
        double promedio = calcularPromedio (nivelesDouble); 
        int idxMax = encontrarIndiceMax (nivelesDouble); 
        int idxMin = encontrarIndiceMin (nivelesDouble); 
 
        System.out.println("-----------------ESTADÍSTICAS------------"); 
        System.out.println("El promedio de luz es: " + promedio); 
        System.out.println("La zona con más luz es: " + zonas [idxMax]); 
        System.out.println("La zona con menos luz es: " + zonas[idxMin]);} 
         
        //5. Aquí retorna el promedio   
        public static double calcularPromedio ( double[]valores){ 
            double suma = 0; 
            for ( double v : valores) { 
                suma += v; 
            } 
            return suma / valores.length; 
        } 
        //Los métodos para encontrar el índice mayor 
        public static int encontrarIndiceMax(double[] valores){ 
            int idxMax = 0; 
            for ( int i = 1; i < valores.length; i++) { 
                if(valores[i] > valores[idxMax] ) { 
                    idxMax = i; 
                } 
            } 
            return idxMax; 
        } 
        //Los métodos para encontrar el índice menor 
        public static int encontrarIndiceMin(double[] valores){ 
            int idxMin =0; 
            for( int i = 1; i < valores.length; i++){ 
                if ( valores[i] < valores[idxMin]){ 
                    idxMin = i; 
                } 
            } 
            return idxMin; 
        } 
         
        //6. Retorna indice del valor minímo  
        public static int leerOpcionmenu(Scanner sc, int min,int max) { 
            int opcion; 
            do { 
                System.out.print("Seleccione una opción: "); 
                opcion = sc.nextInt(); 
                if (opcion < min || opcion > max) { 
                    System.out.println("Opcion inválida. Intente de nuevo"); 
                } 
 
            } while (opcion < min || opcion > max); 
            return opcion; 
        } 
 
        //7. Calcula nivel de luz según hora 0-100 
        public static int calcularNivelLuz(int hora) { 
            if (hora >= 6 && hora < 18) { 
                return 80;  
            } else if (hora >= 18 && hora < 22) { 
                return 50; 
            } else { 
                return 10; 
            } 
        } 
        //8. Recomienda acción según hora y presencia 
        public static void aplicarReglaluz (String [] zonas, int[] niveles, 
boolean [] presencias){ 
            for (int i = 0; i < zonas.length; i++){ 
                niveles [i] = calcularNivelLuz(i); 
                String accion = recomendarIluminacion(i, presencias[i]); 
                System.out.println(zonas[i] + ": " + accion); 
               }   } 
        } 
         
 
// objetos 
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
// objetos  
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
