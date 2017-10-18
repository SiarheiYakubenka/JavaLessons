package by.itclass.lesson06_1110.exceptions;

/*
    Собственный класс исключения, возникающий тогда, когда при вызове метода
    вызывающий передал  отрицательное число
 */
public class NegativeNumberException extends  RuntimeException{

    public String getValueName() {
        return valueName;
    }

    private  String valueName;

    public NegativeNumberException(String message, String valueName){
        super((message));
        this.valueName= valueName;
    }
}
