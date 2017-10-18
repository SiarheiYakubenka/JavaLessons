package by.itclass.lesson03_2009.Task03;

public class App {
    public static void main(String[] args) {


        Fraction a = new Fraction(2, 4);
        Fraction b = new Fraction(3, 4);
        Fraction c = new Fraction(1, 5);
        Fraction d = new Fraction(1, 3);

        System.out.println(a+"+"+b+"="+Fraction.summ(a,b));
        System.out.println(a+"-"+b+"="+Fraction.substract(a,b));
        System.out.println(c+"*"+d+"="+Fraction.muiltiplication(c,d));
        System.out.println(c+"/"+d+"="+Fraction.division(c,d));

    }
}
