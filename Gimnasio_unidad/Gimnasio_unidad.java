/*
---------------------------------------------------------------------------Contrato-------------------------------------------------------------------------
Problema
Una unidad residencial de apartamentos acaba de habilitar un gimnasio de última tecnología. Con el fin de garantizar el mantenimiento de los equipos y la infraestructura del gimnasio, 
la Administración ha decidido cobrar una cuota extraordinaria anual a cada propietario de la unidad. La Administración lo ha comisionado para escribir un programa que le permita a cada 
copropietario conocer cuál es el valor de la cuota extraordinaria que debe pagar por su apartamento, dados su edad, el tipo de apartamento en el que vive y la periodicidad con la que 
utilizará el gimnasio en días a la semana. La cuota extraordinaria básica anual es: $50.000.

Considere las siguientes condiciones:

Si la persona es mayor a 65 años tendrá un descuento del 40% en el valor total de la cuota extraordinaria.

Existen tres tipos de apartamento: 
Apartaestudio: 1 habitación, paga un incremento de 10% en la cuota extraordinaria.
Familiar: 2 habitaciones, paga un incremento de 15% en la cuota extraordinaria.
Dúplex: 4 habitaciones, paga un incremento de 20% en la cuota extraordinaria.
Penthouse: 6 habitaciones, paga un incremento de 25% en la cuota extraordinaria.

La periodicidad con la que utilizará el gimnasio determina decrementos o incrementos en la cuota extraordinaria:
0 días a la semana: Se reduce la cuota extraordinaria en 20%
1 a 2 días a la semana: No hay incremento
3 a 4 días a la semana: 5% de incremento
5 a 6 días a la semana: 7% de incremento
7 días a la semana: 10% de incremento

La Administración le solicita, por temas de trazabilidad, que a cada copropietario se le presente cada uno de los cargos de forma desagregada y el total a pagar.

Bonificación
Incluya la siguiente condición como otra subrutina dentro del programa: El número de habitantes en el apartamento determina un incremento adicional
en la cuota extraordinaria: 1 a 2: No hay incremento, 3 a 4: 2% de incremento por persona y 5 o más: 5% de incremento por persona

-------------------------------------------------------------------Subrutina "descuento_edad"-----------------------------------------------------------------------
Entradas: 
    - Cuota basica (Nombre: cuota_basica,Tipo de dato: double)
    - Edad del usuario (Nombre: edad,Tipo de dato: int)
Salidas:
    - Descuento que existe por la edad (Nombre: descuento,Tipo de dato: double)

Paso a paso:
    - Recibe por parametros la cuota basica y la edad
    - Crea una variable para almacenar el descuento
    - Comprueba si la edad es mayor a 65, si es verdad, crea el descuento correspondiente al 40%. Si no se cumple no hay descuento por edad
    - Retorna el descuento
Ejemplo:
    edad = 68
    descuento = cuota_basica * 0.40
    descuento = 50000 * 0.40
    descuento = 20000

-------------------------------------------------------------------Subrutina "aumento_apartamento"-----------------------------------------------------------------------
Entradas: 
    - Cuota basica (Nombre: cuota_basica,Tipo de dato: double)
    - Tipo de apartamento (Nombre: tipo_apartamento,Tipo de dato: String)
Salidas:
    - Aumento que existe por el tipo de apartamento (Nombre: aumento,Tipo de dato: double)

Paso a paso:
    - Recibe por parametros la cuota basica y el tipo de apartamento
    - Crea una variable para almacenar el aumento
    - Comprueba si el tipo de apartamento equivale a alguno de los indicados y aplica el aumento. Si no cumple con ninguno, aparece un error y cierra el programa.
    - Retorna el aumento
Ejemplo:
    tipo_apartamento = Duplex
    aumento = cuota_basica * 0.20
    aumento = 50000 * 0.20
    aumento = 10000

-------------------------------------------------------------------Subrutina "aumento_periodicidad"-----------------------------------------------------------------------
Entradas: 
    - Cuota basica (Nombre: cuota_basica,Tipo de dato: double)
    - Numero de veces que usa el gimnasio a la semana (Nombre: periodicidad,Tipo de dato: int)
Salidas:
    - Aumento que existe por la periodicidad (Nombre: aumento,Tipo de dato: double)

Paso a paso:
    - Recibe por parametros la cuota basica y la periodicidad
    - Crea una variable para almacenar el aumento
    - Comprueba si la periodicidad equivale a alguna de las indicadas y aplica el aumento o descuento. Si no cumple con ninguna, aparece un error y cierra el programa.  
    - Retorna el aumento
Ejemplo:
    periodicidad = 3
    aumento = cuota_basica * 0.05
    aumento = 50000 * 0.05
    aumento = 2500

-------------------------------------------------------------------Subrutina "aumento_habitantes"-----------------------------------------------------------------------
Entradas: 
    - Cuota basica (Nombre: cuota_basica,Tipo de dato: double)
    - Numero de habitantes en el hogar (Nombre: numero_habitantes,Tipo de dato: int)
Salidas:
    - Aumento que existe por el numero de habitantes (Nombre: aumento,Tipo de dato: double)

Paso a paso:
    - Recibe por parametros la cuota basica y la el numero de habitantes
    - Crea una variable para almacenar el aumento
    - Comprueba el numero de habitantes y aplica el aumento correspondiente, multiplicandolo por la cantidad de habitantes.  
    - Retorna el aumento
Ejemplo:
    numero_habitantes = 4
    aumento = cuota_basica * 0.02 * 4
    aumento = 50000 * 0.02 * 4
    aumento = 4000

-------------------------------------------------------------------Subrutina "calcular_desagregados"-----------------------------------------------------------------------
Entradas: 
    - Descuento por edad (Nombre: descuento_edad,Tipo de dato: double)
    - Aumento por periodicidad (Nombre: aumento_periodicidad,Tipo de dato: String)
Salidas:
    - Desagragados (Nombre: desagregados,Tipo de dato: double)

Paso a paso:
    - Recibe parametros.
    - Calcula desagregados
Ejemplo:
    desagregados = 0

-------------------------------------------------------------------Subrutina "calcular_total"-----------------------------------------------------------------------
Entradas: 
    - Todos los aumentos y descuentos
Salidas:
    - Total a pagar (Nombre: total,Tipo de dato: double)

Paso a paso:
    - Recibe parametros.
    - Suma todo y sale el total
Ejemplo:
    desagregados = 46500
*/

