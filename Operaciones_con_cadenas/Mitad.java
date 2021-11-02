public class Mitad {
    public static void main(String[] args){
        String palabra = "carro";
        int longitud = palabra.length();
        String mitad = palabra.substring(longitud/2,longitud/2+1);
        System.out.println(mitad);
    }
}
