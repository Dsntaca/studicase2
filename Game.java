public class Game {
    public static void main(String[] args) {
        // Membuat Hero dan Foe
        Hero knight = new Hero("Knight", "Knight", 10);
        Foe dragon = new Dragon("Dragon", 8);

        // Memberikan senjata kepada Hero dan Foe
        knight.weapon = new Weapon("Pedang", 30);
        dragon.weapon = new Weapon("Cakar", 25);

        // Hero menyerang Foe
        System.out.println(knight.name + " attacks " + dragon.name);
        knight.attack(dragon);
        System.out.println("Current HP of " + dragon.name + ": " + dragon.currentHP);

        // Foe menyerang Hero
        System.out.println(dragon.name + " attacks " + knight.name);
        dragon.attack(knight);
        System.out.println("Current HP of " + knight.name + ": " + knight.currentHP);

        // Foe menggunakan skill Weak pada Hero
        System.out.println(dragon.name + " uses Weak on " + knight.name);
        dragon.useSkill(knight);

        // Hero menggunakan item Potion, Ether, dan Elixir
        System.out.println(knight.name + " menggunakan Potion dan menaikkan 100 HP");
        knight.useItem(new Potion());
        System.out.println(knight.name + " menggunakan Ether dan menaikkan 100 MP");
        knight.useItem(new Ether());
        System.out.println(knight.name + " menggunakan Elixir dan menaikkan 150 HP dan 100 MP");
        knight.useItem(new Elixir());

        // Membuat Fairy dan menggunakan skill pada Hero
        Fairy fairy = new Fairy("Fairy", 5);
        System.out.println(fairy.name + " menggunakan skill healing " + knight.name);
        fairy.useSkill(knight);

        // Membuat Elf, menggunakan skill Sleep pada Hero, dan memulihkan MP sendiri
        Elf elf = new Elf("Elf", 7);
        System.out.println(elf.name + " uses Sleep on " + knight.name);
        elf.useSkill(knight);
        System.out.println(elf.name + " recovers 30 MP. Current MP: " + elf.currentMP);
        elf.recoverMP(elf);

        // Hero menggunakan Remedy untuk menghilangkan semua status dan Antidote untuk menghilangkan status Poison
        System.out.println(knight.name + " uses Remedy to remove all status effects");
        knight.useItem(new Remedy());
        System.out.println(knight.name + " uses Antidote to remove Poison status");
        knight.useItem(new Antidote());
    }
}
