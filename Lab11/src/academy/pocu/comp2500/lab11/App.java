package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.*;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {

    public void run(BufferedReader in, PrintStream out, PrintStream err) {
        WarehouseType warehouseType = getWarehouseTypeOrNull(in, out);
        if(warehouseType == null) {
            return;
        }
        Wallet wallet;
        try {
            wallet = new SafeWallet(new User());
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw (RuntimeException) e;
        }

        if (wallet == null) {
            err.printf("%s", "AUTH_ERROR");
            return;
        }

        buyProductFromWarehouse(wallet, warehouseType, in, out);
    }

    private void buyProductFromWarehouse(Wallet wallet, WarehouseType warehouseType, BufferedReader in, PrintStream out) {

        Warehouse warehouse = new Warehouse(warehouseType);

        while (true) {
            out.printf("BALANCE: %d" + System.lineSeparator(), wallet.getAmount());
            out.printf("PRODUCT_LIST: Choose the product you want to buy!" + System.lineSeparator());
            ArrayList<Product> products = warehouse.getProducts();
            int size = products.size();
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                out.printf("%d. %-18s%2d" + System.lineSeparator(),i + 1, product.getName(), product.getPrice());
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

            if (!tryParseInt(input, myInteger) || myInteger.getValue() > products.size() || myInteger.getValue() <= 0) {
                continue;
            }

            if (products.size() != size) {
                throw new ProductNotFoundException("product not found");
            }

            Product product = products.get(myInteger.getValue() - 1);
            ArrayList<Product> warehouseProduct = warehouse.getProducts();

            for (int i = 0; i < warehouseProduct.size(); i++) {
                if(warehouseProduct.get(i).getId() == product.getId()) {
                    if (wallet.withdraw(product.getPrice())) {
                        warehouse.removeProduct(product.getId());
                        continue;
                    }
                    break;
                }
            }
        }
    }

    private WarehouseType getWarehouseTypeOrNull(BufferedReader in, PrintStream out) {
        while (true) {
            out.printf("%s"+System.lineSeparator(), "WAREHOUSE: Choose your warehouse!");
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
                if(i + 1 == myInteger.getValue()) {
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
        for(WarehouseType wt : WarehouseType.values()) {
            sb.append(++i);
            sb.append(". ");
            sb.append(wt.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }


}
