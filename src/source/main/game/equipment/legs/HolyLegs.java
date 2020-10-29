package source.main.game.equipment.legs;

public class HolyLegs extends Legs{
    private double strength = 3;
    private double agility = 2;
    private double intelligence = 3;
    private double armor = 1;
    private double magicArmor = 1;
    private double atkPower;

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public double getAgility() {
        return agility;
    }

    @Override
    public double getIntelligence() {
        return intelligence;
    }

    @Override
    public double getArmor() {
        return armor;
    }

    @Override
    public double getMagicArmor() {
        return magicArmor;
    }

    public double getAtkPower() {
        return atkPower;
    }

    @Override
    public String toString() {
        return "HolyLegs{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", armor=" + armor +
                ", magicArmor=" + magicArmor +
                '}';
    }
}
