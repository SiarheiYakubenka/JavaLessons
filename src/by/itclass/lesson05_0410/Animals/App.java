package by.itclass.lesson05_0410.Animals;


public class App {
    public static void main(String[] args) {

        Animal a1 = new Animal("Кеша");

        System.out.println(a1);
        System.out.println(a1.getName());

        Animal a2 = new Animal("Кузя");

        System.out.println(a2);
        System.out.println(a2.getName());

        Human h1 = new Human("Андрей", 100);

        System.out.println(h1);
        System.out.println(h1.getSalary());
        System.out.println(h1.getName());

        Worker w1 = new Worker("Петр", 200);

        System.out.println(w1);
        System.out.println(w1.getSalary());
        System.out.println(w1.getName());

        Clerk c1 = new Clerk("Иван Васильевич", 5000);
        System.out.println(c1);
        //System.out.println(wc1.getSalary());
        System.out.println(c1.getName());


        Animal a = a1;
        //не смотря на то, что все объекты являются объектами различных классов, все они наследуются
        //от класса Animal, и по ссылке "а" класса Animal мы можем обращаться только к полям и методам класса Animal
        System.out.println(a);
        a = a2;
        System.out.println(a);
        a = h1;
        System.out.println(a);
        //System.out.println(a.getName());
        a= w1;
        System.out.println(a);
        a= c1;
        System.out.println(a);

        a = new Cat("Маркиза");
        System.out.println(a);

        Cat cat1 = new Cat("Дарья");
        System.out.println(cat1);

        //Нельзя присвоить ссылки родительского класса или класса-соседа по иерархии
        //
        //cat1 = w1;
        //w1 = h1;


        //Используем приведение типов
        //1.Если в "а" лежит кошка, то все пройдет без ошибок
        //2.Если в "а" лежит объект друго типа, возникнет ошибка приведения классов(ClassCastException)
        cat1 = (Cat) a;


    }
}
