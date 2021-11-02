package ui; //Paquete en el que se encuentra la clase

import java.util.Scanner; //Se importa la libreria que permite la lectura de datos en java


/**
* ----------------------------------------------------------Contract-----------------------------------------------------------
* @author Santiago Jose Barraza Sinning - A00375190
* 
*
*/


//Se declara la clase principal del programa
public class NumeralSystems{
    
    public static final String[] DECIMALS = {"0","1","2","3","4","5","6","7","8","9"};

    public static final String[] BINARIES = {"0","1"};

    public static final String[] HEXADECIMALS = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    static Scanner sc = new Scanner(System.in); //Se crea el Scanner que utilizaremos en todos los metodos de la clase

    public static void main(String[] args){
        System.out.println("Hi! Welcome to the program. What functionality do you want to use?");
        menu();
    }

    /**
    * Description: This method is a menu where the two main functionalities of the program appear and it validates that the user writes a valid one. It also allows you to exit the program.</br>
    */

    public static void menu(){
        
        System.out.println("\n----------------------------------------------------------------------------------------------------------------- ");
        System.out.println("\n1. Number systems converter.");
        System.out.println("\n2. Binary number calculator.");
        System.out.println("\n-1. To exit.");
        
        System.out.println("\nSelect a functionality : ");
        int functionality = sc.nextInt();

        if(functionality==1){
            numConverter();
        }
        else if(functionality==2){
            //binaryCalculator();
        }
        else if(functionality==-1){
            System.out.println("\nProgram finished.");
        }

        while(functionality!=1 && functionality!=2 && functionality!=-1){
            System.out.println("Choose a valid option: ");
            functionality = sc.nextInt();

            if(functionality==1){
                numConverter();
            }
            else if(functionality==2){
                //binaryCalculator();
            }
            else if(functionality==-1){
                System.out.println("\nProgram finished.");
            }
        }
    }

    
    /**
    * Description: This method opens the menu of the first option (Conversion system), and validates that what we have chosen has been valid.</br>
    */

    public static void numConverter(){

        int numSystem = 0;
        int digitsQuantity = 0;

        while(numSystem!=-1){

            System.out.println("\n----------------------------------------------------------------------------------------------------------------- ");

            System.out.println("\n1. Decimal.");
            System.out.println("\n2. Binary.");
            System.out.println("\n3. Hexadecimal.");
            System.out.println("\n-1 To come back to the menu");

            System.out.println("\nChoose the number system: \n");
            numSystem = sc.nextInt();


            switch(numSystem){
                case -1:
                    System.out.println("\n");
                    menu();
                    break;
                case 1:
                    System.out.println("\nWrite the digits quantity you want to use: ");
                    digitsQuantity = sc.nextInt();
                    askDecimal(digitsQuantity);
                    break;
                case 2:
                    System.out.println("\nWrite the digits quantity you want to use: ");
                    digitsQuantity = sc.nextInt();
                    askBinary(digitsQuantity);
                    break;
                case 3:
                    System.out.println("\nWrite the digits quantity you want to use: ");
                    digitsQuantity = sc.nextInt();
                    askHexadecimal(digitsQuantity);
                    break;
                default:
                    while(numSystem!=1 && numSystem!=2 && numSystem!=3){
                        System.out.println("Choose a valid option: ");
                        numSystem = sc.nextInt();

                        if(numSystem==1){
                            System.out.println("\nWrite the digits quantity you want to use: ");
                            digitsQuantity = sc.nextInt();
                            askDecimal(digitsQuantity);
                        }
                        else if(numSystem==2){
                            System.out.println("\nWrite the digits quantity you want to use: ");
                            digitsQuantity = sc.nextInt();
                            askBinary(digitsQuantity);

                        }
                        else if(numSystem==3){
                            System.out.println("\nWrite the digits quantity you want to use: ");
                            digitsQuantity = sc.nextInt();
                            askHexadecimal(digitsQuantity);
                        }
                    break;
                }
            }

        }
    }

//------------------------------------------------------Methods that ask for the numbers-----------------------------------------------

