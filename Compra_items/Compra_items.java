/*Cree un programa para un supermercado que le solicite al usuario la cantidad de items a comprar, 
posteriormente pida el valor de cada uno de esos elementos y finalmente arroje en pantalla el valor total a pagar. */
import java.util.Scanner;
public class Compra_items{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba la cantidad a comprar:");
		int cant = sc.nextInt();
		

        double total = 0;

		for(int i=1;i<=cant;i++){

			System.out.println("Escriba el valor del item "+i+":");
            double valor_item = sc.nextDouble();
            
            total+=valor_item;

			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("El valor total de la compra es: "+total);
		
	}
}