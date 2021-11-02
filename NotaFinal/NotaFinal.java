import java.util.Scanner;

public class NotaFinal{
	
	public static double sacarNota(double parcial1, double parcial2, double tareas){
		parcial1 = parcial1 * 0.4;
		parcial2 = parcial2 * 0.4;
		tareas = tareas * 0.2;
		
		return parcial1 + parcial2 + tareas;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite la nota de su primer parcial: ");
		double parcial1 = sc.nextDouble();
		
		System.out.println("Digite la nota de su segundo parcial: ");
		double parcial2 = sc.nextDouble();
		
		System.out.println("Digite la nota de sus tareas: ");
		double tareas = sc.nextDouble();
		
		System.out.println("Su nota final es: " + sacarNota(parcial1,parcial2,tareas));
	}
}