    public static void askDecimal(int digitsQuantity){
        String[] decimalNumber = new String[digitsQuantity];

        String decimalDigit;

        for(int i=0; i<digitsQuantity; i++){
            System.out.println("Write de digit number "+(i+1)+" of your number: ");
            decimalDigit = sc.next();
            decimalNumber[i] = decimalDigit;
        }

        if(validateDecimal(decimalNumber , digitsQuantity)){
            decimalConverted(decimalNumber, digitsQuantity);
        }
        else{
            while(validateDecimal(decimalNumber, digitsQuantity)==false){
                System.out.println("\nWrite the digits according to the numbering system.\n");

                //Enters the digits
                for(int i=0; i<digitsQuantity; i++){
                    System.out.println("Write de digit number "+(i+1)+" of your number: ");
                    decimalDigit = sc.next();
                    decimalNumber[i] = decimalDigit;
                }
            }
            decimalConverted(decimalNumber, digitsQuantity);    
        }
    }

    public static void askBinary(int digitsQuantity){
        String[] binaryNumber = new String[digitsQuantity];

        String binaryDigit;

        for(int i=0; i<digitsQuantity; i++){
            System.out.println("Write de digit number "+(i+1)+" of your number: ");
            binaryDigit = sc.next();
            binaryNumber[i] = binaryDigit;
        }

        if(validateBinary(binaryNumber , digitsQuantity)){
            binaryConverted(binaryNumber, digitsQuantity);
        }
        else{
            while(validateBinary(binaryNumber, digitsQuantity)==false){
                System.out.println("\nWrite the digits according to the numbering system.\n");

                //Enters the digits
                for(int i=0; i<digitsQuantity; i++){
                    System.out.println("Write de digit number "+(i+1)+" of your number: ");
                    binaryDigit = sc.next();
                    binaryNumber[i] = binaryDigit;
                }
            }
            binaryConverted(binaryNumber, digitsQuantity);
        }
    }
    
    public static void askHexadecimal(int digitsQuantity){
        String[] hexadecimalNumber = new String[digitsQuantity];

        String hexadecimalDigit;

        for(int i=0; i<digitsQuantity; i++){
            System.out.println("Write de digit number "+(i+1)+" of your number: ");
            hexadecimalDigit = sc.next();
            hexadecimalNumber[i] = hexadecimalDigit;
        }

        if(validateHexadecimal(hexadecimalNumber , digitsQuantity)){
            hexadecimalConverted(hexadecimalNumber, digitsQuantity);
        }
        else{
            while(validateHexadecimal(hexadecimalNumber, digitsQuantity)==false){
                System.out.println("\nWrite the digits according to the numbering system.\n");

                //Enters the digits
                for(int i=0; i<digitsQuantity; i++){
                    System.out.println("Write de digit number "+(i+1)+" of your number: ");
                    hexadecimalDigit = sc.next();
                    hexadecimalNumber[i] = hexadecimalDigit;
                }
            }
            hexadecimalConverted(hexadecimalNumber, digitsQuantity);
        }
    }

//---------------------------------------------------------Methods that validate--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 

    public static boolean validateDecimal(String[] decimalNumber, int digitsQuantity){
        boolean valid=false;

        for(int i=0; i<digitsQuantity; i++){
            if (decimalNumber[i].equals("0")==false && decimalNumber[i].equals("1")==false && decimalNumber[i].equals("2")==false && decimalNumber[i].equals("3")==false && decimalNumber[i].equals("4")==false && decimalNumber[i].equals("5")==false && decimalNumber[i].equals("6")==false && decimalNumber[i].equals("7")==false && decimalNumber[i].equals("8")==false && decimalNumber[i].equals("9")==false){
                valid = false;
                i = digitsQuantity;
            }
            else{
                valid = true;
            }
        }
        
        return valid;
    }

