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
        MovieStore movieStore = (MovieStore) iRequestHandler;
        ResultBase resultBase = movieStore.handle(request);

        if(resultBase instanceof OkResult) {
            CachedResult cachedResult = cachedResultHashMap.get(request);
            if (!cachedResultHashMap.containsKey(request)) {
                cachedResult = new CachedResult(requestCount);
                cachedResultHashMap.put(request, cachedResult);
                return resultBase;
            }
            cachedResult.decreesExpiryCount();
            if (cachedResult.getExpiryCount() <= 1) {
                cachedResultHashMap.remove(request);
            }
            return cachedResult;
        }

        return iRequestHandler.handle(request);
    }
}
