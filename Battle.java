package com.company;

/**
 * Created by Someone on 25.11.2016.
 */
public class Battle {
    public static void startBattle(Squad squad1, Squad squad2) {
        Warrior warrior1;
        Warrior warrior2;
        int i = 0;
        // Дата начала сражения
        DateHelper dateHelper = new DateHelper();
        System.out.println(dateHelper.getFormattedStartDate());

        while (true) {
            if (squad1.hasAliveWarriors() && squad2.hasAliveWarriors()) {
                warrior1 = squad1.getRandomWarrior();
                warrior2 = squad2.getRandomWarrior();


                dateHelper.skipTime();

                if (i % 2 == 0) {
                    System.out.println(warrior1 + " отряда " + squad1.getSquadName()
                            + " атакует " + warrior2 + " отряда " + squad2.getSquadName());
                    warrior1.attack(warrior2);
                } else {
                    System.out.println(warrior2 + " отряда " + squad2.getSquadName()
                            + " атакует " + warrior1 + " отряда " + squad1.getSquadName());
                    warrior2.attack(warrior1);
                }
                i++;
                System.out.println("i");
            } else {
                break;
            }
        }
        // Время окончания сражения
        System.out.println(dateHelper.getFormattedDiff());

        if (squad1.hasAliveWarriors())
            System.out.println("Отряд " + squad1.getSquadName() + " победил!");
        else
            System.out.println("Отряд " + squad2.getSquadName() + "  победил!");
    }
}
