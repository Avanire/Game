package source.main.game.equipment.body;

public class BodyOfBull extends Body{
    private double strength = 7;
    private double agility = 4;
    private double intelligence = 3;
    private double armor = 5;
    private double magicArmor = 3;
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
        return "BodyOfBull{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", armor=" + armor +
                ", magicArmor=" + magicArmor +
                ", atkPower=" + atkPower +
                '}';
    }
}
