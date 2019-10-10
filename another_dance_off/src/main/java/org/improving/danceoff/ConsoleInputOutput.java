package org.improving.danceoff;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ConsoleInputOutput implements InputOutput{

        private Scanner scan;

    public ConsoleInputOutput(Scanner scan) {
        this.scan = scan;
    }

    public String getInput() {
            return scan.nextLine();
        }

    @Override
    public String receiveInput() {
        return null;
    }

    public void displayText(String text) {
            System.out.println(text);
        }

        public void displayPrompt(String prompt) {
            System.out.println(prompt);
        }
}
