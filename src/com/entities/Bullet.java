package com.entities;

/**
 * This class creates the bullet with it's physics.
 *
 * @author Anton Zenin
 */
public class Bullet implements RunComponentI {

    public boolean runObject(boolean b) {
        if (b) {
            return true;
        }
        return false;
    }
}