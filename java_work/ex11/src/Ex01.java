/*
    3. 필자가 좋아하는 것 중 하나가 금요일 저녁 퇴근길에 DVD나 만화책을 잔뜩 빌리고,
    동네 슈퍼에 들러서 군것질거리를 사 가지고 집에 들어가는 것이다.
    오늘은 금요일이다. 현재 필자의 주머니에는 5천 원이 있다.
    DVD 한 편을 빌리면 3,500원이 남는다.
    슈퍼에 들려서 크림빵(500원), 새우깡(700원), 콜라(400원)를 사려한다.
    잔돈을 하나도 남기지 않고 이 세 가지 물건을 하나 이상 반드시 구매하려면
    어떻게 구매를 진행해야 하겠는가? 물론 여기에는 여러 가지 경우의 수가 있을 것이다.
 */

public class Ex01 {

    public static void main(String[] args) {
        int total = 5000;
        System.out.println("DVD한편 빌려서 3500원");
        total = 3500;

        int cri = 500;
        int sa = 700;
        int coke = 400;

        total = total - (cri + sa + coke);
        System.out.println(total);

        System.out.println("3500원으로는 ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    if (1900 == (cri * i + sa * j + coke * k)) {
                        System.out.println(" i= "+i+" j= "+j+" k= "+k);
                        System.out.print("크림빵은 "+ (1+i)+ " 개 ");
                        System.out.print("새우깡은 "+ (1+j)+" 개 ");
                        System.out.println("콜라는 "+ (1+k)+"개 살 수 있다.");
                    }
                }
            }
        }




    }

}
