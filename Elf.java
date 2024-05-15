public class Elf extends Foe implements IRecoverable {
    public Elf(String name, int level) {
        super(name, "Elf", level);
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
        if (this.currentMP >= 20) {
            opponent.addStatusEffect(new Sleep());
            this.currentMP -= 20;
        } else {
            System.out.println(this.name + " does not have enough MP to use skill.");
        }
    }

    @Override
    public void recoverMP(Character target) {
        target.currentMP += 30;
        if (target.currentMP > target.maxMP) target.currentMP = target.maxMP;
        System.out.println(this.name + " recovers 30 MP. Current MP: " + target.currentMP);
    }
}
