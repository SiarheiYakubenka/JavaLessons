package by.itclass.lesson06_1110.exceptions;

public class App {
    public static void main(String[] args) {


        //В блок try мы помещаем инструкции, где могут возникнуить исключения
        try {
            int x = 4/0;
            testFinally();
            System.out.println("После деления на 0");
        }catch (ArithmeticException e){
            //блок catch реагирует на определенную ошибку
            System.out.println("Произошла ошибка :"+e.getMessage());
        }
          catch (NullPointerException e){
            //Каждый блок реагирует на свой тип ошибки
            System.out.println("Обращение к нулевому указателю");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            //Выполняется всегда, была ошибка или нет
            System.out.println("finally");
        }
    }
    public static  void  testFinally(){
        try {
            int x = 4/0;
        }catch (NullPointerException e){
           System.out.println(e.getMessage());
        }finally {
            System.out.println("test Fanally");
        }
    }
}
