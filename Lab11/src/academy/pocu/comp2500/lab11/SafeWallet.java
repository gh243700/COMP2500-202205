package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }
    @Override
    public boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }
        int value = getAmount();
        if (value > value + amount) {
            throw new OverflowException("amount overflow");
        }

        return super.deposit(amount);
    }
}
