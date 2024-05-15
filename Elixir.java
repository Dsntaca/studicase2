public class Elixir extends Item {
    @Override
    public void apply(Character character) {
        if (character instanceof Hero) {
            character.currentHP += 150;
            character.currentMP += 100;
            if (character.currentHP > character.maxHP) character.currentHP = character.maxHP;
            if (character.currentMP > character.maxMP) character.currentMP = character.maxMP;
            System.out.println(character.name + " uses an Elixir and restores 150 HP and 100 MP. Current HP: " + character.currentHP + ", Current MP: " + character.currentMP);
        } else {
            System.out.println("Only Heroes can use Elixir.");
        }
    }
}
