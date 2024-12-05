package Fuctions;

import Model.Restaurant;

public class Receptionista implements Runnable{
    private Restaurant restaurant;
    public Receptionista(Restaurant restaurant){
        this.restaurant=restaurant;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            restaurant.recepcion();

        }
    }
}
