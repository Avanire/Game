package source.main.game.game.pvp;

import source.main.game.character.Character;
import source.main.game.game.Game;

import java.util.Scanner;

public class Pvp {
    public static void startPvP(Character character1, Character character2, Character[] characters) throws CloneNotSupportedException {
        Character attacking = (Character) character1.clone();
        Character defending = (Character) character2.clone();
        Character[] charactersTemp = {attacking, defending};
        System.out.println("Начало боя " + attacking.getClass().getSimpleName() + " против " + defending.getClass().getSimpleName());
        Scanner scanner = new Scanner(System.in);
        int expPlayer = 0;
        int expComp = 0;
        if(character2.getCurrentLevel() != 0 && character1.getCurrentLevel() != 0) {
            expPlayer = (int) (1000 * (character2.getCurrentLevel() / character1.getCurrentLevel()) * Game.getDifficulty());
            expComp = (int) (1000 * (character2.getCurrentLevel() / character1.getCurrentLevel()) / Game.getDifficulty());
        }
        int counter = 1;
        while(true){
            if(character1 == characters[0]) {
                System.out.println("Раунд " + counter);
                System.out.println("Ваш ход " + attacking.getClass().getSimpleName() + " HP " + attacking.getHp() + " MP " + attacking.getMp());
                System.out.println("____________________");
                System.out.println("Выберите какой скилл использовать ");
                character1.getSkills();
                int skillNumber = scanner.nextInt();
                while (skillNumber < 1 || skillNumber > 5) {
                    System.out.println("Вы ввели не правильное число");
                    System.out.print("Повторите ввод ");
                    skillNumber = scanner.nextInt();
                }
                System.out.println("Выберите на кого использовать скилл ");
                System.out.println("1 - на себя");
                System.out.println("2 - на противника");
                int skillAtChar = scanner.nextInt();
                while (skillAtChar < 1 || skillAtChar > 2) {
                    System.out.println("Вы ввели не правильное число");
                    System.out.print("Повторите ввод ");
                    skillAtChar = scanner.nextInt();
                }
                useSkill(attacking, skillNumber, charForSkill(charactersTemp, skillAtChar));
                if (defending.getHp() <= 0) {
                    System.out.println("Победил " + attacking.getClass().getSimpleName());
                    character1.setBadgePvp((int) (2 * Game.getDifficulty()));
                    if (character2.getCurrentLevel() != 0 && character1.getCurrentLevel() != 0) {
                        character1.setExp(expPlayer);
                        System.out.print("Получил EXP: " + expPlayer);
                        System.out.println();
                    } else {
                        character1.setExp(1000);
                        System.out.print("Получил EXP: " + (1000 * Game.getDifficulty()));
                        System.out.println();
                    }
                    return;
                }
                System.out.println("Здоровье персонажа " + defending.getClass().getSimpleName() + " " + defending.getHp() + "\n");
                System.out.println("Ход компьютера " + defending.getClass().getSimpleName() + " HP " + defending.getHp() + " MP " + defending.getMp());
                System.out.println("____________________");
                useSkill(defending, 2, attacking);
                if (attacking.getHp() <= 0) {
                    System.out.println("Победил " + defending.getClass().getSimpleName());
                    character2.setBadgePvp((int) (2 / Game.getDifficulty()));
                    if (character2.getCurrentLevel() != 0 && character1.getCurrentLevel() != 0) {
                        character2.setExp(expComp);
                        System.out.print("Получил EXP: " + expComp);
                        System.out.println();
                    } else {
                        character2.setExp((int) (1000 / Game.getDifficulty()));
                        System.out.print("Получил EXP: " + (1000 / Game.getDifficulty()));
                        System.out.println();
                    }
                    return;
                }
                System.out.println("Здоровье персонажа " + attacking.getClass().getSimpleName() + " " + attacking.getHp());
                System.out.println("--------------");
                counter++;
            }else {
                useSkill(attacking, 2, defending);
                if (defending.getHp() <= 0) {
                    System.out.println("Победил " + attacking.getClass().getSimpleName());
                    character1.setBadgePvp((int) (2 * Game.getDifficulty()));
                    if (character2.getCurrentLevel() != 0 && character1.getCurrentLevel() != 0) {
                        character1.setExp(expComp);
                        System.out.print("Получил EXP: " + expComp);
                        System.out.println();
                    } else {
                        character1.setExp((int) (1000 / Game.getDifficulty()));
                        System.out.print("Получил EXP: " + (1000 / Game.getDifficulty()));
                        System.out.println();
                    }
                    return;
                }
                useSkill(defending, 2, attacking);
                if (attacking.getHp() <= 0) {
                    System.out.println("Победил " + defending.getClass().getSimpleName());
                    character2.setBadgePvp((int) (2 / Game.getDifficulty()));
                    if (character2.getCurrentLevel() != 0 && character1.getCurrentLevel() != 0) {
                        character2.setExp(expComp);
                        System.out.print("Получил EXP: " + expComp);
                        System.out.println();
                    } else {
                        character2.setExp((int) (1000 / Game.getDifficulty()));
                        System.out.print("Получил EXP: " + 1000 / Game.getDifficulty());
                        System.out.println();
                    }
                    return;
                }
            }
        }
    }

    private static void useSkill(Character character, int skillNumber, Character whichChar){
        switch (skillNumber){
            case 1: character.buffSkillOne(whichChar);
                break;
            case 2: character.activeSkillTwo(whichChar);
                break;
            case 3: character.buffSkillThree(whichChar);
                break;
            case 4: character.activeSkillFour(whichChar);
                break;
            case 5: character.activeSkillFive(whichChar);
                break;
            default: character.autoAttack(whichChar);
        }
    }


    private static Character charForSkill(Character[] characters, int num){
        if(num == 1){
            return characters[0];
        } else {
            return characters[1];
        }
    }
}
