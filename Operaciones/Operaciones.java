import java.util.Scanner;

public class Operaciones{

    public static double suma(double n1, double n2){
        return n1+n2;
    }

    public static double resta(double n1, double n2){
        return n1-n2;
    }

    public static double multiplicacion(double n1, double n2){
        return n1*n2;
    }

    public static double division(double n1, double n2){
        return n1/n2;
    }

    public static double modulo(double n1, double n2){
        return n1%n2;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite dos numeros: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.println("");

        System.out.println("La suma de "+a+" y "+b+" es: "+suma(a,b));
        System.out.println("La resta de "+a+" y "+b+" es: "+resta(a,b));
        System.out.println("La multiplicacion de "+a+" y "+b+" es: "+multiplicacion(a,b));
        System.out.println("La division de "+a+" entre "+b+" es: "+division(a,b));
        System.out.println("El residuo al dividir "+a+" entre "+b+" es: "+modulo(a,b));

    }
}