package by.itclass.lesson05_0410.Animals;


public class Animal {

    //поле "имя"  - у каждого животного есть имя
    //модификатор final перед полем, то поле становиться только для чтения
    //можно изменить только в конструкторе
    private final String name;

    //при создании объекта "животное" имя выдаетися на всю жизнь
    public  Animal(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Животное по имени " +name;
    }

    public String getName() {
        return name;
    }
}
