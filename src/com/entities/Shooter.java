package com.entities;

import com.run.RunGame;

/**
 * This class creates the shooter with all it's components to play the game.
 *
 * @author Anton Zenin
 */
public class Shooter {
    private Gun gun;
    private Bomb bomb;

    private static final int[] GUN_ANCHOR_POINT = {250, 250};

    public Shooter() {
        gun = new Gun(35, 0, GUN_ANCHOR_POINT);

        int[] dropPointCoor = {RunGame.SCENE_HEIGHT, RunGame.SCENE_WIDTH / 2};
        bomb = new Bomb(500, dropPointCoor, null);
    }

    public Gun getGun() {
        return gun;
    }

    public Bomb getBomb() {
        return bomb;
    }
}