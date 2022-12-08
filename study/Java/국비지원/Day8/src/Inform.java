import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Inform {
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력 :");

        i =sc.nextInt();
        r(i);
        sc.close();
    }
    static int r(int n){
        int i;
        if(n<1)
            return 2;
        else{
            i = (2*r(n)) +1;
            System.out.println(i);
            return i;
            }

    }
}
