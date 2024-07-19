package org.example;
/*
 다 하신분은 프로그래머스 푸시면 됩니다.

 다음 클래스 각각에 적절한 생성자를 삽입해보자. 물론 상속 관계를 고려하여 각 클래스 별로
 필요한 생성자를 삽입해야 한다.
 */
public class Car {
    int gasolineGauge;
}

class HybridCar extends Car{
    int electricGauge;
}

class HybridWaterCar extends HybridCar{
    int waterGauge;
    public void showCurrentGauge(){
        System.out.println("잔여 가솔린 "+gasolineGauge);
        System.out.println("잔여 전기량 "+electricGauge);
        System.out.println("잔여 워터량 "+waterGauge);
    }
}

/*
Car는 가솔린으로 동작하는 자동차를 표현한 것이고, HybridCar는 가솔린과 전기로 동작하는
자동차를 표현한 것이다. 그리고 HybridWaterCar는 가솔린과 전기뿐 아니라, 물도 동시에
연료로 사용할 수 있는 꿈의 자동차를 표현한 것이다. 그러나 이 문제는 위의 클래스들이
의미하는 바를 몰라도 해결이 가능하다.

 */