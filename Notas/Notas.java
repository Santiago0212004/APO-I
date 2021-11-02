import java.util.Scanner;

public class Notas{

    public static String calificacion(int nota){
        switch(nota){
            case 1:
                return "Hay que trabajar mas.";
            case 2:
                return "Un poco de esfuerzo y lo logras.";
            case 3:
                return "Bien pero se pude mejorar.";
            case 4:
                return "Muy bien, ya vas por el 5.";
            case 5:
                return "Crack!";
            default:
                return "Nota no valida.";
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digita tu nota: ");
        int nota = sc.nextInt();

        System.out.println("");

        System.out.println(calificacion(nota));
    }
}