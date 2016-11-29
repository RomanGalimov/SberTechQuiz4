package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Someone on 25.11.2016.
 */
public class Squad implements Cloneable{
    public ArrayList<Warrior> squad = new ArrayList<>();
    private String squadName;

    private void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getSquadName() {
        return squadName;
    }

    public void addWarriorToSquad(Warrior warrior) {
        squad.add(warrior);
        warrior.setSquadName(squadName);
    }

    public Warrior getRandomWarrior() {
        Random random = new Random();
        while (true) {
            Warrior warrior = squad.get(random.nextInt(squad.size()));
            if (warrior.isAlive())
                return warrior;
        }
    }

    public boolean hasAliveWarriors() {
        for (Warrior warrior : squad) {
            if (warrior.isAlive())
                return true;
        }
        return false;
    }

    Squad(String squadName) {
        squad = new ArrayList<>();
        setSquadName(squadName);
    }

    public void showSquad() {
        System.out.println(squadName);
        for (int i = 0; i < squad.size(); i++) {
            System.out.println(squad.get(i) + "     " + squad.get(i).getHealth() + " " + squad.get(i).getDamage());
        }
    }

    @Override
    public String toString() {
        return squadName;
    }

    @Override
    public Squad clone() {
        Squad sq = new Squad(squadName);
        for (Warrior warrior : squad)
            sq.addWarriorToSquad(warrior.clone());
        return sq;
    }
}
