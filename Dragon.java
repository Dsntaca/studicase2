public class Dragon extends Foe {
    public Dragon(String name, int level) {
        super(name, "Dragon", level);
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
        if (this.currentMP >= 40) {
            opponent.addStatusEffect(new Weak());
            this.currentMP -= 40;
        } else {
            System.out.println(this.name + " does not have enough MP to use skill.");
        }
    }
}
