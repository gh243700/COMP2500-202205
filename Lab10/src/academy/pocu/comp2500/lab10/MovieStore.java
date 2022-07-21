package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;
public class MovieStore implements IRequestHandler {
    private ArrayList<Movie> movies = new ArrayList<>();
    public void add(Movie movie) {
        movies.add(movie);
    }
    public boolean remove(int index) {
        if (movies.size() <= index) {
            return false;
        }
        movies.remove(index);
        return true;
    }
    @Override
    public ResultBase handle(Request request) {
        for (int i = 0; i < movies.size(); i++) {
            if (request.getMovieName().equals(movies.get(i).getTitle())) {
                return new OkResult(movies.get(i));
            }
        }
        return new NotFoundResult();
    }
}
