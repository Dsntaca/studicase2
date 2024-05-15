public class Potion extends Item {
    @Override
    public void apply(Character character) {
        if (character instanceof Hero) {
            character.currentHP += 100;
            if (character.currentHP > character.maxHP) character.currentHP = character.maxHP;
            System.out.println(character.name + " uses a Potion and restores 100 HP. Current HP: " + character.currentHP);
        } else {
            System.out.println("Only Heroes can use Potion.");
        }
    }
}
