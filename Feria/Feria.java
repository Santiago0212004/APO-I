import java.util.Scanner;



public class Feria{

    public static int fecha_salir(long cedula){
        int ultimos_digitos = (int) cedula%100;
        int modulo =  ultimos_digitos%6;
        int dia = 0;

        switch(modulo){
            case 0:
                dia = 25;
                break;
            case 1:
                dia = 26;
                break;
            case 2:
                dia = 27;
                break;
            case 3:
                dia = 28;
                break;
            case 4:
                dia = 29;
                break;
            case 5:
                dia = 30;
                break;
        }

    return dia;

    }

    public static String hora_salir(int anio){
        int edad = 2021 - anio;

        if(edad>0 && edad<18){
            return "9:00am a 12:00pm.";
        }
        else if(edad>=18 && edad<=40){
            return "10:00pm a 3:00am.";
        }
        else if(edad>40 && edad<65){
            return "6:00pm a 12:00am.";
        }
        else{
            return "12:00pm a 6:00pm.";
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba su numero de cedula: ");
        long cedula = sc.nextInt();

        System.out.println("Escriba su anio de nacimiento: ");
        int anio = sc.nextInt();


        System.out.println("Usted puede salir el "+fecha_salir(cedula)+" de diciembre de "+hora_salir(anio));
    }
}