import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected String race;
    protected int level;
    protected int maxHP;
    protected int maxMP;
    protected int currentHP;
    protected int currentMP;
    protected Weapon weapon;
    protected Armor armor = new Armor(0);  // Default armor
    protected List<IStatusEffect> statusEffects = new ArrayList<>();

    public Character(String name, String race, int level) {
        this.name = name;
        this.race = race;
        this.level = level;
        this.maxHP = level * 100;
        this.maxMP = level * 50;
        this.currentHP = this.maxHP;
        this.currentMP = this.maxMP;
    }

    public void takeDamage(int damage) {
        for (IStatusEffect effect : statusEffects) {
            damage = effect.modifyDamage(damage);
        }
        this.currentHP -= damage;
        if (this.currentHP < 0) this.currentHP = 0;
        System.out.println(this.name + " takes " + damage + " damage. Current HP: " + this.currentHP);
    }

    public void addStatusEffect(IStatusEffect effect) {
        statusEffects.add(effect);
        System.out.println(this.name + " is affected by " + effect.getClass().getSimpleName() + ".");
    }

    public void removeStatusEffect(IStatusEffect effect) {
        statusEffects.remove(effect);
        System.out.println(effect.getClass().getSimpleName() + " removed from " + this.name + ".");
    }

    public void removeAllStatusEffects() {
        statusEffects.clear();
        System.out.println("All status effects removed from " + this.name + ".");
    }

    public void removePoisonStatusEffect() {
        statusEffects.removeIf(effect -> effect instanceof Poison);
        System.out.println("Poison status removed from " + this.name + ".");
    }

    public void attack(Character opponent) {
        if (this.weapon != null) {
            int damage = this.weapon.getAP();
            damage -= opponent.armor.getPertahanan();
            if (damage < 0) damage = 0;
            opponent.takeDamage(damage);
        } else {
            System.out.println(this.name + " has no weapon.");
        }
    }

    public void useSkill(Character opponent) {
        // Implementation specific to each character
    }

    public void useItem(Item item) {
        item.apply(this);
    }
}
