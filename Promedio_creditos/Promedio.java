import java.util.Scanner;

public class Promedio{

    public static double acc(){

    }

    public static totalCredits acc(){
        
    }

	public static void main (String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el numero de notas: ");
        final int N = sc.nexInt();

		double [] grades = new double[N];
		int[] credits = new int[N];
		

		for (int i =0; i < N; i++){

            System.out.println("Escriba la nota de la materia "+(i+1)+": "));
            grades[i] = sc.nextDouble();

            System.out.println("Escriba el numero de creditos de la materia "+(i+1)+": "));
            credits[i] = sc.nextInt();


		}
		average= acc/totalCredits;
		System.out.println("El promedio del semestre fue: "+ average);
	}
}