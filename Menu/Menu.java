import java.util.Scanner;

public class Menu{

    public static Scanner sc = new Scanner(System.in);

    public static void crearArreglo(){

    }

    public static void imprimirArreglo(){

    }
    
    public static void buscarNumero(){

    }

    public static void mayor(){

    }

    public static void menor(){

    }

    public static void modificarElementos(){

    }

    public static void modificarAlgunosElementos(){

    }

    public static void desplegarMenu(){
        
        int metodo = 0;

        while(metodo!=-1){

            System.out.println("\n----------------------------------------------------------------------------------------------------------------- ");

            System.out.println("1. Crear arreglo."+"\n2. Imprimir arreglo."+"\n3. Buscar un numero en el arreglo."
            +"\n4. Imprimir mayor o menor numero del arreglo."+"\n5. Modificar valores del arreglo."+"\n6. Modificar algunos valores del arreglo.");

            System.out.println("\nEscriba el metodo que desea ejecutar (-1 para salir): ");
            metodo = sc.nextInt();

            int mayor_o_menor;

            switch(metodo){
                case -1:
                    System.out.println("\nPrograma finalizado.\n");
                case 1:
                    crearArreglo();
                    break;
                case 2:
                    imprimirArreglo();
                    break;
                case 3:
                    buscarNumero();
                    break;
                case 4:
                    System.out.println("Desea imprimir el mayor o el menor? (1 para mayor, 2 para menor)");
                    mayor_o_menor = sc.nextInt();

                    if(mayor_o_menor==1){
                        mayor();
                    }
                    else if(mayor_o_menor==2){
                        menor();
                    }
                    else{
                        while(mayor_o_menor!=1 && mayor_o_menor!=2){
                            System.out.println("Escriba 1 o 2");
                            mayor_o_menor = sc.nextInt();

                            if(mayor_o_menor==1){
                                mayor();
                            }
                            else if(mayor_o_menor==2){
                                menor();
                            }
                        }
                    }

                    break;
                case 5:
                    modificarElementos();
                    break;
                case 6:
                    modificarAlgunosElementos();
                    break;
                default:
                    System.out.println("\nNo se ejecuto nada, escriba un valor valido.\n");
            }
        }
    }

    public static void main(String[] args){
        desplegarMenu();
    }
}