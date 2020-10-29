package source.main.game.character;

import source.main.game.equipment.Equipment;

import java.util.Scanner;

public class Summoner extends Character{
    private double strength = 25;
    private double agility = 15;
    private double intelligence = 19;

    @Override
    public void setExp(int exp) {
        if(exp >= (1000 + (1000 * currentLevel)) || (this.exp + exp) >= (1000 + (1000 * currentLevel))){
            double STR_PER_LVL = 2;
            double AGL_PER_LVL = 2.1;
            double INT_PER_LVL = 3.2;
            currentLevel++;
            setStrength(Math.ceil(STR_PER_LVL * currentLevel));
            setAgility(Math.ceil(AGL_PER_LVL * currentLevel));
            setIntelligence(Math.ceil(INT_PER_LVL * currentLevel));
            this.exp = (this.exp + exp) - (1000 * currentLevel);
        }else {
            this.exp += exp;
        }
    }
    //Повышение интелекта и удар
    @Override
    public void buffSkillOne(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения, будет использована автоатака");
            autoAttack(character);
            return;
        }
        this.mp -= 100;
        intelligence += 5;
        character.setHp((int) -(1 * intelligence / character.getArmor()));
        System.out.println("Удар, урон по противнику " + (int)(1 * intelligence / character.getArmor()) +
                " потрачено MP " + 100);
    }
    //Удар
    @Override
    public void activeSkillTwo(Character character) {
        if(this.mp < 50){
            System.out.println("Недостаточно маны для использования умения, будет использована автоатака");
            autoAttack(character);
            return;
        }
        this.mp -= 50;
        character.setHp((int) -(10 * intelligence / character.getMagicArmor()));
        System.out.println("Нежный удар лапкой, урон по противнику " + (int)(10 * intelligence / character.getMagicArmor())
                + " потрачено MP " + 50);
    }
    //Повышение атаки
    @Override
    public void buffSkillThree(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        character.setAtkPower((int) (10 * intelligence));
        System.out.println("Увеличение Авто атки на " + (10 * intelligence) + " потрачено MP " + 100);
    }
    //Удар мощный
    @Override
    public void activeSkillFour(Character character) {
        if(this.mp < 150){
            System.out.println("Недостаточно маны для использования умения, будет использована автоатака");
            autoAttack(character);
            return;
        }
        this.mp -= 150;
        character.setHp((int) -(20 * strength / character.getArmor()));
        System.out.println("Удар пантеры, урон по противнику " + (int)(20 * strength / character.getArmor()) +
                " потрачено MP " + 150);
    }
    //Повышение армора
    @Override
    public void activeSkillFive(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        this.mp -= 100;
        character.setArmor(5 * currentLevel);
        System.out.println("Увеличение брони на " + (5 + currentLevel) + " потрачено MP " + 100);
    }

    @Override
    public void autoAttack(Character character) {
        character.setHp((int) -(1 * atkPower / character.getArmor()));
        System.out.println(getClass().getSimpleName() + " наносит удар " + (1 * atkPower / character.getArmor()));
    }

    @Override
    protected double getArmor() { return armor; }
    @Override
    protected double getMagicArmor() { return magicArmor; }
    @Override
    protected void setArmor(double armor) {
        this.armor += armor;
    }
    @Override
    public void setHp(int hp) { this.hp += hp; }
    @Override
    protected void setMp(int mp) { this.mp += mp; }
    @Override
    public int getHp() { return hp; }
    @Override
    public int getMp(){ return mp; }
    @Override
    protected  void setAtkPower(int atkPower) {
        this.atkPower += atkPower;
    }
    @Override
    protected void setStrength(double strength) {
        super.setStrength(this.strength + strength);
        this.strength = super.getStrength();
    }
    @Override
    protected void setAgility(double agility) {
        super.setAgility(this.agility + agility);
        this.agility = super.getAgility();
    }
    @Override
    protected void setIntelligence(double intelligence) {
        super.setIntelligence(this.intelligence + intelligence);
        this.intelligence = super.getIntelligence();
    }
    @Override
    public int getCurrentLevel() { return currentLevel; }
    @Override
    public double getAtkPower(){ return atkPower; }
    @Override
    public void getSkills(){
        System.out.println("Список скиллов");
        System.out.println("1 - Удар совы и повышение интеллекта, урон " + (int)(1 * intelligence)  + ". Расход MP " + 100);
        System.out.println("2 - Нежный удар лапкой, урон " + (int)(10 * intelligence)  + ". Расход MP " + 50);
        System.out.println("3 - Повышение атаки " + (int)(10 * intelligence)  + ". Расход MP " + 100);
        System.out.println("4 - Удар пантеры, урон " + (int)(20 * strength)  + ". Расход MP " + 150);
        System.out.println("5 - Повышение брони " + (5 + currentLevel)  + ". Расход MP " + 100);
        System.out.println("0 - Автоатака " + (int)(1 * atkPower));
    }

    public Equipment[] getEquipment() {
        return equipment;
    }

    public void setEquip(Equipment equip){
        super.setEquip(equip);

    }

    @Override
    public String toString() {
        return "Summoner{" +
                "currentLevel=" + currentLevel +
                ", hp=" + hp +
                ", mp=" + mp +
                ", atkPower=" + (int)atkPower +
                ", armor=" + (int)armor +
                ", magicArmor=" + (int)magicArmor +
                '}';
    }
}
