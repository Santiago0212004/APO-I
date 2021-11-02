package ui;

import java.util.Scanner;

public class RecaudoDonaciones{

    public static Scanner sc = new Scanner(System.in);
    public static final int MAXIMO_DONANTES = 30;
    public static final int DINERO_NECESARIO = 300000000;


    /**
    * Descripción: Este metodo pide las donaciones, incluyendo nombre y anio. A base de esto calcula el total de dinero recaudado y la cantidad de mega donaciones</br>
    * @param <cantidadDonaciones> <int>, condiciones sobre el parametro --> si tiene
    */
    public static void pedirDonacion(int cantidadDonaciones){

        int donacion, megaDonaciones=0, donacionesTotales=0;
        String nombre, anio;

        String[] nombres = new String[cantidadDonaciones];
        String[] anios = new String[cantidadDonaciones];
        
        for(int i=0; i<cantidadDonaciones; i++){
            

            System.out.println("");

            System.out.println("Escriba su nombre.");
            nombre = sc.next();
            nombres[i] = nombre;

            System.out.println("Escriba el anio en el que se graduo.");
            anio = sc.next();
            anios[i] = nombre;
            
            

            System.out.print(nombre+" escriba la cantidad a donar: ");
            donacion = sc.nextInt();

            if(donacion>5000000){
                megaDonaciones++;
            }

            donacionesTotales += donacion;
        }

        guardarNombres(nombres);
        guardarAnios(anios);

        System.out.println("La cantidad restante para llegar a la cifra de 300.000.000 de pesos es: "+restante(donacionesTotales)+" de pesos y la cantidad de megadonaciones fue: "+megaDonaciones+".");


        
    }

    /**
    * Descripción: Este metodo guarda en si mismo el arreglo con los nombres de los donantes</br>
    * @param <nombres> <String[]>, condiciones sobre el parametro --> si tiene
    * @return <nombres> <String[]>, informacion sobre variable de retorno --> retorno
    */

    public static String[] guardarNombres (String[] nombres){
        return nombres;
    }

    /**
    * Descripción: Este metodo guarda en si mismo el arreglo con los anios de graduacion de los donantes</br>
    * @param <anios> <String[]>, condiciones sobre el parametro --> si tiene
    * @return <anios> <String[]>, informacion sobre variable de retorno --> retorno
    */

    public static String[] guardarAnios(String[] anios){
        return anios;
    }

    /**
    * Descripción: Este metodo calcula la cantidad faltante para llegar a los 300.000.000, restando a esta cantidad la cantidad total recaudada.</br>
    * @param <donacionesTotales> <int>, condiciones sobre el parametro --> si tiene
    * @return <valorRestante> <int>, informacion sobre variable de retorno --> retorno
    */

    public static int restante(int donacionesTotales){
        int valorRestante;

        valorRestante = DINERO_NECESARIO - donacionesTotales;
        return valorRestante;
    }

    public static void main(String[] args){
        System.out.println("BIENVENIDO AL PROGRAMA DE DONACIONES DE LA INSTITUCION EDUCATIVA.");
        
        int cantidadDonaciones;

        System.out.println("Escriba la cantidad de donaciones que desea registrar."); 
        cantidadDonaciones = sc.nextInt();
        
        /*
        Este ciclo valida que la cantidad de donaciones no pueda ser mayor al maximo propuesto (30) ni menor a 1.
        Variable de control: cantidadDonaciones
        */

        while(cantidadDonaciones<1 || cantidadDonaciones>MAXIMO_DONANTES){
            System.out.println("La cantidad de donaciones no puede sobrepasar las 30 ni ser menor que 1");
            System.out.println("Escriba la cantidad de donaciones que desea registrar."); 
            cantidadDonaciones = sc.nextInt();
        }

        pedirDonacion(cantidadDonaciones);      
    }
}