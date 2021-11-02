/*
Problema: Megacentro de vacunación

El megacentro de vacunación de la universidad necesita su apoyo para automatizar el reporte con las estadísticas de la edad de los pacientes que van a vacunarse. 

Todos los días se le informa al director del megacentro cuántas dosis hay disponibles para aplicar en ese día. Entonces, el director del megacentro le solicita que diseñe y codifique 
un programa que, en sus propias palabras:

“Necesito un programa que se ejecute al iniciar la jornada y que permita digitar la edad de cada uno de los pacientes que ingresan al megacentro y se detenga cuando se terminen 
las dosis disponibles o cuando se vaya a cerrar el megacentro”

Al finalizar el ingreso de los pacientes, el programa debe generar un reporte con la siguiente información:
Cuántos pacientes son mayores de edad.
Cuántos pacientes son menores de edad. 
Cuántos pacientes ingresados son adultos mayores (más de  65 años)
Cuál es la edad promedio  de los pacientes que asistieron al centro de vacunación. 

Bonificación:
Su programa debe tener en cuenta que no es posible registrar pacientes menores de 12 años, dado que no existen todavía vacunas para ellos. 
Su programa lee la entrada en el main,  guarda los datos  en arreglos y los pasa a las subrutinas. 

*/

package ui;

import java.util.Scanner;

public class Megacentro{

    /*
    ----------------------Subrutina "edad_promedio"-------------------------
    Objetivo: Calcular el promedio de las edades de los vacunados.

    Entradas: 
        - Suma de la edades (Tipo: Entero , Nombre: suma_edades)
        - Numero de vacunados (Tipo: Entero , Nombre: vacunados)

    Salidas:
        - Promedio de las edades (Tipo: Double ,  Nombre: promedio)

    Funcionamiento:
        - Recibe por parametros la suma de las edades y el numero de vacunados
        - Crea una variable para guardar el promedio
        - Calcula el promedio dividiendo la suma de las edades entre el numero de vacunados
        - Devuelve el promedio como el valor de la subrutina
    
    Ejemplo:
        - suma_edades = 25
        - vacunados = 2
        - promedio = suma_edades/vacunados
        - promedio = 25/2
        - promedio = 25/2
    */
    public static double edad_promedio(int suma_edades, int vacunados){
        double promedio=0;

        promedio = (double) suma_edades/vacunados;

        return promedio;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba la cantidad de personas que se van a vacunar: ");
        int numero_personas = sc.nextInt();
        
        System.out.println("Escriba la cantidad de dosis disponibles: ");
        int numero_dosis = sc.nextInt();

        boolean megacentro_cerrado = false;
        String respuesta = "";


        int edad=0, suma_edades=0, menores_edad=0, mayores_edad=0, adultos_mayores=0, vacunados=0, i = 0;

        /*
        --------------------------------------------------------------Repetitiva-----------------------------------------------------------------------------------------
        Objetivo: hallar el numero de vacunados, entre ellos los que son mayores de edad, menores de edad y mayores de 65.

        Numero de itereciones:

        El numero de iteraciones, en principio esta definido por tres variables de control, las cuales son:

            - Numero de personas que se van a vacunar (Tipo: Entero , Nombre: numero_personas). Valor inicial: Deifinido por el usuario
            - Numero de dosis disponibles (Tipo: Entero , Nombre: numero_dosis). Valor inicial: Definido por el usuario.
            - Variable que almacena si el megacentro esta cerrado (true) o si esta abierto (false). (Tipo: booleano , Nombre: megacentro_cerrado). Valor inicial: false

        Condiciones de parada:
            - El numero de personas vacunadas alcanza la cantidad dictada por el usuario.
            - El numero de dosis llega a 0.
            - El usuario cierra el megacentro.

        Acumuladores:

            - i: Acumulador general (Avance)
            - Suma_edades: Suma las edades de los vacunados
            - Numero_dosis: Resta el numero de dosis disponibles.
            - Vacunados: Aumenta el numero cada vez que alguien se vacuna
            - menores_edad: Aumenta el numero si se vacuna un menor
            - mayores_edad: Aumenta el numero si se vacuna un mayor



        */
        
        while(i<=numero_personas && numero_dosis>0 && megacentro_cerrado==false){
            System.out.println("Escriba la edad de la persona a vacunar numero "+(i+1)+": ");
            edad = sc.nextInt();
            
            if(edad>=12){
                suma_edades = suma_edades + edad;
                numero_dosis--;
                vacunados++;

                if(edad<18){
                    menores_edad++;
                }
                else{
                    mayores_edad++;
                }

                if(edad>65){
                    adultos_mayores++;
                }

            }
            else{
                System.out.println("Usted es menor de 12, no se puede vacunar.");
                i--;
            }

            

            System.out.println("El megacentro ha cerrado?");
            respuesta = sc.next();

            /*
                Objetivo: Pedir valores hasta que escriba uno valido.

            */

            while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false){
                System.out.println("Escriba si o no. El megacentro ha cerrado?");
                respuesta = sc.next();
            }
            
            if(respuesta.equalsIgnoreCase("si")){
                megacentro_cerrado = true;
            }
            else if(respuesta.equalsIgnoreCase("no")){
                megacentro_cerrado = false;
            }

            i++;

            if(megacentro_cerrado){
                System.out.println("");
                System.out.println("--------------------------------------");
                System.out.println("Lo sentimos, el megacentro cerro.");
            }
            else if(numero_dosis<=0){
                System.out.println("");
                System.out.println("--------------------------------------");
                System.out.println("Se acabaron las dosis.");
            }
        }

        System.out.println("");
        System.out.println("--------------------------------------------------");
        System.out.println("Menores de edad vacunados: "+menores_edad);
        System.out.println("Mayores de edad vacunados: "+mayores_edad);
        System.out.println("Mayores de 65 vacunados: "+adultos_mayores);

        System.out.println("");

        System.out.println("Promedio de edades de las personas que asistieron al centro de vacunacion: "+edad_promedio(suma_edades,vacunados));
    }

}