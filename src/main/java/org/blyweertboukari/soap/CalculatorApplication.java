package org.blyweertboukari.soap;

import jakarta.xml.ws.Endpoint;

public class CalculatorApplication {

    public final static String host = "localhost";
    public final static int port1 = 8080;
    public final static int port2 = 8081;

    public void startService() {
        String url1 = "http://"+host+":"+port1+"/";
        String url2 = "http://"+host+":"+port2+"/";
        CalculatorService service = new CalculatorService();
        Endpoint.publish(url1, service);
        Endpoint.publish(url2, service);
    }

    public static void main(String[] args) {
        CalculatorApplication app = new CalculatorApplication();
        app.startService();
        System.out.println("Service started...");
    }
}
