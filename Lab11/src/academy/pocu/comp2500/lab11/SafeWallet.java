package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }
    @Override
    public boolean deposit(int amount) {
        int value = getAmount();
        if (!super.deposit(amount)) {
            return false;
        }

        if (value > getAmount()) {
            throw new OverflowException("amount overflow");
        }

        return true;
    }
}
