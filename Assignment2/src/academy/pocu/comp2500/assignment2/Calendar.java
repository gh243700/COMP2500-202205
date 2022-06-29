package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {

    private CalendarType calendarType;
    public CalendarType getCalendarType() {
        return calendarType;
    }
    public Calendar(CalendarType calendarType, DeliveryMethod deliveryMethod) {
        super(deliveryMethod);
        this.calendarType = calendarType;
        switch (calendarType) {
            case WALL:
                name = "Wall Calendar";
                price = 1000;
                width = 400;
                height = 400;
                break;
            case DESK:
                name = "Desk Calendar";
                price = 1000;
                width = 200;
                height = 150;
                break;
            case MAGNET:
                name = "Magnet Calendar";
                price = 1500;
                width = 100;
                height = 200;
                break;
        }

        color = new Color(0xFF, 0xFF, 0xFF);

    }
}
