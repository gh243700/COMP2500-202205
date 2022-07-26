package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {

    private OverflowException overflowExceptionOrNull;
    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }
    @Override
    public boolean deposit(int amount) {
        int value = getAmount();
        if (value > value + amount) {
            overflowExceptionOrNull = new OverflowException("amount overflow");
            throw overflowExceptionOrNull;
        }

        return super.deposit(amount);
    }

    @Override
    public boolean withdraw(int amount) {
        if (overflowExceptionOrNull != null) {
            throw overflowExceptionOrNull;
        }
        return super.withdraw(amount);
    }
}