import java.util.Scanner;

public class Gimnasio_unidad{

    public static double descuento_edad(double cuota_basica,int edad){
        double descuento=0;
        if(edad>65){
            descuento = cuota_basica * 0.40;
        }
        else{
            descuento = 0;
        }

        return descuento;
    }

    public static double aumento_apartamento(double cuota_basica,String tipo_apartamento){
        double aumento=0;

        if(tipo_apartamento.equalsIgnoreCase("Apartaestudio")){
            aumento = cuota_basica * 0.10;
        }
        else if(tipo_apartamento.equalsIgnoreCase("Familiar")){
            aumento = cuota_basica * 0.15;
        }
        else if(tipo_apartamento.equalsIgnoreCase("Duplex")){
            aumento = cuota_basica * 0.20;
        }
        else if(tipo_apartamento.equalsIgnoreCase("Penthouse")){
            aumento = cuota_basica * 0.25;
        }
        else{
            System.out.println("ERROR: Tipo de apartamento no valido.");
            System.exit(0);
        }
        return aumento;
    }

    public static double aumento_periodicidad(double cuota_basica, int periodicidad){
        double aumento=0;

        if(periodicidad == 0){
            aumento = cuota_basica * (-0.20);
        }
        else if(periodicidad == 1 || periodicidad == 2){
            aumento = 0;
        }
        else if(periodicidad == 3 || periodicidad == 4){
            aumento = cuota_basica * 0.05;
        }
        else if(periodicidad == 5 || periodicidad == 6){
            aumento = cuota_basica * 0.07;
        }
        else if(periodicidad == 7){
            aumento = cuota_basica * 0.10;
        }
        else{
            System.out.println("ERROR: Periodicidad no valida.");
            System.exit(0);
        }
        return aumento;
    }

    public static double aumento_habitantes(double cuota_basica, int numero_habitantes){
        double aumento=0;

        if(numero_habitantes == 1 || numero_habitantes == 2){
            aumento = 0;
        }
        else if(numero_habitantes == 3 || numero_habitantes == 4){
            aumento = cuota_basica * 0.02 * numero_habitantes;
        }
        else if(numero_habitantes>=5){
            aumento = cuota_basica * 0.05 * numero_habitantes;
        }
        else{
            System.out.println("ERROR: Periodicidad no valida.");
            System.exit(0);
        }
        return aumento;
    }


    public static double calcular_desagregados( double descuento_edad, double aumento_apartamento, double aumento_periodicidad, double aumento_habitantes){
        double desagregados;

        desagregados = (descuento_edad*-1) + aumento_apartamento + aumento_periodicidad + aumento_habitantes;

        return desagregados;
    }

    public static double calcular_total(double cuota_basica, double descuento_edad, double aumento_apartamento, double aumento_periodicidad, double aumento_habitantes){
        double total = cuota_basica - descuento_edad + aumento_apartamento + aumento_periodicidad + aumento_habitantes;
        return total;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        double cuota_basica = 50000;
        double total_pagar, total_desagregados;
        int edad, periodicidad, numero_habitantes;
        String tipo_apartamento;
        
        System.out.println("Escriba su edad: ");
        edad = sc.nextInt();
        System.out.println("Escriba la periodicidad con la que usara el gimnasio (semanal): ");
        periodicidad = sc.nextInt();
        System.out.println("Escriba el tipo de apartamento en el que vive: ");
        tipo_apartamento = sc.next();
        System.out.println("Escriba la cantidad de habitantes que hay en su apartamento (con usted incluido): ");
        numero_habitantes = sc.nextInt();
        
        total_pagar = calcular_total(cuota_basica,descuento_edad(cuota_basica,edad),aumento_apartamento(cuota_basica,tipo_apartamento),aumento_periodicidad(cuota_basica,periodicidad),aumento_habitantes(cuota_basica,numero_habitantes));
        total_desagregados = calcular_desagregados(descuento_edad(cuota_basica,edad),aumento_apartamento(cuota_basica,tipo_apartamento),aumento_periodicidad(cuota_basica,periodicidad),aumento_habitantes(cuota_basica,numero_habitantes));
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("El valor de la cuota basica es: "+cuota_basica+" pesos.");
        System.out.println("El descuento por edad es de: "+descuento_edad(cuota_basica,edad)+" pesos.");
        System.out.println("El aumento por el tipo de apartamento es de: "+aumento_apartamento(cuota_basica,tipo_apartamento)+" pesos.");
        System.out.println("El aumento o descuento por la periodicidad es de: "+aumento_periodicidad(cuota_basica,periodicidad)+" pesos.");
        System.out.println("El aumento o descuento por la cantidad de habitantes es de: "+aumento_habitantes(cuota_basica,numero_habitantes)+" pesos.");
        
        System.out.println("");

        System.out.println("El total a pagar de cuota extraordinaria es de: "+total_pagar+" pesos.");
        System.out.println("El total de desagregados a la cuota extraordinaria es de: "+total_desagregados+" pesos.");

    }
}