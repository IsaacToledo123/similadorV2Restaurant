package Fuctions;

import Model.Client;
import Model.Restaurant;
import javafx.scene.layout.AnchorPane;
import Controller.Controller;

import java.util.concurrent.ThreadLocalRandom;

public class CreateClient implements Runnable {
    private AnchorPane anchor;
    private Restaurant restaurant;
    private Controller controller;

    public CreateClient(AnchorPane anchor, Restaurant restaurant, Controller controller) {
        this.anchor = anchor;
        this.restaurant = restaurant;
        this.controller = controller;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Client client = new Client(anchor, restaurant);
            Thread clientThread = new Thread(client);
            clientThread.setName("Client " + (i + 1));

            double waitTime = calculatePoissonWaitTime(2.0);
            try {
                Thread.sleep((long) waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clientThread.setDaemon(true);
            clientThread.start();
        }
    }

    private double calculatePoissonWaitTime(double lambda) {
        double u = ThreadLocalRandom.current().nextDouble();
        return -Math.log(u) / lambda * 5000;
    }
}
