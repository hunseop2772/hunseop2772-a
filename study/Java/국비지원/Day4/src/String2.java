public class String2 { //String 함수들
    public static void main(String[] args) {
        String str1 = new String("Java");
        String str2 = new String("Programming");
        System.out.println(str1);
        System.out.println(str2);

        //concat() : 문자열과 문자열을 연결
        System.out.println(str1.concat(str2)); // 1번
        String temp = str1.concat(str2);// 2번
        System.out.println(temp);
        System.out.println(str1 + str2);//3번

        // indexOf() : 원하는 문자열을 찾아 해당하는 문자열의 index를 반환
        System.out.println(str2.indexOf("P"));//Programming 주소 값 P -> 0
        System.out.println(str2.indexOf("p"));// 원하는 주소가 없으면 -1이 나온다.
        System.out.println(str2.indexOf("gra"));// 첫 번째 자리의 주소만 출력된다.
        System.out.println(str2.indexOf("r",3));//(ch,int) int는 시작점을 의미한다.
        // 위 문장은 주소 3부터 시작하여 r을 찾는다.

        // trim() : 문자열의 앞뒤 공백을 제거
        String str3 = new String("     자바     ");
        System.out.println("👍"+str3+"👍");
        System.out.println("👍"+str3.trim()+"👍");

        // toLowerCase() : 소문자로 변환, toUpperCase() : 대문자로 변환
        System.out.println(str2.toLowerCase());
        System.out.println(str2.toUpperCase());
        //if(eventkey.toLowerCase() == q)

        //length() : 문자열의 길이를 변환
        System.out.println(str2.length());//11

        // ✔ substring() : 원하는 문자를 추출
        System.out.println(str2.substring(3));//문자열 3부터 끝까지 추출
        //programming -> gramming
        temp = str2.substring(3);
        System.out.println(temp);
        System.out.println(str2.substring(3,7));//3부터 7-1까지 (뒤에 있는 숫자 직전까지)

        //문자열을 숫자로 변환
        String str4 ="100";
        int i=200;
        System.out.println(str4+i);//100200
        //Integer.parseInt() 숫자형태로 있는 문자열을 정수로 변경한다.
        System.out.println(Integer.parseInt(str4)+i);

    }
}
