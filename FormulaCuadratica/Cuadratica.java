import java.lang.Math;
import java.util.Scanner;

public class Cuadratica{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		double a, b, c, potencia, x1, x2;
		
		System.out.println("Digite el coeficiente de la variable de segundo grado: ");
		a = sc.nextDouble();
		
		System.out.println("Digite el coeficiente de la variable de primer grado: ");
		b = sc.nextDouble();
		
		System.out.println("Digite el valor de la constante: ");
		c = sc.nextDouble();
		
		potencia = Math.pow(b,2) - (4*a*c);
		
		x1 = (-b + Math.sqrt(potencia))/ (2*a);
		x2 = (-b - Math.sqrt(potencia))/ (2*a);
		
		System.out.println("Los ceros de la ecuacion son "+ x1 + " y "+ x2);
	}
}