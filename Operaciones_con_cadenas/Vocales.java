public class Vocales {
    public static void main(String[] args){
        String palabra = "carro";
        int longitud = palabra.length();
        String primera = palabra.substring(0,1).toLowerCase();
        String ultima = palabra.substring(longitud-1).toLowerCase();

        System.out.println(primera);
        System.out.println(ultima);

        if (primera.equals("a") || primera.equals("e") || primera.equals("i") || primera.equals("o") || primera.equals("u")){
            System.out.println("La primera letra es una vocal.");
        }
        else{
            System.out.println("La primera letra no es una vocal.");
        }

        if (ultima.equals("a") || ultima.equals("e") || ultima.equals("i") || ultima.equals("o") || ultima.equals("u")){
            System.out.println("La ultima letra es una vocal.");
        }
        else{
            System.out.println("La ultima letra no es una vocal.");
        }
    }
}