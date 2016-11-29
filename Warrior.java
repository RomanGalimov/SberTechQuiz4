package com.company;

/**
 * Created by Someone on 25.11.2016.
 */
public abstract class Warrior implements Cloneable{
    private int health;
    private int damage;
    private String squadName;
    private String warriorClassName;  // Возможно, не самая нужная информация, но удобно для вывода бойцов отряда

    private void setHealth(int health) {
        this.health = health;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    protected void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getSquadName() {
        return this.squadName;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    Warrior(int health, int damage, String warriorClassName) {
        setHealth(health);
        setDamage(damage);
        this.warriorClassName = warriorClassName;
    }

    public void attack(Warrior warrior) {
        warrior.takeDamage(damage);
    }

    private void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return warriorClassName;
    }

    @Override
    public Warrior clone() {
        try {
            return (Warrior) super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
