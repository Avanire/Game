package source.main.game.equipment.arms;

public class ArmsOfOwl extends Arms{
    private final double strength = 3;
    private final double agility = 1;
    private final double intelligence = 5;
    private final double armor = 3;
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

    @Override
    public double getAtkPower() {
        return atkPower;
    }

    @Override
    public String toString() {
        return "ArmsOfOwl{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", armor=" + armor +
                ", magicArmor=" + magicArmor +
                ", atkPower=" + atkPower +
                '}';
    }
}
