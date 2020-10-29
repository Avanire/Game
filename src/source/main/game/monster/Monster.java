package source.main.game.monster;

import source.main.game.character.Character;

import java.util.Random;

public class Monster{
    private int health;
    private int damagePerAttack;
    private Monster[] monsterArmy;

    public Monster(int health, int damagePerAttack) {
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public int getHealth() {
        return health;
    }

    public int getDamagePerAttack() {
        return damagePerAttack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static Monster[] generateArmyOfMonsters(Character character){
        Random rnd = new Random();
        int count = rnd.nextInt((character.getCurrentLevel() + 10)) + 1;
        Monster[] temp = new Monster[count];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new Monster(rnd.nextInt((character.getCurrentLevel() + 10)) + 30,
                    rnd.nextInt((character.getCurrentLevel() + 10)) + 5);
        }
        return temp;
    }

    public Monster[] getMonsterArmy() {
        return monsterArmy;
    }

    public void setMonsterArmy(Monster[] monsterArmy) {
        this.monsterArmy = monsterArmy;
    }
}
