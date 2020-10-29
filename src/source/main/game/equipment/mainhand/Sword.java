package source.main.game.equipment.mainhand;

public class Sword extends MainHand{
    private double strength = 5;
    private double agility = 2;
    private double intelligence = 1;
    private double armor;
    private double magicArmor;
    private double atkPower = 15;

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
        return "Sword{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", atkPower=" + atkPower +
                '}';
    }
}
