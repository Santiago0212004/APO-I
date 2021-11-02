import java.util.Scanner;

public class Cero{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double suma=0;
        int contador = 0;

        System.out.println("Escriba los numeros a sumar (0 para finalizar): ");
        double numero = sc.nextDouble();


        while(numero!=0){
            suma = suma + numero;
            numero = sc.nextDouble();
            contador = contador + 1;
        }
        
        System.out.println("");

        System.out.println("La suma de los numeros es: "+suma+" y el promedio es: "+suma/contador);
    }
}