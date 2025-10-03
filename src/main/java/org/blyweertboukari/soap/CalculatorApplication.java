package org.blyweertboukari.soap;

import jakarta.xml.ws.Endpoint;

public class CalculatorApplication {

    public final static String host = "localhost";
    public final static int port = 8080;

    public void startService() {
        String url = "http://" + host + ":" + port + "/";
        Endpoint.publish(url, new CalculatorService());
    }

    public static void main(String[] args) {
        CalculatorApplication app = new CalculatorApplication();
        app.startService();
        System.out.println("Service started...");
    }
}
