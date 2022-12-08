public class Array4 {
    public static void main(String[] args) {
        String[] str = {"김사과", "바나나", "오렌지", "이메론"};

        for(int i =0; i < str.length;i++){
            System.out.print(str[i]+ " ");
        }
        System.out.println();

        for(String s: str){
            System.out.print(s+ " ");
        }
    }
}
