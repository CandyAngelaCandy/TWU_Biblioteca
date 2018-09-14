package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieInfoManage {
    private List<Movie> movielist = new ArrayList<>();

    public List<Movie> getMovielist() {
        return movielist;
    }

    public void setMovielist(List<Movie> movielist) {
        this.movielist = movielist;
    }

    public MovieInfoManage() {
        initMovieList();
    }

    public void initMovieList() {
        List<Movie> movielist = new ArrayList<>();
        movielist.add(new Movie(0, "碟中谍6：全面瓦解", 2018, "克里斯托弗·麦奎里", 8.3, false));
        movielist.add(new Movie(1, "蚁人2：黄蜂女现身", 2018, "佩顿·里德", 7.5, false));
        movielist.add(new Movie(2, "苏丹", 2018, "阿里·阿巴斯·札法", 7.2, false));
        movielist.add(new Movie(3, "快把我哥带走", 2018, " 郑芬芬", 7.0, false));
        movielist.add(new Movie(4, "一出好戏", 2018, "黄渤", 7.3, false));
        this.movielist = movielist;
    }

    public List<Movie> printAllMovie() {
        System.out.println("All movie in Biblioteca library");

        this.movielist.stream().filter((movie) -> !movie.isBorrow()).forEach((movie) -> {
            System.out.println(movie.getId() + " " + movie.getName());
        });

        return this.movielist;
    }

    public void checkoutMovies(int id) {

        boolean isExist = this.movielist.stream().anyMatch(book -> book.getId() == id);

        if (isExist) {
            this.movielist =  this.movielist.stream().map((book) ->{
                if(book.getId() == id) book.setBorrow(true);
                return book;
            } ).collect(Collectors.toList());
            System.out.println("Thank you! Enjoy the movie");
        }else{
            System.out.println("That movie is not available");
        }

    }
}
