public class Aumento{
    public static void main(String[] args){
        int x = 5;
        int z = x++;

        System.out.println("x++   z: "+z+" x: "+x);

        x = 5;
        z = ++x;

        System.out.println("++x   z: "+z+" x: "+x);

        x = 5;
        z = x--;

        System.out.println("x--   z: "+z+" x: "+x);

        x = 5;
        z = --x;

        System.out.println("--x   z: "+z+" x: "+x);
    }
}