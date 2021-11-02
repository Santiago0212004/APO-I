import java.util.Scanner;

public class Calendario{

    public static String nombre_mes(int mes){
        String nombre = "";
        switch(mes){
            case 1:
                nombre = "Enero";
                break;
            case 2:
                nombre = "Febrero";
                break;
            case 3:
                nombre = "Marzo";
                break;
            case 4:
                nombre = "Abril";
                break;
            case 5:
                nombre = "Mayo";
                break;
            case 6:
                nombre = "Junio";
                break;
            case 7:
                nombre = "Julio";
                break;
            case 8:
                nombre = "Agosto";
                break;
            case 9:
                nombre = "Septiembre";
                break;
            case 10:
                nombre = "Octubre";
                break;
            case 11:
                nombre = "Noviembre";
                break;
            case 12:
                nombre = "Diciembre";
                break;
            default:
                nombre = "Numero no valido";
                break;
        }
        return nombre;
    }

    public static boolean valida (int dia,int mes,int anio){
        int max_dia = 0;
        if(anio==2021){
            switch(mes){
                case 1:
                    max_dia = 31;
                    break;
                case 2:
                    max_dia = 28;
                    break;
                case 3:
                    max_dia = 31;
                    break;
                case 4:
                    max_dia = 30;
                    break;
                case 5:
                    max_dia = 31;
                    break;
                case 6:
                    max_dia = 30;
                    break;
                case 7:
                    max_dia = 31;
                    break;
                case 8:
                    max_dia = 27;
                    break;
                default:
                    max_dia = 0;
                    break;
            }
        }
        else if(anio<2021 && anio>=0 && ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))){
            switch(mes){
                case 1:
                    max_dia = 31;
                    break;
                case 2:
                    max_dia = 29;
                    break;
                case 3:
                    max_dia = 31;
                    break;
                case 4:
                    max_dia = 30;
                    break;
                case 5:
                    max_dia = 31;
                    break;
                case 6:
                    max_dia = 30;
                    break;
                case 7:
                    max_dia = 31;
                    break;
                case 8:
                    max_dia = 31;
                    break;
                case 9:
                    max_dia = 30;
                    break;
                case 10:
                    max_dia = 31;
                    break;
                case 11:
                    max_dia = 30;
                    break;
                case 12:
                    max_dia = 31;
                    break;
                default:
                    max_dia = 0;
                    break;
            }
        }
        else if(anio<2021 && anio>=0){
            switch(mes){
                case 1:
                    max_dia = 31;
                    break;
                case 2:
                    max_dia = 28;
                    break;
                case 3:
                    max_dia = 31;
                    break;
                case 4:
                    max_dia = 30;
                    break;
                case 5:
                    max_dia = 31;
                    break;
                case 6:
                    max_dia = 30;
                    break;
                case 7:
                    max_dia = 31;
                    break;
                case 8:
                    max_dia = 31;
                    break;
                case 9:
                    max_dia = 30;
                    break;
                case 10:
                    max_dia = 31;
                    break;
                case 11:
                    max_dia = 30;
                    break;
                case 12:
                    max_dia = 31;
                    break;
                default:
                    max_dia = 0;
                    break;
            }
        }
        else{
            max_dia = 0;
        }

        if(dia<=max_dia && dia>0){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el dia: ");
        int dia = sc.nextInt();

        System.out.println("Escriba el mes: ");
        int mes = sc.nextInt();

        System.out.println("Escriba el anio: ");
        int anio = sc.nextInt();

        if (valida(dia,mes,anio)){
            System.out.println("La fecha: "+dia+" de "+nombre_mes(mes)+" de "+anio+" es valida.");
        }
        else{
            System.out.println("La fecha no es valida.");
        }
    }
}