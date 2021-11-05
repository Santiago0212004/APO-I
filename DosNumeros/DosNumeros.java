import java.util.Scanner;
import java.lang.Math;

public class DosNumeros{
	public static double menor(double n1, double n2){
		return Math.min(n1,n2);
	}

	public static double raiz(double n1){
		return Math.sqrt(n1);
	}

	public static double hipotenusa(double n1, double n2){
		return Math.sqrt(Math.pow(n1,2)+Math.pow(n2,2));
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite dos números: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();

		System.out.println("");

		System.out.println("El menor de los dos numeros es: "+menor(a,b));

		System.out.println("");

		System.out.println("La raiz cuadrada de "+a+" es "+raiz(a));
		System.out.println("La raiz cuadrada de "+b+" es "+raiz(b));

		System.out.println("");

		System.out.println("La hipotenusa para los catetos "+a+" y "+b+" es: "+hipotenusa(a,b));
	}
}