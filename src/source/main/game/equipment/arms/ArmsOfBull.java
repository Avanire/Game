package source.main.game.equipment.arms;

public class ArmsOfBull  extends Arms{
    private final double strength = 5;
    private final double agility = 2;
    private final double intelligence = 1;
    private final double armor = 4;
    private final double magicArmor = 2;
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
        return "ArmsOfBull{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", armor=" + armor +
                ", magicArmor=" + magicArmor +
                ", atkPower=" + atkPower +
                '}';
    }
}
