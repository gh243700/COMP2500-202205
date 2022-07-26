package academy.pocu.comp2500.lab11.app;

import academy.pocu.comp2500.lab11.App;
import academy.pocu.comp2500.lab11.MyInteger;
import academy.pocu.comp2500.lab11.SafeWallet;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;

import java.io.*;

public class Program {

    public static void main(String[] args) {
        // write your code here
        /*
        Wallet wallet;
        try {
            wallet = new SafeWallet(new User());
        } catch (Exception e) {
            System.out.println("ssss");
            return;
        }
        wallet.deposit(Integer.MAX_VALUE - 1);
*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);
        PrintStream errStream = new PrintStream(System.out);
        App app = new App();
        app.run(reader, printStream, errStream);

        System.out.printf("");

    }
}
