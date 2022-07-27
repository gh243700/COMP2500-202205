package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.Wallet;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {

    public void run(BufferedReader in, PrintStream out, PrintStream err) {
        WarehouseType warehouseType = getWarehouseTypeOrNull(in, out);
        if (warehouseType == null) {
            return;
        }
        Wallet wallet;
        try {
            wallet = new SafeWallet(new User());
        } catch (IllegalAccessException e) {
            err.printf("%s", "AUTH_ERROR");
            return;
        } catch (Exception e) {
            throw e;
        }

        try {
            buyProductFromWarehouse(wallet, warehouseType, in, out);
        } catch (OverflowException e) {
            throw e;
        }

    }

    private void buyProductFromWarehouse(Wallet wallet, WarehouseType warehouseType, BufferedReader in, PrintStream out) {

        Warehouse warehouse = new Warehouse(warehouseType);

        while (true) {
            out.printf("BALANCE: %d" + System.lineSeparator(), wallet.getAmount());
            out.printf("PRODUCT_LIST: Choose the product you want to buy!" + System.lineSeparator());
            ArrayList<Product> initProducts = warehouse.getProducts();
            for (int i = 0; i < initProducts.size(); i++) {
                Product product = initProducts.get(i);
                out.printf("%d. %-18s%2d" + System.lineSeparator(), i + 1, product.getName(), product.getPrice());
            }

            MyInteger myInteger = new MyInteger();
            String input;
            try {
                input = in.readLine();
            } catch (Exception e) {
                continue;
            }

            if (input.equals("exit")) {
                break;
            }

            if (!tryParseInt(input, myInteger) || myInteger.getValue() > initProducts.size() || myInteger.getValue() <= 0) {
                continue;
            }

            Product product = initProducts.get(myInteger.getValue() - 1);

            try {
                if (wallet.withdraw(product.getPrice())) {
                    try {
                        warehouse.removeProduct(product.getId());
                    } catch (ProductNotFoundException e) {
                        wallet.deposit(product.getPrice());
                        continue;
                    }
                }
            } catch (OverflowException e) {
                throw e;
            }
        }
    }

    private WarehouseType getWarehouseTypeOrNull(BufferedReader in, PrintStream out) {
        while (true) {
            out.printf("%s" + System.lineSeparator(), "WAREHOUSE: Choose your warehouse!");
            out.printf("%s", warehouseTypesToString());
            MyInteger myInteger = new MyInteger();
            String input;
            try {
                input = in.readLine();
            } catch (Exception e) {
                continue;
            }

            if (input.equals("exit")) {
                break;
            }

            if (!tryParseInt(input, myInteger)) {
                continue;
            }
            WarehouseType[] warehouseTypes = WarehouseType.values();
            for (int i = 0; i < warehouseTypes.length; i++) {
                if (i + 1 == myInteger.getValue()) {
                    return warehouseTypes[i];
                }
            }
        }

        return null;
    }

    private boolean tryParseInt(String in, MyInteger result) {
        try {
            result.setValue(Integer.parseInt(in));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private String warehouseTypesToString() {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (WarehouseType wt : WarehouseType.values()) {
            sb.append(++i);
            sb.append(". ");
            sb.append(wt.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }


}
