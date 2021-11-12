import java.util.Scanner;

public class Divisibles cinco{

    public static double Comprobar divisores(int m, int n){
        int mayor, menor, suma=0;

        if(m>=n){
            mayor = m;
            menor = n;
        }
        else{
            mayor = n;
            menor = m;
        }

        for(int i = menor; i<=mayor; i++){
            if(i%5 == 0){
                suma+= i;
            }
        }
        return suma;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el numero M: ");
        int m = sc.nextInt();

        System.out.println("Escriba el numero N: ");
        int n = sc.nextInt();

        System.out.println("");
        System.out.println(Comprobar_divisores(m,n));
    }
}