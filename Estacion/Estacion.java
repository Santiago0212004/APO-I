/*
Santiago Jose Barraza Sinning - A00375190
-----------------------------------Contrato------------------------------------------------------------------------

Descripcion: Es un programa que permite calcular la estacion en la que se encuentra el usuario dependiendo del
numero del mes.

----------------------------------Subrutina "calcular_estacion"----------------------------------------------------

Descripcion: Es un metodo que tiene como funcion retornar la estacion cuando el usuario ingresa el mes.

Entradas:

    - Numero del mes en el que se encuentra el usuario (Nombre: mes , Tipo: int)

Salidas:

    - Estacion en la que se encuentra el usuario (Nombre: estacion_mes, Tipo: String)

Funcionamiento:

    1. Recibe el numero del mes por parametro desde el main.

    2. Comprueba cada una de las condiciones.

    3. Dependiendo de la condicion que se cumpla, asigna a la variable estacion_mes, la estacion correpondiente.

    4. Retorna el valor de la variable estacion_mes;

---------------------------------------------------Condiciones----------------------------------------------------

Desde el main, se pone una condicion, la cual dice que el mes tiene que ser mayor o igual a 1, y menor o igual a
12. De lo contrario se considera un valor invalido.

*/

import java.util.Scanner;

public class Estacion{
    public static String calcular_estacion(int mes){
        String estacion_mes = "";
        if (mes==12 || mes==1 || mes==2){
            estacion_mes = "invierno";
        }
        else if (mes==3 || mes==4 || mes==5){
            estacion_mes = "primavera";
        }
        else if (mes==6 || mes==7 || mes==8){
            estacion_mes = "verano";
        }
        else if (mes==9 || mes==10 || mes==11){
            estacion_mes = "otonio";
        }

        return estacion_mes;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el numero del mes en el que se encuentra: ");
        int mes = sc.nextInt();

        if(mes>=1 && mes<=12){
            System.out.println("La estacion en la que usted se encuentra es: "+calcular_estacion(mes));
        }
        else{
            System.out.println("El mes que usted digito es invalido.");
        }
    }
}