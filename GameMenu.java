package com.company;

import java.lang.invoke.SwitchPoint;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Someone on 27.11.2016.
 */
public class GameMenu {
    private static Warrior createWarriorOfChosenClass(int n) {
        Warrior warrior = null;
        switch (n) {
            case 1:
                warrior = new Archer();
                break;
            case 2:
                warrior = new Knight();
                break;
            case 3:
                warrior = new Viking();
                break;
        }
        return warrior;
    }

    private static void addNewWarriorToSquad(Squad squad) {
        System.out.println("Выберите класс бойца:\n" +
                "1. Лучник\n" +
                "2. Рыцарь\n" +
                "3. Викинг\n"
        );
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            squad.addWarriorToSquad(createWarriorOfChosenClass(scanner.nextInt()));
        }
    }

    private static void addRandomWarriorsToSquad(Squad squad) {
        System.out.println("Сколько бойцов Вы хотите добавить?");
        Scanner scanner = new Scanner(System.in);
        int amount = 0;
        if (scanner.hasNextInt()) {
            amount = scanner.nextInt();
        }
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            try {
                squad.addWarriorToSquad(createWarriorOfChosenClass(random.nextInt(3) + 1));
            }
            catch (java.lang.NullPointerException e) {
                System.out.println("Here!");
            }
        }
    }

    private static Squad createSquad() {
        String squadName = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя отряда:");
        if (scanner.hasNextLine()) {
            squadName = scanner.nextLine();
        }
        Squad squad = new Squad(squadName);

        boolean flag = true;
        while (flag) {
            System.out.println("Выберите действие:\n" +
                    "1. Добавить бойца в отряд\n" +
                    "2. Добавить N случайных бойцов в отряд\n" +
                    "3. Посмотреть отряд\n" +
                    "4. Закончить создание отряда"
            );

            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 1:
                        addNewWarriorToSquad(squad);
                        break;
                    case 2:
                        addRandomWarriorsToSquad(squad);
                        break;
                    case 3:
                        squad.showSquad();
                        break;
                    case 4:
                        flag = false;
                        break;
                }
            }
        }
        return squad;
    }

    public static void startGame() {
        Squad squad1 = createSquad();
        Squad squad2 = createSquad();
        Battle.startBattle(squad1, squad2);
    }
}
