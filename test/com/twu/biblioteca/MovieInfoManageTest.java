package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieInfoManageTest {
   MovieInfoManage movieInfoManage = new MovieInfoManage();
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    List<Movie> movielist = new ArrayList<>();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));

        movielist.add(new Movie(1, "碟中谍6：全面瓦解", 2018, "克里斯托弗·麦奎里", 8.3, false));
        movielist.add(new Movie(2, "蚁人2：黄蜂女现身", 2018, "佩顿·里德", 7.5, false));
        movielist.add(new Movie(3, "苏丹", 2018, "阿里·阿巴斯·札法", 7.2, false));
        movielist.add(new Movie(4, "快把我哥带走", 2018, " 郑芬芬", 7.0, false));
        movielist.add(new Movie(5, "一出好戏", 2018, "黄渤", 7.3, false));
    }

    @Test
    public void should_print_book_list() {
        assertThat(movieInfoManage.printAllMovie(), is(movielist));
    }
}