package bank;

public class BankAccount {
    int num = 0;
    String name = "";

    BankAccount(String n){
        name = n;
    }

    public int cmb() {
        System.out.println("이름 "+name+" 잔액 " + num);
        return num;
    }

    public void deposit(int a) {
        num += a;
    }

    public void withdraw(int a){
        num -= a;
    }

}
