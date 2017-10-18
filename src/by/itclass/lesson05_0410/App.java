package by.itclass.lesson05_0410;

public class App {
    public static void main(String[] args) {
        //Переменная типа перечисления
        Answer a = Answer.YES;
        a = Answer.NO;
        a = Answer.CANCEL;
        //нельзя назначить число
        // а = 0;
        //нелзьзя назначить неизвестную константу
        //a = Annswer.MAYBY;

        Fruit fruit = Fruit.GRAPEFRUIT;
        System.out.println(fruit);
        System.out.println(fruit.getPrice());
    }
}
