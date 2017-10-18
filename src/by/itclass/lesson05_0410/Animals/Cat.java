package by.itclass.lesson05_0410.Animals;

public class Cat extends Animal {


    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Кошка по имени "+getName();
    }
}
