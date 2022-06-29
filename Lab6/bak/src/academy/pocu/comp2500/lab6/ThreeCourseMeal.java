package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;
    private MainCourse mainCourse;
    public ThreeCourseMeal() {
        price = PRICE;
    }
    public boolean isValid() {
        return this.appetizers.size() != 0 && mainCourse != null && this.desserts.size() != 0;
    }

    public MainCourse getMainCourse() {
        return this.mainCourse;
    }
    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }
    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.clear();
        appetizers.add(appetizer);
    }

}
