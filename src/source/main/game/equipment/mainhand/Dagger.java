package source.main.game.equipment.mainhand;

public class Dagger extends MainHand{
    private double strength = 3;
    private double agility = 5;
    private double intelligence = 2;
    private double armor;
    private double magicArmor;
    private double atkPower = 18;

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
        return "Dagger{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", armor=" + armor +
                ", magicArmor=" + magicArmor +
                ", atkPower=" + atkPower +
                '}';
    }
}
