public class Operate5 {
    public static void main(String[] args) {
        int var1 = 10, var2 = 3;
        boolean result = var1 > var2; //1
        boolean result2 = var1 <= var2;//0
        boolean result3 = result && result2;//0
        boolean result4 = result || result2;//1
        boolean result5 = !result;//0

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

    }
}
