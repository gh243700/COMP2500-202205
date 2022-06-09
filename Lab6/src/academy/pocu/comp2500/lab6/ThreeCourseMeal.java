package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class ThreeCourseMeal extends Meal {
    private static final int PRICE = 25;
    private ArrayList<MainCourse> mainCourses = new ArrayList<>();

    public ThreeCourseMeal() {
        price = PRICE;
    }
    public boolean isValid() {
        return this.appetizers.size() != 0 && this.mainCourse != null && this.desserts.size() != 0;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }
    public void setMainCourse(MainCourse mainCourse) {
        mainCourses.clear();
        mainCourses.add(mainCourse);
    }
    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.clear();
        appetizers.add(appetizer);
    }

}
