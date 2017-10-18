package by.itclass.lesson03_2009.Task03;


public class Fraction {

      public int numerator;
      public int denominator;

    public Fraction()
    {
            this.numerator = 0;
            this.denominator = 1;
    }

    public Fraction(int numerator, int denominator)
    {
        if (denominator ==0) {
            System.err.println("Знаменатель равен 0");
        }else {
            int temp =gcd(numerator,denominator);
            denominator/=temp;
            numerator/=temp;
            this.numerator = numerator;
            this.denominator = denominator;


        }

    }

    @Override
    public  String toString()
    {
        return "(" + numerator + "/" + denominator + ")";
    }

    public static Fraction summ(Fraction a, Fraction b)
    {
        toOneDenom(a, b);

        Fraction temp = new Fraction();
        temp.numerator = a.numerator +  b.numerator;
        temp.denominator = a.denominator;

        return Fraction.SetFormat(temp);

    }
    public static Fraction substract(Fraction a, Fraction b)
    {
        toOneDenom(a, b);

        Fraction temp = new Fraction();
        temp.numerator = a.numerator -  b.numerator;
        temp.denominator = a.denominator;

        return Fraction.SetFormat(temp);

    }
    public static Fraction muiltiplication(Fraction a, Fraction b)
    {
        Fraction temp = new Fraction();
        temp.numerator = a.numerator * b.numerator;
        temp.denominator = a.denominator * b.denominator;

        return Fraction.SetFormat(temp);

    }
    public static Fraction division(Fraction a, Fraction b)
    {
        Fraction temp = new Fraction();
        temp.numerator = a.numerator * b.denominator;
        temp.denominator = a.denominator * b.numerator;

        return Fraction.SetFormat(temp);
    }

    //наибольший общий делитель
    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    //наименьшее общее кратное
    private static int lcm(int a, int b){
        return a/ gcd(a,b)*b;
    }

    //приведение к общему знаменателю
    private static void toOneDenom( Fraction a, Fraction b){

        int comDenom = lcm(a.denominator, b.denominator);
        a.numerator = a.numerator *(comDenom/a.denominator);
        b.numerator = b.numerator *(comDenom/b.denominator);
        a.denominator = comDenom;
        b.denominator = comDenom;

    }

    public static Fraction SetFormat(Fraction a) {

        int max;

        if (a.numerator > a.denominator)
            max = Math.abs(a.denominator);//берем по модулю, чтобы работало и с отрицательными
        else
            max = Math.abs(a.numerator);
        //поиск от максимума до 2
        for (int i = max; i >= 2; i--) {
         //такого числа, поделив на которое бы делилось без
         //остатка и на числитель и на знаменатель
            if ((a.numerator % i == 0) & (a.denominator % i == 0)) {
                a.numerator = a.denominator / i;
                a.denominator = a.denominator / i;
            }

        }
            //Определяемся со знаком
            //если в знаменателе минус, поднимаем его наверх
        if ((a.denominator < 0)) {

            a.numerator = -1 * (a.numerator);
            a.denominator = Math.abs(a.denominator);
        }
        return a;
    }
}