    public static boolean validateBinary(String[] binaryNumber, int digitsQuantity){
        boolean valid=false;

        for(int i=0; i<digitsQuantity; i++){
            if (binaryNumber[i].equals("0")==false && binaryNumber[i].equals("1")==false){
                valid = false;
                i = digitsQuantity;
            }
            else{
                valid = true;
            }
        }
        
        return valid;
    }

    public static boolean validateHexadecimal(String[] hexadecimalNumber, int digitsQuantity){
        boolean valid=false;

        for(int i=0; i<digitsQuantity; i++){
            hexadecimalNumber[i] = hexadecimalNumber[i].toUpperCase();
        }

        for(int i=0; i<digitsQuantity; i++){
            if (hexadecimalNumber[i].equals("0")==false && hexadecimalNumber[i].equals("1")==false && hexadecimalNumber[i].equals("2")==false && hexadecimalNumber[i].equals("3")==false && hexadecimalNumber[i].equals("4")==false && hexadecimalNumber[i].equals("5")==false && hexadecimalNumber[i].equals("6")==false && hexadecimalNumber[i].equals("7")==false && hexadecimalNumber[i].equals("8")==false && hexadecimalNumber[i].equals("9")==false && hexadecimalNumber[i].equals("A")==false && hexadecimalNumber[i].equals("B")==false && hexadecimalNumber[i].equals("C")==false && hexadecimalNumber[i].equals("D")==false && hexadecimalNumber[i].equals("E")==false && hexadecimalNumber[i].equals("F")==false){
                valid = false;
                i = digitsQuantity;
            }
            else{
                valid = true;
            }
        }
        
        return valid;
    }

    public static String getNumber(String[] number, int digitsQuantity){
        String stringNumber = "";

        for(int i=0; i<digitsQuantity; i++){
            stringNumber+=number[i]; 
        }

        return stringNumber;
    }


//---------------------------------------Methods that convert the decimal number-----------------------------------------------------------------

    public static String decimalToBinary(String[] decimalNumber, int digitsQuantity){
        int decimalDigit, remainder, integerDecimal=0, exp=digitsQuantity-1;
        String binaryNumber="";

        for(int i=0;i<digitsQuantity;i++){
            for(int j=0;j<10;j++){
                if(decimalNumber[i].equalsIgnoreCase(DECIMALS[j])){
                    decimalDigit = j;
                    integerDecimal += decimalDigit * (Math.pow(10,exp));
                    exp--;
                    j = 10;
                } 
            }
        }
        
        do{
            remainder = integerDecimal%2;
            integerDecimal = integerDecimal/2;
            binaryNumber = BINARIES[remainder] + binaryNumber;
        }while(integerDecimal > 0);

    

        return binaryNumber;
    }



//---------------------------------------Methods that print---------------------------------------------------------------------------------------

    public static void decimalConverted(String[] decimalNumber, int digitsQuantity){
        System.out.println("\n"+getNumber(decimalNumber, digitsQuantity));

        System.out.println("\nBinary: "+decimalToBinary(decimalNumber, digitsQuantity));

        //System.out.println("Hexadecimal: "+decimalToHexadecimal(numberDigitsDecimal, digitsQuantity));
    }

    public static void binaryConverted(String[] binaryNumber, int digitsQuantity){
        System.out.println("\n"+getNumber(binaryNumber, digitsQuantity));
        
        //System.out.println("Decimal: "+binaryToDecimal(numberDigitsBinary, digitsQuantity));
        //System.out.println("Hexadecimal: "+binaryToHexadecimal(numberDigitsBinary, digitsQuantity));
    }

    public static void hexadecimalConverted(String[] hexadecimalNumber, int digitsQuantity){
        System.out.println("\n"+getNumber(hexadecimalNumber, digitsQuantity));
        
        //System.out.println("Decimal: "+hexadecimalToDecimal(numberDigitsHexadecimal, digitsQuantity));
        //System.out.println("Binary: "+hexadecimalToBinary(numberDigitsHexadecimal, digitsQuantity));
    }

}