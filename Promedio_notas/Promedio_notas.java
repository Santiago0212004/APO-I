import java.util.Scanner;

public class Promedio_notas{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingese su nota (-1 para parar): ");
        double nota = sc.nextDouble();
        double promedio, count=0, total=0;
        
        while(nota != -1){
            count+=1;
            total += nota;
            System.out.println("Ingese su nota (-1 para parar): ");
            nota = sc.nextDouble();
        }
        

        promedio = total/count;

        System.out.println("El promedio de notas es "+promedio);
        
    }
}