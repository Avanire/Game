package source.main.game.equipment.legs;

public class LegsOfMonkey extends Legs{
    private double strength = 2;
    private double agility = 4;
    private double intelligence = 2;
    private double armor = 2;
    private double magicArmor = 0.5;
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

    @Override
    public double getAtkPower() {
        return atkPower;
    }

    @Override
    public String toString() {
        return "LegsOfMonkey{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", armor=" + armor +
                ", magicArmor=" + magicArmor +
                ", atkPower=" + atkPower +
                '}';
    }
}
