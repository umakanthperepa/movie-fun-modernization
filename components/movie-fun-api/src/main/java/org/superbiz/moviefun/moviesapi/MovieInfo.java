package org.superbiz.moviefun.moviesapi;

public class MovieInfo {


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    private String director;
    private String title;
    private int year;
    private String genre;
    private int rating;

    public MovieInfo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieInfo)) return false;

        MovieInfo movieInfo = (MovieInfo) o;

        if (getYear() != movieInfo.getYear()) return false;
        if (getRating() != movieInfo.getRating()) return false;
        if (!getDirector().equals(movieInfo.getDirector())) return false;
        if (!getTitle().equals(movieInfo.getTitle())) return false;
        return getGenre().equals(movieInfo.getGenre());
    }

    @Override
    public int hashCode() {
        int result = getDirector().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getYear();
        result = 31 * result + getGenre().hashCode();
        result = 31 * result + getRating();
        return result;
    }

    public MovieInfo(String title,String director,   String genre , int rating, int year) {
        this.director = director;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public MovieInfo(String director, String title, int year) {
        this.director = director;
        this.title = title;
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}

