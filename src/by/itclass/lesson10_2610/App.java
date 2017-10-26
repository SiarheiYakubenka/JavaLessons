package by.itclass.lesson10_2610;

import by.itclass.lesson05_0410.Animals.Animal;
import by.itclass.lesson05_0410.Animals.Cat;
import by.itclass.lesson05_0410.Animals.Clerk;
import by.itclass.lesson05_0410.Animals.Human;

import java.util.*;

public class App {
    public static void main(String[] args) {

        //Map - основной интефейс, для хранения пар "ключ - значение"
        //является обобщенным и в качесвте обобщения указываются типы ключа и значеня
        Map<String, Float> moneys = new TreeMap<>();

        //put кладет значение по ключу в карту(если существ., то замена)
        moneys.put("Петров", 100.50f);
        moneys.put("Сидоров", 220.0f);

        //обойти все пары в карте
        //1. Через ключи
        for (String key: moneys.keySet()) {
            System.out.printf("%s -> %s %n", key, moneys.get(key));
        }

        Set<String> keys = new HashSet<>();
        keys.add("Петров");
        keys.add("Иванов");
        for (String key : keys){
            Float money = moneys.get(key);
            System.out.printf("%s -> %s%n", key, money);
        }


        //2. Через пары ключ-значение
        for (Map.Entry<String, Float> entry : moneys.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }


        //Хэш-таблица - карта, в которой нет порядка между ключами
        //зато скорость быстрее, чем TreeMap
        HashMap<String, Float> bonuses = new HashMap<>(32); //Количество корзин
        bonuses.put("Андрей", 100f);
        bonuses.put("Алексей", 2000f);

        bonuses.putAll(moneys);
        System.out.printf("Хэш-мэп%n");
        for (Map.Entry<String, Float> entry : bonuses.entrySet()){
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

        //карта для людей, у котрых есть свои домашние животные
        TreeMap<Human, List<Animal>> owners = new TreeMap<>(new HumanComparator());

        Human h1 = new Clerk("Иван Иванович Иванов", 10000);
        Human h2 = new Clerk("Петр Иванович Иванов", 12000);
        Human h3 = new Clerk("Василий Андреевич Федоров", 5000);

        owners.put(h1, new ArrayList<>());
        owners.get(h1).add(new Cat("Маркиза"));
        owners.get(h1).add(h3);
        for (Human human:owners.keySet()) {
            System.out.println("Животные " + human.getName());

        }


    }
}
