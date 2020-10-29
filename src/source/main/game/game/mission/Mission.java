package source.main.game.game.mission;

import source.main.game.character.Character;
import source.main.game.equipment.Equipment;
import source.main.game.game.Game;

import java.util.Random;
import java.util.Scanner;

public class Mission {
    private static String[] riddle = {
            "У этого зверя огромный рост,\n" +
            "Сзади у зверя — маленький хвост,\n" +
            "Спереди у зверя — хвост большой.\n",
            "Кто на своей голове лес носит?",
            "С хозяином дружит,\n" +
            "Дом сторожит,\n" +
            "Живет под крылечком,\n" +
            "Хвост колечком.\n",
            "У меня живет зверек,\n" +
            "Толстобрюх и толстощек.\n",
            "С какой птицы нужно ощипать перья, чтобы получились сразу утро, день, вечер и ночь?\n",
    };
    private static String[] answer = {"слон", "олень", "Собака", "Хомяк", "Утка"};


    public static void mission(Character character, Character[] characters){
        Random random = new Random();
        if(character == characters[0]){
            System.out.println("Вы заходите в избу, где видите старца.");
            System.out.println("Отгадайте загадку. Ответ существительное в ед. числе");
            int numb = random.nextInt(riddle.length);
            System.out.println("Загадка:");
            System.out.println(riddle[numb]);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ответ: ");
            String playerAnswer = scanner.nextLine();
            if(playerAnswer.equalsIgnoreCase(answer[numb])){
                System.out.println("Верно!");
                character.setBadgeMiss((int) (2 * Game.getDifficulty()));
                character.setExp((int) (700 + (character.getCurrentLevel() * 2) * Game.getDifficulty()));
                int randNumb = random.nextInt(4);
                if(randNumb == 3){
                    Equipment equipment = Equipment.getEquip();
                    character.setEquip(equipment);
                    System.out.println("Выпал предмет " + equipment);
                }
            } else {
                System.out.println("Вы не угадали");
            }
        } else {
            int rand = random.nextInt(3);
            if(rand == 1){
                int randNumb = random.nextInt(4);
                if(randNumb == 3){
                    character.setExp((int) (700 + (character.getCurrentLevel() * 2) / Game.getDifficulty()));
                    character.setBadgeMiss((int) (2 / Game.getDifficulty()));
                    Equipment equipment = Equipment.getEquip();
                    character.setEquip(equipment);
                    System.out.println("Выпал предмет " + equipment);
                }
            } else {
                System.out.println("Компьютер не угадал");
            }
        }

    }



}
