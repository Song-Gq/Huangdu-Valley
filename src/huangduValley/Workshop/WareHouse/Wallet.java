package huangduValley.Workshop.WareHouse;

import huangduValley.Stdout;

public class Wallet {
    private double balance;

    private Wallet() {
        balance = 1000;
    }

    private static class WalletHolder {
        private static final Wallet INSTANCE = new Wallet();
    }

    public static Wallet getInstance() {
        return WalletHolder.INSTANCE;
    }

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double number) {
        balance += number;
        Stdout.print(this, "The balance of wallet increase " + number);
    }

    public boolean decreaseBalance(double number) {
        if (balance >= number) {
            balance -= number;
            Stdout.print(this, "The balance of wallet decrease " + number);
            return true;
        }
        else {
            return false;
        }
    }
}
