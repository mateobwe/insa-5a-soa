package org.blyweertboukari.soap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

import java.net.InetSocketAddress;

public class WsdlToJava {
    public static class CoursType {
        private final String intitule;
        private final int ects;
        private final String nomResponsable;

        public CoursType(String intitule, int ects, String nomResponsable) {
            this.intitule = intitule;
            this.ects = ects;
            this.nomResponsable = nomResponsable;
        }

        public String getIntitule() {
            return this.intitule;
        }

        public int getEcts() {
            return this.ects;
        }

        public String getNomResponsable() {
            return this.nomResponsable;
        }

        @Override
        public String toString() {
            return "CoursType{" + "intitule=\"" + this.intitule + "\", ects=" + this.ects + ", nomResponsable=\"" + this.nomResponsable + "\"}";
        }
    }

    static class GetCoursHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            int coursCode = Integer.parseInt(exchange.getRequestURI().getQuery().split("=")[1]);
            CoursType cours = getCours(coursCode);
            String response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + cours;
            sendResponse(exchange, response);
        }
    }

    static class GetNomEnseignantHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            int idProf = Integer.parseInt(exchange.getRequestURI().getQuery().split("=")[1]);
            String response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + getNomEnseignant(idProf);
            sendResponse(exchange, response);
        }
    }

    private static void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public static CoursType getCours(int coursCode) {
        return new CoursType("Cours", 10, "Yacine");
    }

    public static String getNomEnseignant(int idProf) {
        return "Nawal GUERMOUCHE";
    }

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext("/UnivWSApplication/UnivWS/getCours", new GetCoursHandler());
            server.createContext("/UnivWSApplication/UnivWS/getNomEnseignant", new GetNomEnseignantHandler());

            server.setExecutor(null);
            server.start();

            System.out.println("Server is running on port " + server.getAddress().getPort());
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }
}
