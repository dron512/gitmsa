//@NoArgsConstructor
//@AllArgsConstructor
public class Person {

    private String jumin;
    private String passport;

    public Person() {
    }

    public Person(String jumin) {
        this();
        this.jumin = jumin;
    }

    public Person(String jumin, String passport) {
//        this.jumin = jumin;
        this(jumin);
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "jumin='" + jumin + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }

    public void show(){
        System.out.println("jumin= "+jumin);
        System.out.println("passport= "+passport);
    }
}

