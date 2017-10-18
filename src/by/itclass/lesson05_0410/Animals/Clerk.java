package by.itclass.lesson05_0410.Animals;

//Класс чиновник
public class Clerk extends  Human{

    public Clerk(String name, int salary) {
        super(name, salary);
    }

    @Override
    public String toString(){
        return "Чиновник "
                +getName()
                +"с зарпатой, которую ван не нужно знать";
    }
}
