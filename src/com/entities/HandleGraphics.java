package com.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * This class makes the graphics for all the objects in the game. Prevents
 * using the same instance between classes. This class is static for that reason.
 * Makes things more efficient and easy.
 *
 * @author Anton Zenin.
 */
public class HandleGraphics {
    private static List<Image> graphics = new ArrayList<>();
    private static Canvas canvas;

    public static Canvas getCanvas() {
        return canvas;
    }

    public static void setCanvas(Canvas canvas) {
        HandleGraphics.canvas = canvas;
    }

    /**
     * Iterates through all the elements of the list to find the graphic
     * that the parameter (the data coming in) says to find.
     *
     * @param name the name of the graphic.
     * @return An Image.
     */
    public static Image getGraphic(String name) {
        for (Image img : graphics) {
            if (img.toString().contains(name)) {
                return img;
            }
        }
        return null;
    }

    /**
     * Copies one list into another.
     *
     * @param graphics Another List of graphics, containing Images.
     */
    public static void setGraphics(List<Image> graphics) {
        if (graphics != null) {
            if (!graphics.isEmpty()) {
                HandleGraphics.graphics.addAll(graphics);
            }
        }
        throw new NullPointerException("The list you are putting in has no data");
    }

    /**
     * Adds a graphic into the list.
     *
     * @param graphic The Image that you want to add.
     */
    public static void addGraphic(Image graphic) {
        if (graphic != null) {
            graphics.add(graphic);
        }
        throw new NullPointerException("The image you are putting in is does not exist");
    }

    /**
     * Deletes a graphic from the list.
     *
     * @param name The name of the graphic as a String.
     * @return True if the graphic was found and removed. False otherwise.
     */
    public static boolean removeGraphic(String name) {
        for (int i = 0; i < graphics.size(); i++) {
            if (graphics.get(i).toString().contains(name)) {
                graphics.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Creates the graphics and renders them at or around 60 FPS.
     */
    public static void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        /* Retrieved from:
         https://gamedevelopment.tutsplus.com
         /tutorials/introduction-to-javafx-for-game-development--cms-23835

         Lee Stemkoski - A professor of mathematics and
         computer science with interests in 3D graphics
         and game development, 19th of May, 2015. */

        // Gets the time in nano seconds
        final long startNanoTime = System.nanoTime();

        // Allows for 60 FPS graphics rendering
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                final double time = (currentNanoTime - startNanoTime) / 1000000000.0d;

                // Graphics come alive here
            }
        }.start();
    }
}