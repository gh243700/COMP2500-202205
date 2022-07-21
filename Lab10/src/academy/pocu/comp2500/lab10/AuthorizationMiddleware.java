package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {
    private IRequestHandler iRequestHandler;
    private HashSet<User> users;

    public AuthorizationMiddleware(IRequestHandler iRequestHandler, HashSet<User> users) {
        this.iRequestHandler = iRequestHandler;
        this.users = users;
    }

    @Override
    public ResultBase handle(Request request) {
        User userOrNull = request.getUserOrNull();

        if (userOrNull == null || !users.contains(userOrNull)) {
            return new UnauthorizedResult();
        }

        return iRequestHandler.handle(request);
    }
}
