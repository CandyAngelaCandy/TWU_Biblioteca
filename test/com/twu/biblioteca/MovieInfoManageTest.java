package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieInfoManageTest {
    MovieInfoManage movieInfoManage = new MovieInfoManage();
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    List<Movie> movielist = new ArrayList<>();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));

        movielist.add(new Movie(0, "碟中谍6：全面瓦解", 2018, "克里斯托弗·麦奎里", 8.3, false));
        movielist.add(new Movie(1, "蚁人2：黄蜂女现身", 2018, "佩顿·里德", 7.5, false));
        movielist.add(new Movie(2, "苏丹", 2018, "阿里·阿巴斯·札法", 7.2, false));
        movielist.add(new Movie(3, "快把我哥带走", 2018, " 郑芬芬", 7.0, false));
        movielist.add(new Movie(4, "一出好戏", 2018, "黄渤", 7.3, false));
    }

    @Test
    public void should_print_movie_list() {
        assertThat(movieInfoManage.printAllMovie(), is(movielist));
    }

    @Test
    public void should_update_movie_when_check_out_movie_success() {
        movielist = this.movielist.stream().map((book) -> {
            if (book.getId() == 0) book.setBorrow(true);
            return book;
        }).collect(Collectors.toList());

        movieInfoManage.checkoutMovies(0);
        assertThat(movieInfoManage.getMovielist(), is(movielist));
        assertThat(outputContent.toString(), containsString("Thank you! Enjoy the movie"));
    }

    @Test
    public void should_print_not_available_when_movie_not_exist() {
        movieInfoManage.checkoutMovies(6);
        assertThat(outputContent.toString(), containsString("That movie is not available"));
    }

    @Test
    public void should_print_invalid_message_when_movie_not_exist() {
        movieInfoManage.checkoutMovies(0);
        movieInfoManage.returnMovie(6);
        assertThat(outputContent.toString(), containsString("That is not a valid movie to return"));

    }


}