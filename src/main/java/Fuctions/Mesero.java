package Fuctions;

import Model.Restaurant;
import javafx.scene.layout.AnchorPane;

public class Mesero implements Runnable{
    private Restaurant restaurant;
    private AnchorPane padre;
    public Mesero(AnchorPane padre, Restaurant restaurant){
        this.restaurant=restaurant;
        this.padre=padre;
    }

    @Override
    public void run() {


        while (true){
            restaurant.servicioOrden();
        }
    }
}
