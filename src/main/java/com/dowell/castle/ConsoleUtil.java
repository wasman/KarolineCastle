package com.dowell.castle;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

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
        if (console != null) {
            System.out.println(question);
            char[] chars = console.readPassword("password:");
            return new String(chars);
        }
        else {
            return promptUserInput(question);
        }
    }

    public static void displayWord(WordMap world) {
        Map<Position, ActionCell> wordMap = world.getWordMap();

        int width = 144;// 36 * 4
        int height = 33;//11 * 3

        //BufferedImage image = ImageIO.read(new File("/Users/mkyong/Desktop/logo.jpg"));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.PLAIN, 4));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_DEFAULT);

        graphics.drawRect(0, 0, width - 1, height - 1);

        for (Map.Entry<Position, ActionCell> entry : wordMap.entrySet()) {
            ActionCell actionCell = entry.getValue();
            if (actionCell.isEnabled()) {
                int xaix = entry.getKey().getXaix();
                int yaix = entry.getKey().getYaix();

                graphics.drawRect(xaix * 4, yaix * 3, 3, 2);
            }
        }

        Position characterLocation = world.getCharacterLocation();
        graphics.drawOval(characterLocation.getXaix() * 4, characterLocation.getYaix() * 3, 3, 2);

        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {

                Runtime.getRuntime().exec("clear");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Game on: " + world.getName());
        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "\u001B[34;42;1m" + "$" + "\u001B[0m");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }
    }
}
