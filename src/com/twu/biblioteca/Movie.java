package com.twu.biblioteca;

public class Movie {
    private int id;
    private String name;
    private int year;
    private String director;
    private double movieRating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    private boolean borrow;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Movie) {
            Movie movie = (Movie) obj;
            return this.name.equals(movie.name)
                    && this.id == movie.id
                    && this.year == movie.year
                    && this.director.equals(movie.director)
                    && this.movieRating == movie.movieRating;
        }
        return false;
    }

    public Movie(int id, String name, int year, String director, double movieRating, boolean borrow) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.borrow = borrow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

}
