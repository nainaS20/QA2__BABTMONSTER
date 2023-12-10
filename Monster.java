import java.util.Objects;
import java.lang.reflect.Field;
import java.util.*;

public class Monster {

    String eyes;
    String feather_c;
    String magical_a;
    int Size;
    int strength;
    int durability;
    String weakness;
    int agression_l;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Size == monster.Size && strength == monster.strength && durability == monster.durability && agression_l == monster.agression_l && Objects.equals(eyes, monster.eyes) && Objects.equals(feather_c, monster.feather_c) && Objects.equals(magical_a, monster.magical_a) && Objects.equals(weakness, monster.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eyes, feather_c, magical_a, Size, strength, durability, weakness, agression_l);
    }

    public Monster(String eyes, String feather_c, String magical_a, int size, int strength, int durability, String weakness, int agression_l) {
        this.eyes = eyes;
        this.feather_c = feather_c;
        this.magical_a = magical_a;
        Size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.agression_l = agression_l;
    }
    public Monster(){
     //Default constructor
    }
    public static Monster babyMonster(Monster parent1,Monster parent2){
        Monster bm=new Monster();
        Field[] acc_field=Monster.class.getDeclaredFields();

        Random rand=new Random();
        for(Field f:acc_field) {
            f.setAccessible(true);

            try {
                Object trait_fromparent = rand.nextBoolean() ? f.get(parent1) : f.get(parent2);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
      return bm;
    }
}
