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
        int before = getAmount();
        if (!super.deposit(amount)) {
            return false;
        }

        if (getAmount() < before) {
            overflowExceptionOrNull = new OverflowException("amount overflow");
            throw overflowExceptionOrNull;
        }

        return true;
    }

    @Override
    public boolean withdraw(int amount) {
        if (overflowExceptionOrNull != null) {
            throw overflowExceptionOrNull;
        }
        return super.withdraw(amount);
    }
}
