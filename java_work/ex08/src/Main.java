public class Main {
    public static void doA(){
        int i = 0;
        while (i < 10) {
            int j = 0;
            while (j <= i) {
                j++;
                System.out.print("*");  // 줄바꿈없이 * 출력해라
            }
            System.out.println();   // 줄빠꿈해라...
            i++;
        }
    }

    public static void main(String[] args) {
        /*
            i=0 일때 j가 0~ 0이하까지 => 1번
            i=1 일때 j가 0~ 1이하까지 => 2번
            i=2 일때 j가 0~ 2이하까지 => 3번
            i=3일때 j가 0~3이하까지 => 0,1,2,3 4번
            ...
            ctrl + alt + l 자동정렬
         */
        doA();
        doA();
        doA();
    }
}