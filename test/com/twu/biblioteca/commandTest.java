package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class commandTest {

    Command command = new Command();
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void should_print_welcome_information() {
        command.printWelcomeMessage();
        assertThat(outputContent.toString(), containsString("Hello, welcome to Biblioteca library!"));
    }

    @Test
    public void should_init_main_menu() {
        command.initMainMenu();
        assertEquals(command.getMenuList().contains("List Book"),true);
    }
}