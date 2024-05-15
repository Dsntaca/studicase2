public class Fairy extends Hero implements IHealable {
    public Fairy(String name, int level) {
        super(name, "Fairy", level);
    }

    @Override
    public void useSkill(Character opponent) {
        if (this.currentMP >= 20) {
            heal(opponent);
            this.currentMP -= 20;
        } else {
            System.out.println(this.name + " does not have enough MP to use skill.");
        }
    }

    @Override
    public void heal(Character target) {
        target.currentHP += 50;
        if (target.currentHP > target.maxHP) target.currentHP = target.maxHP;
        System.out.println(this.name + " heals " + target.name + " for 50 HP. Current HP of " + target.name + ": " + target.currentHP);
    }
}
