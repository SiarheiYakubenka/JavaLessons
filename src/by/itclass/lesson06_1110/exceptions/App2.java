package by.itclass.lesson06_1110.exceptions;

/**
 * Created by IT Class on 11.10.2017.
 */
public class App2 {
    public static void main(String[] args) {

        try {

             sum(1,-1);
        }catch (NegativeNumberException e){
            System.out.println("Переменная - "+e.getValueName()+" "+e.getMessage());
        }finally {
            System.out.println("Fanally");
        }

    }
    public static int sum(int a , int b){
        if (a<0){
            //для выброса ошибки
            throw new NegativeNumberException("Отрицательное число", "a");
        }else  if(b<0){
            NegativeNumberException ne = new NegativeNumberException("Отрицательное число", "b");
            throw ne;
        }else {
            return  a+b;
        }
    }
    //Для проверяемых исключений, если мы не хотим или не можем обрабатывать
    //ее в том же методе, в котором она проявилась, то можно пробросить ее наверх с помощью конструкции throws
    public  void  testExceptione() throws Exception {
        throw new Exception("Test");
    }
}
