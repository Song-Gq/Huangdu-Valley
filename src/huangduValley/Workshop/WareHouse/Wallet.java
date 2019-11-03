package huangduValley.Workshop.WareHouse;

public class Wallet {
    private double balance;

    private Wallet() {
        balance = 1000;
        System.out.println("Wallet create");
    }

    private static class WalletHolder {
        private static final Wallet INSTANCE = new Wallet();
    }

    public static Wallet getInstance() {
        System.out.println("Get Wallet instance");
        return WalletHolder.INSTANCE;
    }

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
