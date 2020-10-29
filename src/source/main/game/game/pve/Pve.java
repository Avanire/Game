package source.main.game.game.pve;

import source.main.game.character.Character;
import source.main.game.equipment.Equipment;
import source.main.game.game.Game;
import source.main.game.monster.Monster;

import java.util.Random;

public class Pve {
    public static void battlePve(Character character, Monster[] monsters) throws CloneNotSupportedException {
        Character cloneCharacter = (Character) character.clone();
        int step = 1;
        characterHealth(cloneCharacter);
        monstersHealth(monsters);
        while (true) {
            System.out.println("Шаг " + step);
            System.out.println("Монстры атакуют Урон " + monsterDamage(monsters));
            if(monsterDamage(monsters) >= cloneCharacter.getHp()){
                System.out.println("----------------------------------");
                System.out.println("Монстры победили героя!");
                break;
            }
            cloneCharacter.setHp(-monsterDamage(monsters));
            System.out.println("У игрока осталось: " + cloneCharacter.getHp() + " здоровья");
            System.out.println("Ваш ход " + cloneCharacter.getClass().getSimpleName() + " HP "
                    + cloneCharacter.getHp() + " MP " + cloneCharacter.getMp());
            System.out.println("____________________");
            if(monstersHealth(monsters) < (int)cloneCharacter.getAtkPower()){
                System.out.println("----------------------------------");
                System.out.println("КОНЕЦ ИГРЫ");
                System.out.println("Победил персонаж");
                int exp = (int) (300 + (character.getCurrentLevel() * 2) * Game.getDifficulty());
                character.setExp(exp);
                character.setBadgePve((int) (2 * Game.getDifficulty()));
                System.out.println(character.getClass().getSimpleName() + " получил " +
                        exp + " опыта и " + (int) (2 * Game.getDifficulty()) + " PVE бейдж");
                Random random = new Random();
                int randNumb = random.nextInt(3);
                if(randNumb == 2){
                    Equipment equipment = Equipment.getEquip();
                    character.setEquip(equipment);
                    System.out.println("Выпал предмет " + equipment);
                }
                break;
            }
            monsters = killingArmy(monsters, (int)cloneCharacter.getAtkPower());
            System.out.println("Осталось монстров " + monsters.length);
            step++;
        }
    }

    private static int characterHealth(Character character){
        if(character.getHp() <= 0){
            System.out.println("Монстры одержали победу!");
        }
        int HP = character.getHp();
        System.out.println("Жизни игрока: " + HP);
        return HP;
    }
    private static int monstersHealth(Monster[] army){
        int armyHealth = 0;
        for (int i = 0; i < army.length; i++) {
            armyHealth += army[i].getHealth();
        }
        System.out.println("Жизни армии монстров: " + armyHealth);
        return armyHealth;
    }
    private static int monsterDamage(Monster[] army){
        int armyDamage = 0;
        for (int i = 0; i < army.length; i++) {
            armyDamage += army[i].getDamagePerAttack();
        }
        return armyDamage;
    }
    private static Monster[] killingArmy(Monster[] army, int damage){
        int count = army.length;
        int i = 0;
        while (damage > 0){
            int temp = army[i].getHealth() - damage;
            if(temp > 0){
                army[i].setHealth(army[i].getHealth() - damage);
                break;
            }else {
                count--;
            }
            damage -= army[i].getHealth();
            i++;
        }
        Monster[] tempArmy = new Monster[count];
        for (int j = i, k = 0; j < tempArmy.length + i; j++, k++) {
            tempArmy[k] = army[j];
        }
        return tempArmy;
    }
}
