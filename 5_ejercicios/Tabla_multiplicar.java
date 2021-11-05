import java.util.Scanner;

public class Tabla_multiplicar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el numero del cual desea imprimir su tabla de multiplicar: ");
        int numero = sc.nextInt();

        for(int i=1;i<=10;i++){
            System.out.println(numero+" * "+i+" = "+numero*i);
        }
    }
}
