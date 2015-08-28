package com.dowell.castle;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUtil {

    public static String promptUserInput(String question) {
        System.out.println(question);
        try {

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));

            return bufferedReader.readLine();

        }
        catch (IOException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }

    }

    public static String promptSecureUserInput(String question) {
        Console console = System.console();
        if (console !=null ) {
            System.out.println(question);
            char[] chars = console.readPassword("password:");
            return new String(chars);
        } else
            return promptUserInput(question);
    }
}
