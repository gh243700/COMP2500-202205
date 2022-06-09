package academy.pocu.comp2500.lab6.app;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;
    private MainCourse mainCourse;

    public ThreeCourseMeal() {
        price = PRICE;
    }
    public boolean isValid() {
        return this.appetizers.size() != 0 && this.mainCourse != null && this.desserts.size() != 0;
    }

    public MainCourse getMainCourse() {
        assert (this.mainCourse != null) : "call isValid() first!";
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
