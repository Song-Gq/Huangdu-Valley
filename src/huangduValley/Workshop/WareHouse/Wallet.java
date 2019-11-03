package huangduValley.Workshop.WareHouse;

public class Wallet {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double number) {
        balance += number;
    }

    public boolean decreaseBalance(double number) {
        if (balance >= number) {
            balance -= number;
            return true;
        }
        else {
            return false;
        }
    }
}
