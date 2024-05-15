public class Ether extends Item {
    @Override
    public void apply(Character character) {
        if (character instanceof Hero) {
            character.currentMP += 100;
            if (character.currentMP > character.maxMP) character.currentMP = character.maxMP;
            System.out.println(character.name + " uses an Ether and restores 100 MP. Current MP: " + character.currentMP);
        } else {
            System.out.println("Only Heroes can use Ether.");
        }
    }
}
