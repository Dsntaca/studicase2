public class Foe extends Character {
    public Foe(String name, String race, int level) {
        super(name, race, level);
    }

    @Override
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

    @Override
    public void useSkill(Character opponent) {
        // Implementation specific to Foe subclasses
    }
}
