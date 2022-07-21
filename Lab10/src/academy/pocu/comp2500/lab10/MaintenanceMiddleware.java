package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;

public class MaintenanceMiddleware implements IRequestHandler {
    private IRequestHandler iRequestHandler;
    private OffsetDateTime maintenanceTime;

    public MaintenanceMiddleware(IRequestHandler iRequestHandler, OffsetDateTime maintenanceTime) {
        this.iRequestHandler = iRequestHandler;
        this.maintenanceTime = maintenanceTime;
    }

    @Override
    public ResultBase handle(Request request) {
        OffsetDateTime now = OffsetDateTime.now();
        int t = now.getHour() * 60 + now.getMinute() - maintenanceTime.getHour() * 60 - maintenanceTime.getMinute();
        if (!now.isBefore(maintenanceTime) && now.getYear() == maintenanceTime.getYear()
                && now.getMonth() == maintenanceTime.getMonth()
                && now.getDayOfMonth() == maintenanceTime.getDayOfMonth()
                && t > 60) {
            t = maintenanceTime.getHour() * 60 + 60 + maintenanceTime.getMinute();
            int hour = t / 60;
            int min = t % 60;

            return new ServiceUnavailableResult(maintenanceTime,
                    OffsetDateTime.of(
                    maintenanceTime.getYear(),
                    maintenanceTime.getMonthValue(),
                    maintenanceTime.getDayOfMonth(),
                    hour, min, maintenanceTime.getSecond(),
                    maintenanceTime.getNano(),
                    maintenanceTime.getOffset())
            );
        }

        return iRequestHandler.handle(request);
    }
}
