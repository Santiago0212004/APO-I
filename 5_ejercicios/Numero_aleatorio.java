import java.util.Scanner;
import java.lang.Math;

public class Numero_aleatorio{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double aleatorio = Math.floor(Math.random()*101 + 1);
        
        int i = 0;
        double numero = 0;

        while(numero!=aleatorio && i<10){
            System.out.println("Ingresa un numero: ");
            numero = sc.nextDouble();

            System.out.println("");

            if(numero>aleatorio){
                System.out.println("Menos");
            }
            else if(numero<aleatorio){
                System.out.println("Mas");
            }

            i++;

            if(numero==aleatorio){
                System.out.println("Felicidades!");
            }
            
            else if(i==10){
                System.out.println("Lo sentimos, gastaste tus diez intentos.");
            }
            System.out.println("");
        }
    }
}
