package com.entities;

/**
 * This class creates the laser with it's physics.
 *
 * @author Anton Zenin.
 */
public class Laser {
    // The speed of the Laser
    private final int velocity = 5;
    private int damage;
    private int damageBoost;

    // The point that the bullet has to go to
    private int[] travelToPoint = new int[2];
    // The point from the where the bullet has been fired
    private int[] firingPoint = new int[2];

    public Laser(int damage, int damageBoost, int[] startPoint) {
        this.damage = damage;
        this.damageBoost = damageBoost;

        // X
        this.firingPoint[0] = startPoint[0];
        // Y
        this.firingPoint[1] = startPoint[1];
    }

    public int getDamage() {
        return damage;
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public void setDamageBoost(int damageBoost) {
        this.damageBoost = damageBoost;
    }

    public void addDamageBoost(int damageBoost) {
        this.damage += damageBoost;
    }

    public void setDamageToNormal() {
        this.damage -= damageBoost;
    }

    public int[] getTravelToPoint() {
        return travelToPoint;
    }

    /**
     * The setter for the travel point
     */
    public void setTravelToPoint(int[] mouseXY) {
        this.travelToPoint[0] = mouseXY[0];
        this.travelToPoint[1] = mouseXY[1];
    }

    public int[] getFiringPoint() {
        return firingPoint;
    }

    public void setFiringPoint(int X, int Y) {
        this.firingPoint[0] = X;
        this.firingPoint[1] = Y;
    }
}