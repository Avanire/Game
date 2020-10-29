package source.main.game.game;

import source.main.game.character.Character;
import source.main.game.character.*;
import source.main.game.game.mission.Mission;
import source.main.game.game.pve.Pve;
import source.main.game.game.pvp.Pvp;

import java.util.Random;
import java.util.Scanner;

import static source.main.game.monster.Monster.generateArmyOfMonsters;

public class Game {
    private Character[] characters;
    private static double difficulty;
    private int badgeCountForVictory;
    private int round;

    public void startGame() throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите сложность");
        System.out.println("1 - легко");
        System.out.println("2 - нормально");
        System.out.println("3 - сложно");
        System.out.print("Ваш выбор: ");
        int diff = scanner.nextInt();
        while (diff < 1 || diff > 3) {
            System.out.println("Вы ввели не правильное число");
            System.out.print("Повторите ввод ");
            diff = scanner.nextInt();
        }
        setDifficulty(diff);
        System.out.print("Сколько компьютеров будет в игре? ");
        int numberComp = scanner.nextInt();
        while (numberComp < 1) {
            System.out.println("Вы ввели не правильное число");
            System.out.print("Повторите ввод ");
            numberComp = scanner.nextInt();
        }
        characters = new Character[numberComp + 1];
        Random random = new Random();
        System.out.println("Выберите себе персонажа");
        System.out.println("1 - Танк");
        System.out.println("2 - Маг");
        System.out.println("3 - ДД");
        System.out.println("4 - Саппорт");
        System.out.println("5 - Саммонер");
        System.out.print("Ваш выбор: ");
        int charNumber = scanner.nextInt();
        while (charNumber < 1 || charNumber > 5) {
            System.out.println("Вы ввели не правильное число");
            System.out.print("Повторите ввод ");
            charNumber = scanner.nextInt();
        }
        characters[0] = charSelect(charNumber);
        for (int i = 1; i < characters.length; i++) {
            characters[i] = charSelect(random.nextInt(4) + 1);
        }
        System.out.println("Вы выбрали " + characters[0].getClass().getSimpleName());
        System.out.print("Компьютер выбрал ");
        for (int i = 1; i < characters.length; i++) {
            System.out.print(characters[i].getClass().getSimpleName() + " ");
        }
        System.out.println();
        while(true) {
            round++;
            System.out.println("Раунд " + round);
            for(Character a : characters){
                System.out.println(a);
                System.out.println("Бейджей ПВП " + a.getBadgePvp() + " бейджей ПВЕ " + a.getBadgePve()
                        + " бейджей Миссии " + a.getBadgeMiss() + " для победы надо по " + badgeCountForVictory + " бейджей");
                System.out.println("------------------");
            }
            System.out.println("_____________________________");
            System.out.println("В какую локацию пойдем?");
            System.out.println("1 - PvP");
            System.out.println("2 - PVE");
            System.out.println("3 - Миссия");
            int numberOfLocation = scanner.nextInt();
            while (numberOfLocation < 1 || numberOfLocation > 3) {
                System.out.println("Вы ввели не правильное число");
                System.out.print("Повторите ввод ");
                numberOfLocation = scanner.nextInt();
            }
            selectLocation(characters[0], numberOfLocation);
            if(characters[0].getCurrentLevel() >= badgeCountForVictory || characters[0].getBadgePvp() == badgeCountForVictory
                    && characters[0].getBadgePve() == badgeCountForVictory && characters[0].getBadgeMiss() == badgeCountForVictory){
                System.out.println("Победил игрок");
                return;
            }
            for (int i = 1; i < characters.length; i++) {
                System.out.println("Ход компьютера " + characters[i].getClass().getSimpleName());
                selectLocation(characters[i], random.nextInt(2) + 1);
                if(characters[i].getCurrentLevel() >= badgeCountForVictory || characters[i].getBadgePvp() == badgeCountForVictory
                        && characters[i].getBadgePve() == badgeCountForVictory && characters[i].getBadgeMiss() == badgeCountForVictory){
                    System.out.println("Победил компьютер " + characters[i].getClass().getSimpleName());
                    return;
                }
            }

        }
    }

    private Character charSelect(int number){
        switch (number){
            case 1: return new Tank();
            case 2: return new Mag();
            case 3: return new DD();
            case 4: return new Support();
            case 5: return new Summoner();
        }
        return null;
    }

    private void selectLocation(Character character,int num) throws CloneNotSupportedException {
        switch (num){
            case 1: {
                Random random = new Random();
                if(character == characters[0]) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Выберите персонажа с кем устроить PvP ");
                    for (int i = 1; i < characters.length; i++) {
                        System.out.println(i + " - " + characters[i]);
                    }
                    System.out.println();
                    int numbChar = scanner.nextInt();
                    Pvp.startPvP(character, characters[numbChar], characters);
                }else{
                    Pvp.startPvP(character, characters[0], characters);
                }
            }
            break;
            case 2: {
                if(character == characters[0]) {
                    Pve.battlePve(character, generateArmyOfMonsters(character));
                }else{
                    Pve.battlePve(character, generateArmyOfMonsters(character));
                }
            }
            break;
            case 3: {
                Mission.mission(character, characters);
            }
        }
    }

    private void setDifficulty(int number){
        switch (number){
            case 1: difficulty = 2;
                badgeCountForVictory = 50 / 2;
            break;
            case 2: difficulty = 1;
                badgeCountForVictory = 50 / 1;
            break;
            case 3: difficulty = 0.5;
                badgeCountForVictory = (int) (50 / 0.5);
            break;
            default:
                System.out.println("Не правильное число");
        }
    }
    public static double getDifficulty(){
        return difficulty;
    }
}
