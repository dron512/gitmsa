public class Ex05 {

    public static void main(String[] args) {

        String str = "안녕하세요 박명회 선생님입니다.";
//        String[] tempstr = str.split("\\|");
        String[] tempstr = str.split(" ");

        System.out.println(tempstr[0]);
        System.out.println(tempstr[1]);
        System.out.println(tempstr[2]);

        for (int i = 0; i < tempstr.length; i++) {
            System.out.println(tempstr[i]);
        }

        String a = "abcdefgh";
        System.out.println(a.length());

        System.out.println(a.charAt(0));
        System.out.println(a.charAt(1));
        System.out.println(a.charAt(2));
        System.out.println(a.charAt(3));

        System.out.println( a.substring(2) );
        System.out.println( a.substring(2,5) );
        System.out.println( a.toUpperCase() );
        System.out.println("cd를 포함하냐 = "+a.contains("cd"));

        //
        System.out.println("배열출력시작");
        char[] test = "테스트".toCharArray();
        for (int i = 0; i < test.length; i++) {
            System.out.println("test["+i+"]="+test[i]);
//            System.out.printf("test[%s]="+test[i]);
        }
        System.out.println("배열출력끝");

        test[2] = 'A';
        char qwer[] = {'A','B','C'};
        // String 으로 바꾸고 싶어.. String c = "ABC";
        System.out.println(qwer[0]);
        System.out.println(qwer[1]);
        System.out.println(qwer[2]);

        String testStr = new String(qwer);
        System.out.println(testStr);

        int[] b = new int[3];
        System.out.println(b.length);

        // oracle??






















    }
}

