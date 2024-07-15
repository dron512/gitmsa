// f6
class Circle {
    private int rad;
    private String name;

    public Circle(int rad) {
        this.rad = rad;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.equals("")) {
            this.name = "홍길동";
            return;
        }
        this.name = name;
    }
    public int getRad() {
        return rad;
    }
    public void setRad(int rad) {
        if (rad < 0) {
            rad = 0;
            return;
        }
        this.rad = rad;
    }

    public double getArea(){
        return 3.14*rad*rad;
    }
}
