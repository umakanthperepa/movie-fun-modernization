package org.superbiz.moviefun.movies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    private MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @PostMapping
    public void  addMovie(@RequestBody Movie movie){
        moviesRepository.addMovie(movie);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable long movieId){
        moviesRepository.deleteMovieId(movieId);
    }


    @GetMapping("/count")
    public int count(
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "key", required = false) String key
    ) {
        if (field != null && key != null) {
            LOGGER.info("Finding count for field {} and value {}", field, key);
            return moviesRepository.count(field, key);
        } else {
            return moviesRepository.countAll();
        }
    }

    @GetMapping
    public List<Movie> find(
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "key", required = false) String key,
            @RequestParam(name = "start", required = false) Integer start,
            @RequestParam(name = "pageSize", required = false) Integer pageSize
    ) {

        LOGGER.info("Received Request for find filed {}, key {}, start {}, pageSize {}", field, key, start, pageSize);

        if (field != null && key != null) {
            LOGGER.info("if Received Request for find filed {}, key {}, start {}, pageSize {}", field, key, start, pageSize);
            return moviesRepository.findRange(field, key, start, pageSize);
        } else if (start != null && pageSize != null) {
            LOGGER.info("else if Received Request for find filed {}, key {}, start {}, pageSize {}", field, key, start, pageSize);
            return moviesRepository.findAll(start, pageSize);
        } else {
            LOGGER.info("else loop Received Request for find filed {}, key {}, start {}, pageSize {}", field, key, start, pageSize);
            return moviesRepository.getMovies();
        }
    }


}
