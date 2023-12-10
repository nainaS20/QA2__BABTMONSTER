import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.lang.reflect.Field;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("How many monsters do you want to create :");
        int no_of_monst=sc.nextInt();
        sc.nextLine();
        List<Monster>monsters=new ArrayList<>();

        for(int i=0;i<no_of_monst;i++){
            monsters.add(monsterCreation(sc,"Monster" +(i+1)));
        }

        Set<Monster>newbaby=createBaby(monsters);

        System.out.println("Traits of baby Monsters: ");
        for(Monster babyMonster : newbaby){
           displayTraitsMonster(babyMonster);
        }
    }

    public static Monster monsterCreation(Scanner sc,String Name_Of_monster){
        System.out.println("Enter traits for" +Name_Of_monster);
        //System.out.println("Enter traits for " + monsterName + ":");
        System.out.print("Eye Color: ");
        String eyeColor =sc.nextLine();

        System.out.print("Feather Color: ");
        String featherColor = sc.nextLine();

        System.out.print("Magical Abilities: ");
        String magicalAbilities = sc.nextLine();

        System.out.print("Size: ");
        int size = sc.nextInt();

        System.out.print("Strength: ");
        int strength = sc.nextInt();
        System.out.print("Durability: ");
        int durability = sc.nextInt();
        System.out.print("Weakness: ");
        sc.nextLine();
        String weakness = sc.nextLine();
        System.out.print("Aggression Level: ");
        int aggressionLevel = sc.nextInt();
        sc.nextLine();
        return new Monster(eyeColor, featherColor, magicalAbilities, size,
                strength, durability, weakness, aggressionLevel);
    }
    private static Set<Monster> createBaby(List<Monster> parents) {

        Set<Monster> babies = new HashSet<>();
        int n = parents.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Monster parent1 = parents.get(i);
                Monster parent2 = parents.get(j);

                Monster babyMonster = Monster.babyMonster(parent1, parent2);

                // To define uniqueness
                // if  baby is already present, create another baby for same parents.
                while (babies.contains(babyMonster)) {

                    babyMonster = Monster.babyMonster(parent1, parent2);
                }

                babies.add(babyMonster);

            }
        }


        return babies;
    }
    private static void displayTraitsMonster(Monster monster) {
        Field[] fields = Monster.class.getDeclaredFields();

        System.out.println("Monster Traits:");
        for (Field field : fields) {
            field.setAccessible(true);

            try {
                System.out.println(field.getName() + ": " + field.get(monster));
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

}
