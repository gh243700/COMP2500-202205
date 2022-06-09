package academy.pocu.comp2500.lab6.app;

import academy.pocu.comp2500.lab6.*;

public class Program {

    public static void main(String[] args) {
	    // write your code here

        {
            NoHeavyMeal noHeavyMeal = new NoHeavyMeal();

            assert (!noHeavyMeal.isValid());

            noHeavyMeal.setAppetizers(Appetizer.CALAMARI, Appetizer.GYOZA);

            assert (!noHeavyMeal.isValid());

            noHeavyMeal.setDessert(Dessert.APPLE_PIE);

            assert (noHeavyMeal.isValid());
        }

        {
            DeathByDesserts deathByDesserts = new DeathByDesserts();

            assert (!deathByDesserts.isValid());

            deathByDesserts.setDesserts(Dessert.GREEN_TEA_ICE_CREAM, Dessert.ITALIAN_DONUTS, Dessert.MANGO_PUDDING, Dessert.CHOCOLATE_MOUSSE);

            assert (deathByDesserts.isValid());
        }

        {
            ThreeCourseMeal threeCourseMeal = new ThreeCourseMeal();

            assert (!threeCourseMeal.isValid());

            threeCourseMeal.setAppetizer(Appetizer.GYOZA);
            threeCourseMeal.setDessert(Dessert.CHOCOLATE_MOUSSE);

            assert (!threeCourseMeal.isValid());

            threeCourseMeal.setMainCourse(MainCourse.BOMBAY_BUTTER_CHICKEN);

            assert (threeCourseMeal.isValid());
        }

        {
            HousePizza housePizza = new HousePizza();

            assert (!housePizza.isValid());

            assert (housePizza.addBacon());

            assert (!housePizza.isValid());

            assert (housePizza.addPeperoni());

            assert (housePizza.isValid());

            assert (!housePizza.addSausages());

            assert (housePizza.isValid());

            assert (!housePizza.removeSausages());

            assert (housePizza.removeBacon());

            assert (!housePizza.isValid());

            assert (housePizza.addPeperoni());

            assert (housePizza.isValid());
        }

        {
            MeatLoverPizza meatLoverPizza = new MeatLoverPizza();

            assert (!meatLoverPizza.isValid());

            assert (meatLoverPizza.addGreenPeppers());
            assert (!meatLoverPizza.addGreenPeppers());

            assert (meatLoverPizza.isValid());

            assert (meatLoverPizza.removeGreenPeppers());

            assert (!meatLoverPizza.isValid());
        }

        {
            VeggiePizza veggiePizza = new VeggiePizza();

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addCheddarCheese());

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addFetaCheese());

            assert (veggiePizza.isValid());

            assert (veggiePizza.removeCheddarCheese());

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addMozzarellaCheese());

            assert (veggiePizza.isValid());
        }

        {
            FreeSoulPizza freeSoulPizza = new FreeSoulPizza();

            assert (!freeSoulPizza.isValid());

            assert (freeSoulPizza.addTopping(Topping.FETA_CHEESE));
            assert (!freeSoulPizza.addTopping(Topping.CHEDDAR_CHEESE));

            assert (freeSoulPizza.addTopping(Topping.BLACK_OLIVES));
            assert (freeSoulPizza.addTopping(Topping.RED_ONIONS));

            assert (!freeSoulPizza.isValid());

            assert (!freeSoulPizza.addTopping(Topping.GREEN_PEPPERS));
            assert (!freeSoulPizza.removeTopping(Topping.GREEN_PEPPERS));

            assert (!freeSoulPizza.isValid());

            assert (freeSoulPizza.addTopping(Topping.CHICKEN));
            assert (freeSoulPizza.addTopping(Topping.SAUSAGES));

            assert (freeSoulPizza.isValid());

            assert (!freeSoulPizza.addTopping(Topping.PEPERONI));
        }


        {
            DeathByDesserts deathByDesserts = new DeathByDesserts();
            deathByDesserts.getPrice();
            deathByDesserts.isValid();
            deathByDesserts.getDesserts();
            deathByDesserts.setDesserts(Dessert.APPLE_PIE, Dessert.APPLE_PIE, Dessert.APPLE_PIE, Dessert.APPLE_PIE);

            ThreeCourseMeal threeCourseMeal = new ThreeCourseMeal();
            threeCourseMeal.getPrice();
            threeCourseMeal.getAppetizers();
            threeCourseMeal.getDesserts();
            threeCourseMeal.setMainCourse(MainCourse.AHI_TUNA_POKE);
            threeCourseMeal.setAppetizer(Appetizer.CALAMARI);
            threeCourseMeal.setDessert(Dessert.APPLE_PIE);

            NoHeavyMeal noHeavyMeal = new NoHeavyMeal();
            noHeavyMeal.getPrice();
            noHeavyMeal.isValid();
            noHeavyMeal.getAppetizers();
            noHeavyMeal.getDesserts();
            noHeavyMeal.setAppetizers(Appetizer.CALAMARI, Appetizer.CALAMARI);
            noHeavyMeal.setDessert(Dessert.APPLE_PIE);

        }

        {
            FreeSoulPizza freeSoulPizza = new FreeSoulPizza();
            freeSoulPizza.getPrice();
            freeSoulPizza.isValid();
            freeSoulPizza.addTopping(Topping.BACON);
            freeSoulPizza.removeTopping(Topping.BACON);

            VeggiePizza veggiePizza = new VeggiePizza();
            veggiePizza.getPrice();
            veggiePizza.isValid();
            veggiePizza.getToppings();
            veggiePizza.addCheddarCheese();
            veggiePizza.removeMozzarellaCheese();
            veggiePizza.addCheddarCheese();
            veggiePizza.removeCheddarCheese();
            veggiePizza.addFetaCheese();
            veggiePizza.removeFetaCheese();

            MeatLoverPizza meatLoverPizza = new MeatLoverPizza();
            meatLoverPizza.getPrice();
            meatLoverPizza.isValid();
            meatLoverPizza.getToppings();
            meatLoverPizza.addBlackOlives();
            meatLoverPizza.removeBlackOlives();
            meatLoverPizza.addRedOnions();
            meatLoverPizza.removeRedOnions();
            meatLoverPizza.addGreenPeppers();
            meatLoverPizza.removeGreenPeppers();

            HousePizza housePizza = new HousePizza();
            housePizza.getPrice();
            housePizza.isValid();
            housePizza.getToppings();
            housePizza.addBacon();
            housePizza.removeBacon();
            housePizza.addPeperoni();
            housePizza.removePeperoni();
            housePizza.addSausages();
            housePizza.removeSausages();





        }

    }
}
