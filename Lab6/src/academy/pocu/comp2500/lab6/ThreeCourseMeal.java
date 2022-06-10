package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends SetMenu {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    public void setMainCourse(MainCourse mainCourse) {
        mainCourses.clear();

        this.mainCourses.add(mainCourse);
        isValid = this.appetizers.size() != 0 && this.mainCourses.size() != 0 && this.desserts.size() != 0;
    }

    public void setAppetizer(Appetizer appetizer) {
        appetizers.clear();

        this.appetizers.add(appetizer);
        isValid = this.appetizers.size() != 0 && this.mainCourses.size() != 0 && this.desserts.size() != 0;
    }

    public void setDessert(Dessert dessert) {
        desserts.clear();
        this.desserts.add(dessert);
        isValid = this.appetizers.size() != 0 && this.mainCourses.size() != 0 && this.desserts.size() != 0;
    }


}
