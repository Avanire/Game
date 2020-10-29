package source.main.game.equipment;

import source.main.game.equipment.arms.ArmsOfBull;
import source.main.game.equipment.arms.ArmsOfMonkey;
import source.main.game.equipment.arms.ArmsOfOwl;
import source.main.game.equipment.arms.HolyArms;
import source.main.game.equipment.body.BodyOfBull;
import source.main.game.equipment.body.BodyOfMonkey;
import source.main.game.equipment.body.BodyOfOwl;
import source.main.game.equipment.body.HolyBody;
import source.main.game.equipment.head.HeadOfBull;
import source.main.game.equipment.head.HeadOfMonkey;
import source.main.game.equipment.head.HeadOfOwl;
import source.main.game.equipment.head.HolyHead;
import source.main.game.equipment.legs.HolyLegs;
import source.main.game.equipment.legs.LegsOfBull;
import source.main.game.equipment.legs.LegsOfMonkey;
import source.main.game.equipment.legs.LegsOfOwl;
import source.main.game.equipment.mainhand.Dagger;
import source.main.game.equipment.mainhand.Staff;
import source.main.game.equipment.mainhand.Sword;
import source.main.game.equipment.offhand.Knife;
import source.main.game.equipment.offhand.Shield;
import source.main.game.equipment.offhand.Wand;

import java.util.Random;

public abstract class Equipment {
    private double strength;
    private double agility;
    private double intelligence;
    private double armor;
    private double magicArmor;
    private double atkPower;
    private static Equipment[] equipments;

    public double getStrength() {
        return strength;
    }

    public double getAgility() {
        return agility;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public double getArmor() {
        return armor;
    }

    public double getMagicArmor() {
        return magicArmor;
    }

    public double getAtkPower() {
        return atkPower;
    }

    public static Equipment getEquip(){
        shop();
        Random random = new Random();
        return equipments[random.nextInt(equipments.length) - 1];
    }

    private static void shop(){
        equipments = new Equipment[]{new HolyArms(), new HolyBody(), new HolyHead(),
                new HolyLegs(), new Sword(), new Shield(), new Wand(), new ArmsOfBull(), new ArmsOfMonkey(), new ArmsOfOwl(),
        new LegsOfBull(), new LegsOfMonkey(), new LegsOfOwl(), new HeadOfBull(), new HeadOfMonkey(), new HeadOfOwl(),
        new BodyOfBull(), new BodyOfMonkey(), new BodyOfOwl(), new Dagger(), new Staff(), new Knife()};
    }
}
