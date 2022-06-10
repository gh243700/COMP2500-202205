package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class SetMenu extends Menu {
    protected ArrayList<MainCourse> mainCourses = new ArrayList<>();
    protected ArrayList<Appetizer> appetizers = new ArrayList<>();
    protected ArrayList<Dessert> desserts = new ArrayList<>();

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return this.mainCourses;
    }

    protected SetMenu(int price) {
        super(price);
    }
}
