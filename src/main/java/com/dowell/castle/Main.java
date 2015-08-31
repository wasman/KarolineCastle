package com.dowell.castle;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        WordMap world = new WordMapImpl.Builder()
                .addCell(new Position(1, 3), new ActionCell.Builder().build())
                .addCell(new Position(2, 3), new ActionCell.Builder().build())
                .addCell(new Position(3, 3), new ActionCell.Builder().build())
                .addCell(new Position(4, 3), new ActionCell.Builder().build())
                .addCell(new Position(1, 2), new ActionCell.Builder().build())
                .name("SomeName")
                .build();

        dispalyWord(world);

//        Console console = System.console();
//        console.
    }

    private static void dispalyWord(WordMap world) {
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
            int xaix = entry.getKey().getXaix();
            int yaix = entry.getKey().getYaix();

            graphics.drawRect(xaix * 4, yaix * 3, 3, 2);
        }

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

        System.out.println("Game on: " +world.getName());
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
