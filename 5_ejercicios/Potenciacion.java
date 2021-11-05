import java.util.Scanner;

public class Potenciacion{

    public static double Elevar(double base, int exponente){
        double potencia=1;

        for(int i=0; i<exponente; i++){
            potencia = potencia * base;
        }

        return potencia;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba la base: ");
        double base = sc.nextDouble();

        System.out.println("Escriba el exponente: ");
        int exponente = sc.nextInt();

        System.out.println(Elevar(base,exponente));
    }
}