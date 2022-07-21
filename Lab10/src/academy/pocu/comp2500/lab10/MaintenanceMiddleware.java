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
        OffsetDateTime end = maintenanceTime.plusHours(1);
        if (now.isAfter(maintenanceTime) && now.isBefore(end)) {
            return new ServiceUnavailableResult(maintenanceTime, end);
        }

        return iRequestHandler.handle(request);
    }
}
