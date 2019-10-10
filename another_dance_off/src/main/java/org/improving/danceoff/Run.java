package org.improving.danceoff;

import java.io.Console;

public class Run extends ConsoleInputOutput{
    ConsoleInputOutput io;

    public Run(ConsoleInputOutput io) {
        super();
        this.io = io;
    }

    public void run() {
        boolean loop = true;
        while (loop) {
            io.displayPrompt("> ");
            String input = io.getInput();
}
