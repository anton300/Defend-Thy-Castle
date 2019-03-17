package com.entities;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * This class makes the canvasBackgrounds for all the objects in the game. Prevents
 * using the same instance between classes. This class is static for that reason.
 * Makes things more efficient and easy.
 *
 * @author Anton Zenin.
 */
public class HandleGraphics {

    private static List<ImagePattern> canvasBackgrounds = new ArrayList<>();
    private static List<ImagePattern> images = new ArrayList<>();

    // No Constructor

    public static ImagePattern getImage(int index) {
        return images.get(index);
    }

    public static void addImage(ImagePattern img) {
        if (img != null) {
            images.add(img);
        } else {
            throw new NullPointerException("You cannot add null to the list!");
        }
    }

    public static ImagePattern getBackground(int index) {
        return canvasBackgrounds.get(index);
    }

    /**
     * Adds a graphic into the list of Canvas background images.
     *
     * @param img The Image that you want to add.
     */
    public static void addCanvasBackground(ImagePattern img) {
        if (img != null) {
            canvasBackgrounds.add(img);
        } else {
            throw new NullPointerException("You cannot add null to the list!");
        }
    }

    /**
     * Creates the canvasBackgrounds and renders them at or around 60 FPS.
     */
    public static void render(GraphicsContext gc) {

        /* Retrieved from:
         https://gamedevelopment.tutsplus.com
         /tutorials/introduction-to-javafx-for-game-development--cms-23835

         Lee Stemkoski - A professor of mathematics and
         computer science with interests in 3D canvasBackgrounds
         and game development, 19th of May, 2015. */

        // Gets the time in nano seconds
        final long startNanoTime = System.nanoTime();

        // Allows for 60 FPS canvasBackgrounds rendering
        new AnimationTimer() {

            @Override
            public void handle(long currentNanoTime) {
                final double time = (currentNanoTime - startNanoTime) / 1000000000.0d;

                // Graphics come alive here
            }
        }.start();
    }
}