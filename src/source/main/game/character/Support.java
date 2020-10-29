package source.main.game.character;

import source.main.game.equipment.Equipment;

import java.util.Scanner;

public class Support extends Character{
    private double strength = 18;
    private double agility = 13;
    private double intelligence = 22;

    @Override
    public void setExp(int exp) {
        if(exp >= (1000 + (1000 * currentLevel)) || (this.exp + exp) >= (1000 + (1000 * currentLevel))){
            double STR_PER_LVL = 2.3;
            double AGL_PER_LVL = 1.4;
            double INT_PER_LVL = 3.3;
            currentLevel++;
            setStrength(Math.ceil(STR_PER_LVL * currentLevel));
            setAgility(Math.ceil(AGL_PER_LVL * currentLevel));
            setIntelligence(Math.ceil(INT_PER_LVL * currentLevel));
            this.exp = (this.exp + exp) - (1000 * currentLevel);
        }else {
            this.exp += exp;
        }
    }
    //Баф Инт
    @Override
    public void buffSkillOne(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        this.mp -= 100;
        character.setIntelligence(5);
        System.out.println("Увеличил ИНТ на " + 5 + " потрачено MP " + 100);
    }
    //удар
    @Override
    public void activeSkillTwo(Character character) {
        if(this.mp < 150){
            System.out.println("Недостаточно маны для использования умения, будет использована автоатака");
            autoAttack(character);
            return;
        }
        this.mp -= 150;
        character.setHp((int) -(20 * intelligence / character.getMagicArmor()));
        System.out.println("Удар светом, урон по противнику " + (int)(20 * intelligence / character.getMagicArmor()) +
                " потрачено MP " + 150);
    }
    //МП
    @Override
    public void buffSkillThree(Character character) {
        if(this.mp < 50){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        this.mp -= 50;
        character.setMp(200 * currentLevel);
        System.out.println("Увеличение МП на " + (200 * currentLevel) + " потрачено MP " + 50);
    }
    //хп
    @Override
    public void activeSkillFour(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        this.mp -= 100;
        character.setHp(50 * currentLevel);
        System.out.println("Увеличение ХП на " + (50 * currentLevel) + " потрачено MP " + 100);
    }
    //Баф СТР
    @Override
    public void activeSkillFive(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        this.mp -= 100;
        character.setStrength(5);
        System.out.println("Увеличил СТР на " + 5 + " потрачено MP " + 100);
    }

    @Override
    public void autoAttack(Character character) {
        character.setHp((int) -(1 * atkPower / character.getArmor()));
        System.out.println(getClass().getSimpleName() + " наносит удар " + (int)(1 * atkPower / character.getArmor()));
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
        System.out.println("1 - Увеличил ИНТ на " + 5  + ". Расход MP " + 100);
        System.out.println("2 - Удар светом, урон " + (int)(5 * intelligence)  + ". Расход MP " + 150);
        System.out.println("3 - Увеличение МП на " + (200 * currentLevel)  + ". Расход MP " + 50);
        System.out.println("4 - Увеличение ХП на " + (50 * currentLevel)  + ". Расход MP " + 100);
        System.out.println("5 - Увеличение Силы " + 5  + ". Расход MP " + 100);
        System.out.println("0 - Автоатака " + (int)(1 * atkPower));
    }

    public Equipment[] getEquipment() {
        return equipment;
    }

    public void setEquip(Equipment equip){
        for (int i = 0; i < getEquipment().length; i++) {
            if(getEquipment()[i] == null){
                getEquipment()[i] = equip;
                setStrength(equip.getStrength());
                setAgility(equip.getAgility());
                setIntelligence(equip.getIntelligence());
                if(equip.getArmor() != 0){
                    armor += equip.getArmor();
                }
                if(equip.getMagicArmor() != 0){
                    magicArmor += equip.getMagicArmor();
                }
                if(equip.getAtkPower() != 0){
                    atkPower += equip.getAtkPower();
                }
                break;
            } else if(getEquipment()[i].getClass().getSuperclass() == equip.getClass().getSuperclass()){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Заменить вещь " + getEquipment()[i].toString() + " на " + equip.toString() + "?");
                System.out.println("1 - Да");
                System.out.println("2 - Нет");
                int answer = scanner.nextInt();
                switch (answer){
                    case 1: {
                        setStrength(-getEquipment()[i].getStrength());
                        setAgility(-getEquipment()[i].getAgility());
                        setIntelligence(-getEquipment()[i].getIntelligence());
                        if(getEquipment()[i].getArmor() != 0){
                            armor -= equip.getArmor();
                        }
                        if(getEquipment()[i].getMagicArmor() != 0){
                            magicArmor -= equip.getMagicArmor();
                        }
                        if(getEquipment()[i].getAtkPower() != 0){
                            atkPower -= equip.getAtkPower();
                        }
                        getEquipment()[i] = equip;
                        setStrength(equip.getStrength());
                        setAgility(equip.getAgility());
                        setIntelligence(equip.getIntelligence());
                        if(equip.getArmor() != 0){
                            armor += equip.getArmor();
                        }
                        if(equip.getMagicArmor() != 0){
                            magicArmor += equip.getMagicArmor();
                        }
                        if(equip.getAtkPower() != 0){
                            atkPower += equip.getAtkPower();
                        }
                    }
                    break;
                    case 2:
                        break;
                }
            } else {
                System.out.println("Все ячейки заполнены");
            }
        }
    }

    @Override
    public String toString() {
        return "Support{" +
                "currentLevel=" + currentLevel +
                ", hp=" + hp +
                ", mp=" + mp +
                ", atkPower=" + (int)atkPower +
                ", armor=" + (int)armor +
                ", magicArmor=" + (int)magicArmor +
                '}';
    }
}
