public class Inform2 {
    public static void main(String[] args) {
        int j, i = 0;
        for (j = 0; i <= 5; i++) {
            j+=i;
            System.out.print(i);
            if(i==5){
                System.out.print("=");
                System.out.print(j);
            }
                 else System.out.print("+");
        }

    }
}
