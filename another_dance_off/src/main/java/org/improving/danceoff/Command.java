package org.improving.danceoff;

public interface Command {
    boolean isValid(String input);
    void execute(String input);
}
