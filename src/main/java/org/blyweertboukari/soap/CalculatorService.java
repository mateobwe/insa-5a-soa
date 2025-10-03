package org.blyweertboukari.soap;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName="Calculator")
public class CalculatorService {
    @WebMethod(operationName="Add")
    public int add(@WebParam(name="intA") int a, @WebParam(name="intB") int b) {
        return a + b;
    }

    @WebMethod(operationName="Subtract")
    public int subtract(@WebParam(name="intA") int a, @WebParam(name="intB") int b) {
        return a - b;
    }

    @WebMethod(operationName="Multiply")
    public int multiply(@WebParam(name="intA") int a, @WebParam(name="intB") int b) {
        return a * b;
    }

    @WebMethod(operationName="Divide")
    public int divide(@WebParam(name="intA") int a, @WebParam(name="intB") int b) {
        return a / b;
    }
}