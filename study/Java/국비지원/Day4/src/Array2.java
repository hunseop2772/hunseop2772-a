public class Array2 {//2차원 배열

    public static void main(String[] args) {
        int [][] arr = new int[2][3];

        for(int i=0; i<arr.length;i++){//2차원 배열의 length 앞에있는것으로 확인 : !!행!!
            //arr후에 있는 개수 만큼 2개
            System.out.println("🎈i의 값 : "+i);
            for(int j=0;j<arr[i].length;j++){//셀
                //arr[i] 다음에 있는 arr[i][j] 에서 [j]의 갯수 3만큼 렌스적용
                System.out.println("🎆j의 값 : "+j);
                arr[i][j] = i+j;
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
