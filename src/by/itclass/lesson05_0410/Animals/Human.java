package by.itclass.lesson05_0410.Animals;


public class Human extends Animal{

    //Поле доступно только данному классу и его потомкам
    protected int salary;



    //Если в конструкторе нет вызова родительского конструктора через вызов super(...),
    //то компилятор автоматически подставит вызов родительского конструктора без параметроав
    //(super()). При отсутствии конструктора без параметров у родителья, необходимо через super(...)
    //обязательно вызвать существующий

    //Конструктор с параметрами, вызывающий такой же конструктор родительского класса
    public Human(String name, int salary){
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Человек по имени "+getName()+" c зарплатой "+salary+" рублей";
    }

    public int getSalary() {
        return salary;
    }
}
