package source.main.game.equipment.arms;

public class HolyArms extends Arms{
    private final double strength = 4;
    private final double agility = 2;
    private final double intelligence = 4;
    private final double armor = 2;
    private final double magicArmor = 3;
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
        return "HolyArms{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", armor=" + armor +
                ", magicArmor=" + magicArmor +
                '}';
    }
}
