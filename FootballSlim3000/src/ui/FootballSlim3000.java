package ui;
import java.util.Scanner;

public class FootballSlim3000{
    static Scanner sc = new Scanner(System.in);
    static final int EQUIPOS = 4;
    static String equipos[] = {"MCI","PSG","BRU","LPG"}; //Lista de equipos, sirve para que aparezcan al escribir los resultados y en la tabla.
    static int[] ganados = new int[4]; //Almacena los partidos ganados de cada equipo
    static int[] empatados = new int[4]; //Almacena los partidos empatados de cada equipo
    static int[] perdidos = new int[4]; //Almacena los partidos perdidos de cada equipo
    static int[] goles_favor = new int[4]; //Almacena los goles a favor de cada equipo
    static int[] goles_contra = new int[4]; //Almacena los goles en contra de cada equipo
    static int[] diferencia_goles = new int[4]; //Almacena la diferencia de goles de cada equipo
    static int[] puntos = new int[4]; //Almacena los puntos de cada equipo

    //Crea la tabla
    public static void crear_tabla(){
        System.out.println("Grupo A");

        System.out.println("Club          G          E          P          GF          GC          DG          Pts");
        System.out.println("");
        for(int i=0;i<EQUIPOS;i++){
        System.out.println(equipos[i]+"           "+ganados[i]+"          "+empatados[i]+"          "+perdidos[i]+"          "+goles_favor[i]+"          "+goles_contra[i]+"          "+diferencia_goles[i]+"           "+puntos[i]);
        }

    }
    
    //Calcula los puntos
    public static void calcular_puntos(){
        for(int i=0;i<EQUIPOS;i++){
            puntos[i] = (ganados[i]*3) + empatados[i];
        }
    }

    //Almacena en los arreglos los goles a favor, los en contra, halla la diferencia de goles, los partidos ganados, perdidos y empatados.
    public static void estadisticas(int golesi, int golesj, int i, int j){
        diferencia_goles[i] += (golesi - golesj);
        diferencia_goles[j] += (golesj - golesi);

        goles_favor[i] += golesi;
        goles_favor[j] += golesj;

        

        goles_contra[i] += golesj;
        goles_contra[j] += golesi;

        
        

        if(golesi>golesj){
            ganados[i] += 1;
            perdidos[j] += 1;
        }
        else if(golesj>golesi){
            ganados[j] += 1;
            perdidos[i] += 1;
        }
        else if(golesi==golesj){
            empatados[i] += 1;
            empatados[j] += 1;
        }
    }

    //Lee todos los resultados
    public static void leerResultado(){
        int j, golesi=0,golesj=0;

        for(int i=0;i<EQUIPOS;i++){
            j = i + 1;
            while(j<4){
                System.out.println("----------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------");

                System.out.println((equipos[i])+" vs "+" Equipo "+(equipos[j]));

                System.out.println("---------------------Ida----------------------------------------");

                System.out.println("Escriba los goles del "+(equipos[i]));
                golesi = sc.nextInt();

                System.out.println("Escriba los goles del "+(equipos[j]));
                golesj = sc.nextInt();

                estadisticas(golesi,golesj,i,j);

                System.out.println("--------------------Vuelta-----------------------------------------");

                System.out.println("Escriba los goles del "+(equipos[i]));
                golesi = sc.nextInt();

                System.out.println("Escriba los goles del "+(equipos[j]));
                golesj = sc.nextInt();

                estadisticas(golesi,golesj,i,j);


                j++;
            }
        }
    }

    public static void main(String[] args){
        leerResultado();
        calcular_puntos();
        crear_tabla();
    }

}