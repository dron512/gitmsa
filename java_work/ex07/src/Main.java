// shift + f10 현재 설정된 파일 실행
// ctrl + shift + f10 열려진 파일 실행

// ctrl + alt + l 자동정렬
// shift + delete 한줄삭제
// alt + 1 프로젝트 <<<경로
// alt + insert 파일 생성
// ctrl + e 최근 파일 찾기
// shift + shift 파일 찾기
// esc 키누르면 소스에 다시 들어와요...

public class Main {
    public static void main(String[] args) {

        /*
            1 + (1+2)+(1+2+3)...(1+2+3+4+...+10)
            의 결과를 출력하여라...

            i = 0일때 j가 0에서 0+1미만 반복해라
            i = 1일때 j가 0에서 1+1미만 반복해라
            i = 2일때 j가 0에서 2+1미만 반복해라
            i = 3일때 j가 0에서 3+1미만 반복해라
            i = 4일때 j가 0에서 4+1미만 반복해라
            ...
            i = 10일때 j가 0에서 10+1까지 반복해라
        */
        int sum = 0;

        for (int i = 0; i < 11; i++) {
            for (int j = 1; j < i+1; j++) {
                System.out.println("j = "+j);
                sum = sum+j;
            }
            System.out.println("sum = "+sum);
        }

        System.out.println("sum = "+sum);


    }
}










