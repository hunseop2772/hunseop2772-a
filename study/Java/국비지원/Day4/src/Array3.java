public class Array3 {
    public static void main(String[] args) {

        int[][] num = {{10,20,30},{40,50,60}};
        for(int i=0; i<num.length;i++){
            for(int j=0; j<num[i].length;j++){
                System.out.print(num[i][j]+ " ");
            }
            System.out.println(); //j for문 1회(i행에 속하는) 반복 끝날시 엔터
        }
    }
}
