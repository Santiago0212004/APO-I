import java.util.Scanner; //Importa el scanner para leer datos

public class Program{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //Se declara el nombre del scanner, en este caso "sc"

        System.out.println("Digite el numero de horas totales: ");
        int horas_totales = sc.nextInt(); //Se le pide al usuario que digite la cantidad de horas a convertir

        int semanas = horas_totales / 168; //Se calcula la cantidad de semanas ya que una semana contiene 168 horas, al ser de tipo "int" no conserva el residuo
        int semanas_residuo = horas_totales % 168; //Se calcula el residuo, el cual es equivalente a las horas que sobraban y no alcanzaban para conformar otra semana

        int dias = semanas_residuo / 24; //Las horas sobrantes, las dividimos entre las 24 horas que contiene un dia, esto para calcular el numero de dias
        int dias_residuo = semanas_residuo % 24; //Nuevamente sobran unas horas que son insuficientes para conformar un dia, por lo tanto calculamos su valor

        int horas_restantes = dias_residuo; //Este valor lo asignamos a las "horas restantes" que son las que sobran

        System.out.println("El numero de semanas es: "+semanas+", el de dias es: "+dias+" y el de horas restantes es: "+ horas_restantes);

    }
}