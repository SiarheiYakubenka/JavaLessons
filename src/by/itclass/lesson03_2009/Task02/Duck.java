package by.itclass.lesson03_2009.Task02;

public class Duck {

    private int foodVolume,
                stomachVolume;

    public Duck(int stomachVolume){
        if (stomachVolume<=0){
            System.err.println("Объем желудка должен быть положительным");
        } else {

        foodVolume =0;
        this.stomachVolume = stomachVolume;
        }
    }

    public void eatingBread(int volumeOfEaten){

        if (volumeOfEaten<=0){
            System.err.println("Объем хлеба доложен быть положительным");
        }else {

        foodVolume += volumeOfEaten;
        if (foodVolume >= stomachVolume *0.9){

            System.out.println("Уточка больше не может кушать хлеб");
        }
    }
}
}
