package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class commandTest {

    Command command ;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));

        command = new Command();
    }

    @Test
    public void mainMenu() {
        command.mainMenu();
        assertThat(outputContent.toString(), containsString("Hello, welcome to library!"));
    }
}