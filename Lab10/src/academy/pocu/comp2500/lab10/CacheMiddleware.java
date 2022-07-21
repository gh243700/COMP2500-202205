package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import java.util.HashMap;

public class CacheMiddleware implements IRequestHandler {

    private IRequestHandler iRequestHandler;
    private int requestCount;
    private HashMap<Request, CachedResult> cachedResultHashMap = new HashMap<>();

    public CacheMiddleware(IRequestHandler iRequestHandler, int requestCount) {
        this.iRequestHandler = iRequestHandler;
        this.requestCount = requestCount;
    }

    @Override
    public ResultBase handle(Request request) {

        CachedResult cachedResult = cachedResultHashMap.get(request);
        if (cachedResult != null) {
            cachedResult.decreesExpiryCount();
            if (cachedResult.getExpiryCount() <= 1) {
                cachedResultHashMap.remove(request);
            }
            return cachedResult;
        }


        ResultBase resultBase = iRequestHandler.handle(request);
        if (resultBase instanceof OkResult) {
            cachedResult = new CachedResult(requestCount);
            cachedResultHashMap.put(request, cachedResult);
            return resultBase;
        }
        return resultBase;
    }
}
