/* 

Nombre: Santiago José Barraza Sinning
Codigo de estudiante: A00375190

Problema
Impresiones Gutenberg es un negocio que ofrece el servicio de transcripción e impresión de documentos como libros, trabajos, monografías, tesis, etc.  
Este negocio emplea estudiantes que trabajan por horas  en su tiempo libre como digitadores.  Los  digitadores se encargan de transcribir los documentos.

Escriba un programa para que dados la cantidad de palabras que tiene un documento y la cantidad de horas al día que trabaja un digitador, 
calcule el costo de transcribir e imprimir el documento y el tiempo en días que tardará en estar lista la transcripción. 

- Un digitador teclea en promedio 83 palabras por minuto.
- Al digitador se le paga $10.000 por cada 1000 palabras digitadas. 
- Una página tiene en promedio 800 palabras.
- La impresión de una página cuesta $500 pesos. 


Subrutinas:

Subrutina "costo_total": Esta subrutina es la encargada de calcular el costo total de transcribir e imprimir el documento.

Entrada:
	- Cantidad de palabras a transcribir (Tipo: Entero). La funcionalidad de esta variable es que a partir de esta podramos calcular la paga que hay que hacerle al digitador
	y la cantidad de paginas.
Salida:
	- La salida que nos devuelve esta subrutina es el costo total de imprimir, producto de sumar la paga del digitador y el precio de las paginas (Tipo: Double).
Metodología:
	- Primero, a partir de una regla de 3 se calcula la paga del digitador, dividiendo la cantidad de palabras entre 1000 (ya que se le paga por cada 1000 palabras)
	y luego lo multiplicamos por 10000 que es la cantidad que le pagan por las 1000 palabras.
	- Segundo, dividimos la cantidad de palabras entre 800 para hallar la cantidad de paginas, ya que cada pagina contiene 800 palabras.
	- Tercero, al cada pagina costar 500, multplicamos este precio por la cantidad de páginas, esto para saber el costo de todas las paginas.

Subrutina "tiempo_dias": Halla tiempo en dias.

Entrada:
	- Cantidad de palabras a transcribir (Tipo: Entero). La funcionalidad de esta variable es que a partir de esta conocemos el tiempo.
	- Horas que trabaja el digitador al día (Tipo: Entero).
Salida:
	- La salida que nos devuelve esta subrutina es el tiempo a esperar (Tipo: Double).
Metodología: 
*/

import java.util.Scanner;

public class Impresiones{

	public static double costo_total(int cantidad_palabras){
		double paga_digitador = (cantidad_palabras/1000)*10000;
		double cantidad_paginas = cantidad_palabras/800;
		double precio_paginas = cantidad_paginas*500;

		return paga_digitador + precio_paginas;
	}

	public static double tiempo_dias(int cantidad_palabras, int horas_digitador){
		double palabras_dia = 83*60*horas_digitador;
		
		return cantidad_palabras/palabras_dia;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese la cantidad de palabras a transcribir e imprimir: ");
		int cantidad_palabras = sc.nextInt();

		System.out.println("");

		System.out.println("Ingrese la cantidad de horas que trabaja el digitador: ");
		int horas_digitador = sc.nextInt();

		System.out.println("El costo total de transcribir e imprimir las paginas es: "+costo_total(cantidad_palabras)+" pesos.");
		System.out.println("Ustede tendrá que esperar: "+tiempo_dias(cantidad_palabras,horas_digitador)+" dias para tener lista su transcripcion.");
	}
}