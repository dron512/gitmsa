import aa.CirCle;

public class Ex05 {

    public static void main(String[] args) {

        System.out.println(CirCle.PI);
        System.out.println(CirCle.a);

//        CirCle.doA();
//
//        System.out.println(CirCle.sum);

        CirCle c = new CirCle();

        c.do둘래();
        c.do넓이();

        int result = c.doA();
        System.out.println(result);

    }
}
