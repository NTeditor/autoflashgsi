package com.github.nteditor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shell {
    private final String[] command;

    public Shell(String[] command) {
        this.command = command;
    }

    private String[] getCommand() {
        return command;
    } 
    private void runCommand(String[] command) {
        if (getCommand() == null) {
            throw new IllegalArgumentException();
        }
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Command exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (command == null) {
            System.err.println("command is null");
            throw new IllegalArgumentException();
        }
        runCommand(getCommand());
    }
}

