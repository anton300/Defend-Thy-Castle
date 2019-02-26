package com.entities;

/**
 * This class creates the gun.
 *
 * @author Anton Zenin
 */
public class Gun implements RunComponentI {
    private int damage;
    private int gunElevation;
    private Bullet bullet;
    private int[] anchorPoint = new int[2];

    public static final int MAX_GUN_ELEVATION = 10;
    public static final int MIN_GUN_ELEVATION = 170;

    public Gun(int damage, int damageBoost, int[] anchorPoint) {
        this.damage = damage;
        this.gunElevation = 90;

        this.anchorPoint[0] = anchorPoint[0];
        this.anchorPoint[1] = anchorPoint[1];

        this.bullet = new Bullet(this.damage, damageBoost, anchorPoint);
    }

    public int getDamage() {
        return damage;
    }

    public int getGunElevation() {
        return gunElevation;
    }

    public void setGunElevation(int gunElevation) {
        // Gun elevation is in degrees. If the value is within the range of the elevation.
        // From 10 to 170 degrees, if it is in that range, then it will assign it to that value.
        if (gunElevation >= MAX_GUN_ELEVATION && gunElevation <= MIN_GUN_ELEVATION) {
            this.gunElevation = gunElevation;
        }

        if (gunElevation < MAX_GUN_ELEVATION) {
            this.gunElevation = MAX_GUN_ELEVATION;
        }

        if (gunElevation > MIN_GUN_ELEVATION) {
            this.gunElevation = MIN_GUN_ELEVATION;
        }
    }

    public boolean runObject(boolean b) {
        if (b) {
            return true;
        }
        return false;
    }
}