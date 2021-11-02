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


    static Scanner sc = new Scanner(System.in); //Se crea el Scanner que utilizaremos en todos los metodos de la clase

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
            binaryCalculator();
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
                binaryCalculator();
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


    /**
     * This method takes care of asking for the digits one by one if our choice was decimal and makes sure that we wrote something correct, using the validation method for this. Also print the conversions
     * @param digitsQuantity, this is the quantity of digits that the user entered by keyboard.
     */

    public static void askDecimal(int digitsQuantity){

        int [] numberDigitsDecimal = new int[digitsQuantity];

        int decimalDigit;

        //Enters the digits

        for(int i=0; i<digitsQuantity; i++){
            System.out.println("Write de digit number "+(i+1)+" of your number: ");
            decimalDigit = sc.nextInt();
            numberDigitsDecimal[i] = decimalDigit;
        }

        if(validateDecimal(numberDigitsDecimal , digitsQuantity)){
            System.out.println("\n"+getNumber(numberDigitsDecimal, digitsQuantity));
            System.out.println("\nBinary: "+decimalToBinary(numberDigitsDecimal, digitsQuantity));
            System.out.println("Hexadecimal: "+decimalToHexadecimal(numberDigitsDecimal, digitsQuantity));
        }
        else{
            while(validateDecimal(numberDigitsDecimal, digitsQuantity)==false){
                System.out.println("Write the digits according to the numbering system.");

                //Enters the digits
                for(int i=0; i<digitsQuantity; i++){
                    System.out.println("Write de digit number "+(i+1)+" of your number: ");
                    decimalDigit = sc.nextInt();
                    numberDigitsDecimal[i] = decimalDigit;
                }
            }
            System.out.println("\n"+getNumber(numberDigitsDecimal, digitsQuantity));
            System.out.println("\nBinary: "+decimalToBinary(numberDigitsDecimal, digitsQuantity));
            System.out.println("Hexadecimal: "+decimalToHexadecimal(numberDigitsDecimal, digitsQuantity));
        }

    }

    /**
     * This method takes care of asking for the digits one by one if our choice was binary and makes sure that we wrote something correct, using the validation method for this. Also print the conversions
     * @param digitsQuantity, this is the quantity of digits that the user entered by keyboard.
     */


    public static void askBinary(int digitsQuantity){

        int[] numberDigitsBinary = new int[digitsQuantity];

        int binaryDigit;

        //Enters the digits
        for(int i=0; i<digitsQuantity; i++){
            System.out.println("Write de digit number "+(i+1)+" of your number: ");
            binaryDigit = sc.nextInt();
            numberDigitsBinary[i] = binaryDigit;
        }

        if(validateBinary(numberDigitsBinary , digitsQuantity)){
            System.out.println("\n"+getNumber(numberDigitsBinary, digitsQuantity));
            System.out.println("Decimal: "+binaryToDecimal(numberDigitsBinary, digitsQuantity));
            System.out.println("Hexadecimal: "+binaryToHexadecimal(numberDigitsBinary, digitsQuantity));
        }
        else{
            while(validateBinary(numberDigitsBinary, digitsQuantity)==false){
                System.out.println("EWrite the digits according to the numbering system.");

                //Enters the digits
                for(int i=0; i<digitsQuantity; i++){
                    System.out.println("Write de digit number "+(i+1)+" of your number: ");
                    binaryDigit = sc.nextInt();
                    numberDigitsBinary[i] = binaryDigit;
                }
            }
            System.out.println("\n"+getNumber(numberDigitsBinary, digitsQuantity));
            System.out.println("Decimal: "+binaryToDecimal(numberDigitsBinary, digitsQuantity));
            System.out.println("Hexadecimal: "+binaryToHexadecimal(numberDigitsBinary, digitsQuantity));
        }    
    }

    /**
     * This method takes care of asking for the digits one by one if our choice was hexadecimal and makes sure that we wrote something correct, using the validation method for this. Also print the conversions
     * @param digitsQuantity, this is the quantity of digits that the user entered by keyboard.
     */

    public static void askHexadecimal(int digitsQuantity){

        String[] numberDigitsHexadecimal = new String[digitsQuantity];

        String hexadecimalDigit = "";


        //Enters the digits
        for(int i=0; i<digitsQuantity; i++){
            System.out.println("Write de digit number "+(i+1)+" of your number: ");
            hexadecimalDigit = sc.next();
            numberDigitsHexadecimal[i] = hexadecimalDigit;
        }

        if(validateHexadecimal(numberDigitsHexadecimal , digitsQuantity)){
            System.out.println("\n"+getNumberString(numberDigitsHexadecimal, digitsQuantity));
            System.out.println("Decimal: "+hexadecimalToDecimal(numberDigitsHexadecimal, digitsQuantity));
            System.out.println("Binary: "+hexadecimalToBinary(numberDigitsHexadecimal, digitsQuantity));
        }
        else{
            while(validateHexadecimal(numberDigitsHexadecimal, digitsQuantity)==false){
                System.out.println("Write the digits according to the numbering system.");

                //Enters the digits
                for(int i=0; i<digitsQuantity; i++){
                    System.out.println("Write de digit number "+(i+1)+" of your number: ");
                    hexadecimalDigit = sc.next();
                    numberDigitsHexadecimal[i] = hexadecimalDigit;
                }
            }
            System.out.println("\n"+getNumberString(numberDigitsHexadecimal, digitsQuantity));
            System.out.println("Decimal: "+hexadecimalToDecimal(numberDigitsHexadecimal, digitsQuantity));
            System.out.println("Binary: "+hexadecimalToBinary(numberDigitsHexadecimal, digitsQuantity));
        }
    }

    /**
    * Description: This method allows us to get an string with the digits we had already wrote. This allows an integer array so it works for decimal and binary systems.</br>
    * @param <number> <int[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <stringNumber> <String>, this is the one that is given by the method and it is a string with the digits --> return
    */

    public static String getNumber(int[] number, int digitsQuantity){

        String stringNumber = "";

        for(int i=0; i<digitsQuantity; i++){
            stringNumber += number[i];
        }

        return stringNumber;
    }

    /**
    * Description: This method allows us to get an string with the digits we had already wrote. This allows a string array so it works for hexadecimal system.</br>
    * @param <number> <int[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <stringNumber> <String>, this is the one that is given by the method and it is a string with the digits --> return
    */

    public static String getNumberString(String[] number, int digitsQuantity){

        String stringNumber = "";

        for(int i=0; i<digitsQuantity; i++){
            stringNumber += number[i];
        }

        return stringNumber;
    }

    /**
    * Description: This method validates that all the digits that the user entered are decimals.</br>
    * @param <numberDigitsDecimal> <int[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <valid> <boolean>, This is the return, will be true if the number is decimal and a false if not. --> return
    */

    public static boolean validateDecimal(int[] numberDigitsDecimal, int digitsQuantity){

        boolean valid = false;

        for(int i=0;i<digitsQuantity;i++){
            if(numberDigitsDecimal[i]<0 || numberDigitsDecimal[i]>9){
                valid = false;
                i = digitsQuantity;
            }
            else{
                valid = true;
            }
        }
        
        return valid;
    }

    /**
    * Description: This method validates that all the digits that the user entered are binaries.</br>
    * @param <numberDigitsBinary> <int[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <valid> <boolean>, This is the return, will be true if the number is decimal and a false if not. --> return
    */

    public static boolean validateBinary(int[] numberDigitsBinary, int digitsQuantity){
        boolean valid = false;
        for(int i=0; i<digitsQuantity; i++){
            if (numberDigitsBinary[i]!= 0 && numberDigitsBinary[i]!= 1){
                valid = false;
                i = digitsQuantity;
            }
            else{
                valid = true;
            }
        }
        
        return valid;
    }

    /**
    * Description: This method validates that all the digits that the user entered are hexadecimals.</br>
    * @param <numberDigitsHexadecimal> <String[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <valid> <boolean>, This is the return, will be true if the number is decimal and a false if not. --> return
    */

    public static boolean validateHexadecimal(String[] numberDigitsHexadecimal, int digitsQuantity){
        boolean valid=false;

        for(int i=0; i<digitsQuantity; i++){
            numberDigitsHexadecimal[i] = numberDigitsHexadecimal[i].toUpperCase();
        }
        
        for(int i=0; i<digitsQuantity; i++){
            if (numberDigitsHexadecimal[i].equals("0")==false && numberDigitsHexadecimal[i].equals("1")==false && numberDigitsHexadecimal[i].equals("2")==false && numberDigitsHexadecimal[i].equals("3")==false && numberDigitsHexadecimal[i].equals("4")==false && numberDigitsHexadecimal[i].equals("5")==false && numberDigitsHexadecimal[i].equals("6")==false && numberDigitsHexadecimal[i].equals("7")==false && numberDigitsHexadecimal[i].equals("8")==false && numberDigitsHexadecimal[i].equals("9")==false && numberDigitsHexadecimal[i].equals("A")==false && numberDigitsHexadecimal[i].equals("B")==false && numberDigitsHexadecimal[i].equals("C")==false && numberDigitsHexadecimal[i].equals("D")==false && numberDigitsHexadecimal[i].equals("E")==false && numberDigitsHexadecimal[i].equals("F")==false){
                valid = false;
                i = digitsQuantity;
            }
            else{
                valid = true;
            }
        }
        
        return valid;
    }

    /**
    * Description: This method coverts a decimal number to a binary one..</br>
    * @param <numberDigitsDecimal> <int[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <binaryNumber> <long>, This is the return, and it is the value of the decimal number converted to binary. --> return
    */


    public static long decimalToBinary(int[] numberDigitsDecimal , int digitsQuantity){

        int exp, decimalNumber=0;
        long binaryNumber=0;

        for(int i=0; i<digitsQuantity;i++){
            exp = (digitsQuantity-1) - i;
            decimalNumber += numberDigitsDecimal[i] * Math.pow(10,exp);
        }

        
        int i = 0;

        while(decimalNumber>0){
            binaryNumber += (decimalNumber%2)*Math.pow(10,i);    
            decimalNumber = decimalNumber/2;
            i++;
        }

        return binaryNumber;
    }

    /**
    * Description: This method coverts a decimal number to a hexadecimal one.</br>
    * @param <numberDigitsDecimal> <int[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <hexadecimalNumber> <String>, This is the return, and it is the value of the decimal number converted to hexadecimal. --> return
    */

    public static String decimalToHexadecimal(int[] numberDigitsDecimal , int digitsQuantity){

        String[] hexadecimals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        int exp, decimalNumber=0;
        String hexadecimalNumber="";

        for(int i=0; i<digitsQuantity;i++){
            exp = (digitsQuantity-1) - i;
            decimalNumber += numberDigitsDecimal[i] * Math.pow(10,exp);
        }


        int  count=0, remainder;

        String[] hexadecimalArray = new String[40];
        
        while(decimalNumber>0){
            remainder = decimalNumber%16;
            hexadecimalArray[count] = hexadecimals[remainder];
            decimalNumber = decimalNumber/16;
            count++;
        }

    
        for(int j=count-1; j>=0; j--){
            hexadecimalNumber += hexadecimalArray[j];
        }

        return hexadecimalNumber;

    }

    /**
    * Description: This method coverts a binary number to a decimal one.</br>
    * @param <numberDigitsBinary> <int[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <decimalNumber> <long>, This is the return, and it is the value of the binary number converted to decimal. --> return
    */

    public static long binaryToDecimal(int[] numberDigitsBinary , int digitsQuantity){

        int exp, binaryNumber=0; 
        long decimalNumber=0;
        
        for(int i=0; i<digitsQuantity;i++){
            exp = (digitsQuantity-1) - i;
            binaryNumber += numberDigitsBinary[i] * Math.pow(10,exp);
        }

        int digit, i=0;
        
        while(binaryNumber>0){
            digit = binaryNumber % 10;
            decimalNumber += digit * Math.pow(2, i);
            binaryNumber = binaryNumber / 10;
            i++;
        }

        return decimalNumber;
    }

    /**
    * Description: This method coverts a hexadecimal number to a decimal one.</br>
    * @param <numberDigitsHexadecimal> <String[]>, Means the array whith the digits that the user entered by console.--> 
    * @param <digitsQuantity> <int>, Means the quuantity of digits.--> 
    * @return <decimalNumber> <long>, This is the return, and it is the value of the hexadecimal number converted to decimal. --> return
    */

    public static long hexadecimalToDecimal(String[] numberDigitsHexadecimal , int digitsQuantity){

        String[] hexadecimals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        int digit=0;

        long decimalNumber=0;

        int exp = 0;

        for (int i = digitsQuantity-1; i>=0 ; i--){
            for(int j=0; j<16;j++){
                if(numberDigitsHexadecimal[i].equalsIgnoreCase(hexadecimals[j])){
                    digit = j;
                    j=16;
                }
            }
            decimalNumber += digit*Math.pow(16,exp); 
            exp++;
        }

    return decimalNumber;
    }

    /**
     * 
     * @param numberDigitsBinary
     * @param digitsQuantity
     * @return
     */

    public static String binaryToHexadecimal(int[] numberDigitsBinary , int digitsQuantity){
        
        long decimalNumber;
        String hexadecimalNumber="";

        decimalNumber = binaryToDecimal(numberDigitsBinary, digitsQuantity);
        long aux = decimalNumber;
   

        int size=0;

        while(aux!=0){
            aux = aux/10;
            size++;
        }

        int[] decimalArray = new int[size];

        for(int i = size-1; i>=0; i--){
            decimalArray[i] = (int)decimalNumber%10;
            decimalNumber = decimalNumber/10;
        }

        hexadecimalNumber = decimalToHexadecimal(decimalArray, size);
        

        return hexadecimalNumber;
    }

    /**
     * This method converts an hexadicimal to a binary.
     * @param numberDigitsHexadecimal
     * @param digitsQuantity
     * @return
     */

    public static long hexadecimalToBinary(String[] numberDigitsHexadecimal , int digitsQuantity){
        
        long decimalNumber;
        long binaryNumber;

        decimalNumber = hexadecimalToDecimal(numberDigitsHexadecimal, digitsQuantity);
        long aux = decimalNumber;
   
        int size=0;

        while(aux!=0){
            aux = aux/10;
            size++;
        }

        int[] decimalArray = new int[size];

        for(int i = size-1; i>=0; i--){
            decimalArray[i] = (int)decimalNumber%10;
            decimalNumber = decimalNumber/10;
        }

        binaryNumber = decimalToBinary(decimalArray, size);
        

        return binaryNumber;
    }



    /**
     * This method initializes the binaryCalculator
     */

    public static void binaryCalculator(){
        System.out.println("Write the number of digits in the first binary: ");
        int digitsQuantity1 = sc.nextInt();

        System.out.println("Write the number of digits in the second binary: ");
        int digitsQuantity2 = sc.nextInt();

        int digit;

        int[] binary1 = new int[digitsQuantity1];
        int[] binary2 = new int[digitsQuantity2];

        System.out.println("\n");

        for(int i = 0; i<digitsQuantity1; i++){
            System.out.println("Write the digit number "+(i+1)+" of your binary 1: ");
            digit = sc.nextInt();
            binary1[i] = digit;
        }

        System.out.println("\n");

        for(int i = 0; i<digitsQuantity2; i++){
            System.out.println("Write the digit number "+(i+1)+" of your binary 2: ");
            digit = sc.nextInt();
            binary2[i] = digit;
        }

        

        if(validateBinary(binary1 , digitsQuantity1) && validateBinary(binary2 , digitsQuantity2)){
            System.out.println("\n1. Sum");
            System.out.println("\n2. Subtraction ");
            System.out.println("\n3. Multiplication");
            System.out.println("\n4. Divition");
        
            System.out.println("\nChoose an operation: ");
            int operation = sc.nextInt();

 
            
            switch(operation){
                case 1:
                    System.out.println("The sum is: "+binarySum(binary1,binary2, digitsQuantity1, digitsQuantity2));
                    break;
                case 2:
                    System.out.println("La resta es: "+binaryRest(binary1,binary2, digitsQuantity1, digitsQuantity2));
                    break;
                case 3:
                    System.out.println("La multiplicacion es: "+binaryMult(binary1,binary2, digitsQuantity1, digitsQuantity2));
                    break;
                case 4:
                    binaryDiv(binary1,binary2,digitsQuantity1, digitsQuantity2);
                    break;
                default:
                    while(operation!=1 && operation!=2 && operation!=3 && operation!=4){
                        System.out.println("Choose a valid option: ");
                        operation = sc.nextInt();

                        if(operation==1){
                            System.out.println("La suma es: "+binarySum(binary1,binary2, digitsQuantity1, digitsQuantity2));
                        }
                        else if(operation==2){
                            System.out.println("La resta es: "+binaryRest(binary1,binary2, digitsQuantity1, digitsQuantity2));
                        }
                        else if(operation==3){
                            System.out.println("La multiplicacion es: "+binaryMult(binary1,binary2, digitsQuantity1, digitsQuantity2));
                        }
                        else if(operation==4){
                            binaryDiv(binary1,binary2,digitsQuantity1, digitsQuantity2);
                        }
                    break;
                }
            }     
        }
        else{
            while(validateBinary(binary1 , digitsQuantity1)==false || validateBinary(binary2 , digitsQuantity2)==false){

                System.out.println("\n");
                System.out.println("Write the numbers accordig to the numbering system.");
                System.out.println("\n");

                //Pide los digitos
                for(int i = 0; i<digitsQuantity1; i++){
                    System.out.println("Write the digit number "+(i+1)+" of your binary 1: ");
                    digit = sc.nextInt();
                    binary1[i] = digit;
                }

                System.out.println("\n");

                for(int i = 0; i<digitsQuantity2; i++){
                    System.out.println("Write the digit number "+(i+1)+" of your binary 2: ");
                    digit = sc.nextInt();
                    binary2[i] = digit;
                }

                System.out.println("\n");

            }

            System.out.println("\n1. Sum");
            System.out.println("\n2. Subtraction ");
            System.out.println("\n3. Multiplication");
            System.out.println("\n4. Divition");

            System.out.println("\nChoose an operation: ");
            int operation = sc.nextInt();
            
            switch(operation){
                case 1:
                    System.out.println("La suma es: "+binarySum(binary1,binary2, digitsQuantity1, digitsQuantity2));
                    break;
                case 2:
                    System.out.println("La resta es: "+binaryRest(binary1,binary2, digitsQuantity1, digitsQuantity2));
                    break;
                case 3:
                    System.out.println("La multiplicacion es: "+binaryMult(binary1,binary2, digitsQuantity1, digitsQuantity2));
                    break;
                case 4:
                    binaryDiv(binary1,binary2, digitsQuantity1, digitsQuantity2);
                    break;

                default:
                    while(operation!=1 && operation!=2 && operation!=3 && operation!=4){
                        System.out.println("Choose a valid option: ");
                        operation = sc.nextInt();

                        if(operation==1){
                            System.out.println("La suma es: "+binarySum(binary1,binary2, digitsQuantity1, digitsQuantity2));
                        }
                        else if(operation==2){
                            System.out.println("La resta es: "+binaryRest(binary1,binary2, digitsQuantity1, digitsQuantity2));
                        }
                        else if(operation==3){
                            System.out.println("La multiplicacion es: "+binaryMult(binary1,binary2, digitsQuantity1, digitsQuantity2));
                        }
                        else if(operation==4){
                            binaryDiv(binary1,binary2, digitsQuantity1, digitsQuantity2);
                        }
                    break;
                }
            }
        }    
    }

    /**
     * This method sum two binaries
     * @param binary1
     * @param binary2
     * @param digitsQuantity1
     * @param digitsQuantity2
     * @return
     */

    public static String binarySum(int[] binary1 , int[] binary2, int digitsQuantity1, int digitsQuantity2){

        char carry='0';
	
		String sum="";


        
		int max=0;
		
		int position1=digitsQuantity1;
		int position2=digitsQuantity2;


		if (digitsQuantity1 < digitsQuantity2){
			max=digitsQuantity2;
		}
		if(digitsQuantity1>=digitsQuantity2){
			max=digitsQuantity1;
		}

		for(int i=0; i<max;i++){
			if (position1>0 && position2>0){
				if (binary1[position1-1]==0 && binary2[position2-1]==0){
					if(carry=='0'){
						sum="0"+sum;
					}
                    else if(carry=='1'){
						sum="1"+sum;
						carry='0';
					}
					
				}
				if((binary1[position1-1]==1 && binary2[position2-1]==0)||(binary1[position1-1]==0 && binary2[position2-1]==1)){
					if(carry=='0'){
						sum="1"+sum;
					}
                    else if(carry=='1'){
						carry='1';
						sum="0"+sum;
					}
				}
				if (binary1[position1-1]==1 && binary2[position2-1]==1){
					if(carry=='0'){
						carry='1';
						sum="0"+sum;
						
					}else if(carry=='1'){
						
						sum="1"+sum;
						carry='1';
					}	
				}
				position1--;
				position2--;
            }
			if (position1>0 && position2==0){
				
				if (binary1[position1-1]==0){
					if(carry=='0'){
						sum="0"+sum;
					}
                    else{
						carry='0';
						sum="1"+sum;
					}				
				}
				if (binary1[position1-1]==1){
					if(carry=='0'){
						sum="1"+sum;
					}
                    else{
						carry='1';
						sum="0"+sum;
					}
				}	
				position1--;
			}
			if (position2>0 && position1==0){
				if (binary2[position2-1]==0){
					if(carry=='0'){
						sum="0"+sum;	
					}
                    else{
						sum="1"+sum;
					}	
				}
				if (binary2[position2-1]==1){
					if(carry=='0'){
						sum="1"+sum;	
					}
                    else{
						carry='1';
						sum="0"+sum;
					}						
				}				
				position2--;
			}		
		}
		if (carry=='1'){
			sum = carry+sum;
		}

        return sum;
    }

    /**
    * Description: This method is the one we use to rest two binary numbers..</br>
    * @param <binary1> <int[]>, Means the array whith the digits that the user entered by console of the first number.--> 
    * @param <binary2> <int[]>, Means the array whith the digits that the user entered by console of the second number.-->
    * @param <digitsQuantity1> <int>, Means the amount of digits that the first binary.-->
    * @param <digitsQuantity2> <int>, Means the amount of digits that the second binary--> 
    * @return <rest> <String>, This is the one that is given by the method and it is the rest of the binaries.--> return
    */

    public static String binaryRest(int[] binary1 , int[] binary2, int digitsQuantity1, int digitsQuantity2){
        char carry='0';
	
		String rest="";

		int position1=digitsQuantity1;
		int position2=digitsQuantity2;
        
		int max=0;
		

		if (digitsQuantity1 < digitsQuantity2){
			max=digitsQuantity2;
		}
		if(digitsQuantity1>=digitsQuantity2){
			max=digitsQuantity1;
		}

		for(int i=0; i<max;i++){

			if (position1>0 && position2>0){
				if (binary1[position1-1]==0 && binary2[position2-1]==0){
					if(carry=='0'){
						rest='0'+rest;
					}

                    else if(carry=='1'){
						rest="1"+rest;
						carry='0';
					}
					
				}

				if(binary1[position1-1]==1 && binary2[position2-1]==0){
					if(carry=='0'){
						rest="1"+rest;
					}

                    else if(carry=='1'){
						carry='1';
						rest="1"+rest;
					}
                }

                if(binary1[position1-1]==0 && binary2[position2-1]==1){
                    if(carry=='0'){
                        carry='1';
                        rest="0"+rest;
                    }
    
                    else if(carry=='1'){
                        carry='0';
                        rest="0"+rest;
                    }
				}
				
				if (binary1[position1-1]==1 && binary2[position2-1]==1){
					if(carry=='0'){
						rest="0"+rest;
						
					}
                    
                    else if(carry=='1'){
						rest="0"+rest;
						carry='1';
					}
					
				}
				position1--;
				position2--;
			}

			if (position1>0 && position2==0){
				
				if (binary1[position1-1]==0){
					if(carry=='0'){
						rest="0"+rest;
						
					}
                    else{
						carry='0';
						rest="1"+rest;
					}
				}

				if (binary1[position1-1]==1){
					if(carry=='0'){
						rest="1"+rest;
						
					}
                    else{
						carry='1';
						rest="1"+rest;
					}
						
				}
				
				position1--;
			}

			if (position2>0 && position1==0){
				if (binary2[position2-1]==0){
					if(carry=='0'){
						rest="0"+rest;
						
					}
                    else{
						rest="1"+rest;
                        carry='0';
					}
						
					
				}
				if (binary2[position2-1]==1){
					if(carry=='0'){
						rest="1"+rest;	
					}

                    else{
						carry='1';
						rest="1"+rest;
					}
						
				}
				
				position2--;
			}
					
		}

		if (carry=='1'){
			rest = carry+rest;
		}  

        return rest;
    }
    

    public static String binaryMult(int[] binary1 , int[] binary2, int digitsQuantity1, int digitsQuantity2){

        String[] sumsArray = new String[100];

        int x=0, exp=0;

        System.out.println("");

        for(int i=digitsQuantity2-1;i>=0;i--){
            sumsArray[x] = "";
            for(int j=digitsQuantity1-1;j>=0;j--){
                sumsArray[x] = (binary1[j]*binary2[i]) + sumsArray[x];
            }
            System.out.println(sumsArray[x]);
            exp = 0;
            x++;
        }

        int c=0;

        System.out.println("");

        for(int i=0; i<sumsArray.length; i++){
            if(sumsArray[i]!=null){
                for(int j=0; j<c; j++){
                    sumsArray[i] += "0";
                }
                System.out.println(sumsArray[i]);
                c++;
            }
        }

        String firstNumber, secondNumber, mult="";
        char carry='0';
        int position1, position2, max;
	

        for(int i=0; i<sumsArray.length; i++){
            if(sumsArray[i]!=null){
                firstNumber = sumsArray[i];
                for(int j=i+1;j<sumsArray.length;j++){
                    if(sumsArray[j]!=null){
                        secondNumber = sumsArray[j];

                        if (firstNumber.length() < secondNumber.length()){
                            max=secondNumber.length();
                        }
                        else{
                            max=firstNumber.length();
                        }

                        position1 = firstNumber.length();
                        position2 = secondNumber.length();

                        for(int k=0; k<max; i++){
                            if (position1>0 && position2>0){
                                if (firstNumber.substring(position1-1, position1).equals("0") && secondNumber.substring(position2-1, position2).equals("0")){
                                    if(carry=='0'){
                                        mult="0"+mult;
                                    }
                                    else if(carry=='1'){
                                        mult="1"+mult;
                                        carry='0';
                                    }
                                    
                                }
                                else if((firstNumber.substring(position1-1, position1).equals("1") && secondNumber.substring(position2-1, position2).equals("0")) || (firstNumber.substring(position1-1, position1).equals("0") && secondNumber.substring(position2-1, position2).equals("1"))){
                                    if(carry=='0'){
                                        mult="1"+mult;
                                    }
                                    else if(carry=='1'){
                                        carry='1';
                                        mult="0"+mult;
                                    }
                                }
                                else if (firstNumber.substring(position1-1, position1).equals("1") && secondNumber.substring(position2-1, position2).equals("1")){
                                    if(carry=='0'){
                                        carry='1';
                                        mult="0"+mult;
                                        
                                    }else if(carry=='1'){
                                        
                                        mult="1"+mult;
                                        carry='1';
                                    }	
                                }
                                position1--;
                                position2--;
                            }
                            else if (position1>0 && position2==0){
                                
                                if (firstNumber.substring(position1-1, position1).equals("0")){
                                    if(carry=='0'){
                                        mult="0"+mult;
                                    }
                                    else{
                                        carry='0';
                                        mult="1"+mult;
                                    }				
                                }
                                else if (firstNumber.substring(position1-1, position1).equals("1")){
                                    if(carry=='0'){
                                        mult="1"+mult;
                                    }
                                    else{
                                        carry='1';
                                        mult="0"+mult;
                                    }
                                }	
                                position1--;
                            }
                            else if (position2>0 && position1==0){
                                if (secondNumber.substring(position2-1, position2).equals("0")){
                                    if(carry=='0'){
                                        mult="0"+mult;	
                                    }
                                    else{
                                        mult="1"+mult;
                                    }	
                                }
                                else if (secondNumber.substring(position2-1, position2).equals("1")){
                                    if(carry=='0'){
                                        mult="1"+mult;	
                                    }
                                    else{
                                        carry='1';
                                        mult="0"+mult;
                                    }						
                                }				
                                position2--;
                            }
                        }

                        i = j+1;
                        j = sumsArray.length;
                    }
                }

            }
        }


        return mult;
    }

    public static String binaryDiv(int[] binary1 , int[] binary2, int digitsQuantity1, int digitsQuantity2){
        String[] binary1String = new String[digitsQuantity1];
        String[] binary2String = new String[digitsQuantity2];

        String div = "";

        for(int i=0; i<digitsQuantity1; i++){
            binary1String[i] = binary1[i]+"";
        }

        for(int i=0; i<digitsQuantity2; i++){
            binary2String[i] = binary2[i]+"";
        }
        return div;
    }


    public static void main(String[] args){
        System.out.println("Hi! Welcome to the program. What functionality do you want to use?");
        menu();
    }
}