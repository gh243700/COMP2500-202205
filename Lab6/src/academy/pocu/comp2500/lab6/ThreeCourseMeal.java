package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends SetMenu {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        price = PRICE;
    }

    public boolean isValid() {
        return appetizers.size() !=0 && mainCourses.size() != 0 && desserts.size() != 0;
    }
    public void setMainCourse(MainCourse mainCourse) {
        mainCourses.clear();

        this.mainCourses.add(mainCourse);
    }

    public void setAppetizer(Appetizer appetizer) {
        appetizers.clear();

        this.appetizers.add(appetizer);
    }

    public void setDessert(Dessert dessert) {
        desserts.clear();
        this.desserts.add(dessert);
    }


}
