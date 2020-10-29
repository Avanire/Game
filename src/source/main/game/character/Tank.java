package source.main.game.character;

import source.main.game.equipment.Equipment;

import java.util.Scanner;

public class Tank extends Character{
    private double strength = 25;
    private double agility = 20;
    private double intelligence = 18;

    @Override
    public void setExp(int exp) {
        if(exp >= (1000 + (1000 * currentLevel)) || (this.exp + exp) >= (1000 + (1000 * currentLevel))){
            double STR_PER_LVL = 3.4;
            double AGL_PER_LVL = 2;
            double INT_PER_LVL = 1.7;
            currentLevel++;
            setStrength(Math.ceil(STR_PER_LVL * currentLevel));
            setAgility(Math.ceil(AGL_PER_LVL * currentLevel));
            setIntelligence(Math.ceil(INT_PER_LVL * currentLevel));
            this.exp = (this.exp + exp) - (1000 * currentLevel);
        }else {
            this.exp += exp;
        }
    }

    //Баф на броню
    @Override
    public void buffSkillOne(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        this.mp -= 100;
        character.setArmor(5 * currentLevel);
        System.out.println("Увеличение брони на " + (5 + currentLevel) + " потрачено MP " + 100);
    }

    //удар щитом
    public void activeSkillTwo(Character character) {
        if(this.mp < 50){
            System.out.println("Недостаточно маны для использования умения, будет использована автоатака");
            autoAttack(character);
            return;
        }
        this.mp -= 50;
        character.setHp((int) -(10 * strength / character.getArmor()));
        System.out.println("Удар щитом, урон по противнику " + (int)(10 * strength / character.getArmor())
                + " потрачено MP " + 50);
    }

    //Баф на ХП
    @Override
    public void buffSkillThree(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        this.mp -= 100;
        character.setHp(5 * currentLevel);
        System.out.println("Увеличение ХП на " + (5 * currentLevel) + " потрачено MP " + 100);
    }

    //Сильный удар
    public void activeSkillFour(Character character) {
        if(this.mp < 150){
            System.out.println("Недостаточно маны для использования умения, будет использована автоатака");
            autoAttack(character);
            return;
        }
        this.mp -= 150;
        character.setHp((int) -(20 * strength / character.getArmor()));
        System.out.println("Сильный удар, урон по противнику " + (int)(20 * strength / character.getArmor()) +
                " потрачено MP " + 150);
    }
    //Повышает параметр Авто атаки
    @Override
    public void activeSkillFive(Character character) {
        if(this.mp < 100){
            System.out.println("Недостаточно маны для использования умения");
            return;
        }
        character.setAtkPower((int) (10 * strength));
        System.out.println("Увеличение Автоатки на " + (int)(10 * strength) + " потрачено MP " + 100);
    }
    //Автоатака
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
        System.out.println("1 - Увеличение брони на " + (5 + currentLevel)  + ". Расход MP " + 100);
        System.out.println("2 - Удар щитом, урон " + (int)(10 * strength)  + ". Расход MP " + 50);
        System.out.println("3 - Увеличение ХП на " + (50 * currentLevel)  + ". Расход MP " + 100);
        System.out.println("4 - Сильный удар, урон " + (int)(20 * strength)  + ". Расход MP " + 150);
        System.out.println("5 - Увеличение Автоатки на " + (int)(10 * strength)  + ". Расход MP " + 100);
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
        return "Tank{" +
                "currentLevel=" + currentLevel +
                ", hp=" + hp +
                ", mp=" + mp +
                ", atkPower=" + (int)atkPower +
                ", armor=" + (int)armor +
                ", magicArmor=" + (int)magicArmor +
                '}';
    }
}
