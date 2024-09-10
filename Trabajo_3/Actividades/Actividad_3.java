package Trabajo_3.Actividades;

public class Actividad_3 {
    public static void main(String[] args) {
        Weapon sword = new WeaponEspada("espada", 50);
        Weapon bow = new WeaponArco("arco", 30);

        int swordDamage = sword.damage( 10);
        int bowDamage = bow.damage( 10);

        System.out.println("Daño de espada: " + swordDamage);
        System.out.println("Daño de arco: " + bowDamage);
    }
}


abstract class Weapon {
    protected String type;
    protected int baseDamage;
    private final float fortune;
    private String element;

    public Weapon(String type, int baseDamage) {
        this.type = type;
        this.baseDamage = baseDamage;
        fortune = 10;
    }

    public Weapon(String type, int baseDamage, float fortune) {
        this.type = type;
        this.baseDamage = baseDamage;
        this.fortune = fortune;
    }

    public String getType() {
        return type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public abstract int damage(int level);
    public abstract void showData();
}

class WeaponEspada extends Weapon {

    public WeaponEspada(String type, int baseDamage) {
        super(type, baseDamage);
    }

    @Override
    public int damage(int level) {
        return baseDamage + (level * 5);
    }

    @Override
    public void showData() {

    }
}

class WeaponArco extends Weapon{
    public WeaponArco(String type, int baseDamage) {
        super(type, baseDamage);
    }

    @Override
    public int damage(int level) {
        return baseDamage + (level * 3);
    }

    @Override
    public void showData() {

    }
}

