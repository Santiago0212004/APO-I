import java.util.Scanner;

public class Condicionales{
    public static String mayor(int a, int b){
        return (a>b)?"Si":"No";
    }
    public static String mayor_igual(int a, int b){
        return (a>=b)?"Si":"No";
    }
    public static String menor(int a, int b){
        return (a<b)?"Si":"No";
    }
    public static String menor_igual(int a, int b){
        return (a<=b)?"Si":"No";
    }
    public static String igual(int a, int b){
        return (a==b)?"Si":"No";
    }
    public static String diferente(int a, int b){
        return (a!=b)?"Si":"No";
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

		System.out.println("Digite dos numeros: ");
		int a = sc.nextInt();
		int b = sc.nextInt();

        System.out.println(a+" mayor que "+b+"?"+" "+mayor(a,b));
        System.out.println(a+" mayor o igual a "+b+"?"+" "+mayor_igual(a,b));
        System.out.println(a+" menor que "+b+"?"+" "+menor(a,b));
        System.out.println(a+" menor o igual a "+b+"?"+" "+menor_igual(a,b));
        System.out.println(a+" igual a "+b+"?"+" "+igual(a,b));
        System.out.println(a+" diferente de "+b+"?"+" "+diferente(a,b));
    }
}