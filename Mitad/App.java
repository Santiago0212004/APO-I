public class App {
    public static void main(String[] args) throws Exception {
        String palabra = "palabra";
        int longitud = palabra.length();
        String mitad = palabra.substring(longitud/2,longitud/2+1);
        System.out.println(mitad);
    }
}
