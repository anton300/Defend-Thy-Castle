package com.entities;

/**
 * This class creates the gun.
 *
 * @author Anton Zenin
 */
public class Gun implements RunComponentI {
    private int damage;
    private int damageBoost;
    private int gunElevation;
    private static int[] anchorPoint = new int[2];

    public static final int MAX_GUN_ELEVATION = 10;
    public static final int MIN_GUN_ELEVATION = 170;

    public Gun(int damage, int damageBoost, int[] anchorPoint) {
        this.damage = damage;
        this.damageBoost = damageBoost;
        this.anchorPoint = anchorPoint;
        this.gunElevation = 90;
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

    public void addDamageBoost(int damageBoost) {
        this.damage += damageBoost;
    }

    public boolean runObject(boolean b) {
        if (b) {
            return true;
        }
        return false;
    }
}