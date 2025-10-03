package org.blyweertboukari.soap;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;

@WebService(serviceName="Calculator")
public class CalculatorService {
    @WebMethod(operationName="Add", action="http://tempuri.org/Add")
    @WebResult(name = "AddResult")
    public int add(@WebParam(name="intA") int a, @WebParam(name="intB") int b) {
        return a + b;
    }

    @WebMethod(operationName="Subtract", action = "http://tempuri.org/Subtract")
    @WebResult(name="SubtractResult")
    public int subtract(@WebParam(name="intA") int a, @WebParam(name="intB") int b) {
        return a - b;
    }

    @WebMethod(operationName="Multiply", action = "http://tempuri.org/Multiply")
    @WebResult(name="MultiplyResult")
    public int multiply(@WebParam(name="intA") int a, @WebParam(name="intB") int b) {
        return a * b;
    }

    @WebMethod(operationName="Divide", action = "http://tempuri.org/Divide")
    @WebResult(name="DivideResult")
    public int divide(@WebParam(name="intA") int a, @WebParam(name="intB") int b) {
        return a / b;
    }
}