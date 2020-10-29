package source.main.game.equipment.offhand;

public class Wand extends OffHand{
    private double strength = 1;
    private double agility = 1;
    private double intelligence = 6;
    private double armor;
    private double magicArmor;
    private double atkPower = 1;

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
        return "Wand{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", atkPower=" + atkPower +
                '}';
    }
}
