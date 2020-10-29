package source.main.game.character;

import source.main.game.equipment.Equipment;

import java.util.Scanner;

public abstract class Character implements Skill, Experience, Cloneable{
    protected final int BASE_HP = 200;
    protected final int BASE_MP = 75;
    protected final int BASE_ATK_POWER = 10;
    protected final int BASE_MGK_POWER = 0;
    protected int currentLevel = 0;
    protected int exp = 0;
    private int badgePvp;
    private int badgePve;
    private int badgeMiss;

    protected double strength;
    protected double agility;
    protected double intelligence;

    protected final static int MAX_LEVEL = 50;

    protected int hp = BASE_HP;
    protected int mp = BASE_MP;
    protected double atkPower = BASE_ATK_POWER + strength;
    protected double armor = 2 + (agility * 0.16);
    protected double magicArmor = 2 + (intelligence * 0.16);

    protected Equipment[] equipment = new Equipment[6];

    protected abstract void setArmor(double armor);
    public abstract void setHp(int hp);
    protected abstract void setMp(int mp);
    public abstract int getHp();
    public abstract int getMp();
    protected abstract double getArmor();
    protected abstract double getMagicArmor();
    protected abstract void setAtkPower(int atkPower);
    protected void setStrength(double strength) {
        this.strength = strength;
        this.hp = BASE_HP + ((int)this.strength * 20);
        this.atkPower = BASE_ATK_POWER + this.strength;
    }
    protected void setAgility(double agility) {
        this.agility = agility;
        this.armor = this.agility * 0.16;
    }
    protected void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
        this.mp = BASE_MP + ((int)this.intelligence * 12);
        this.magicArmor = this.intelligence * 0.16;
    }
    public abstract int getCurrentLevel();
    public abstract void getSkills();
    public abstract double getAtkPower();

    public double getStrength() {
        return strength;
    }

    public double getAgility() {
        return agility;
    }

    public double getIntelligence() {
        return intelligence;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getBadgePvp() {
        return badgePvp;
    }

    public void setBadgePvp(int badgePvp) {
        this.badgePvp += badgePvp;
    }

    public int getBadgePve() {
        return badgePve;
    }

    public void setBadgePve(int badgePve) {
        this.badgePve += badgePve;
    }

    public int getBadgeMiss() {
        return badgeMiss;
    }

    public void setBadgeMiss(int badgeMiss) {
        this.badgeMiss += badgeMiss;
    }

    public abstract Equipment[] getEquipment();

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
}
