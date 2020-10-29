package source.main.game.equipment.body;

public class HolyBody extends Body{
    private double strength = 5;
    private double agility = 3;
    private double intelligence = 5;
    private double armor = 4;
    private double magicArmor = 4;
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
        return "HolyBody{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", armor=" + armor +
                ", magicArmor=" + magicArmor +
                '}';
    }
}
