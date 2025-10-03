package org.blyweertboukari.soap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.blyweertboukari.soap.wsdltojava.CountryInfoService;
import org.blyweertboukari.soap.wsdltojava.CountryInfoServiceSoapType;

public class CountryInfoClient {
    public static void main(String args[]) throws MalformedURLException {
        final String serviceAddress = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";

        final URL url = URI.create(serviceAddress).toURL();

        final CountryInfoService service = new CountryInfoService(url);

        final CountryInfoServiceSoapType port = service.getPort(CountryInfoServiceSoapType.class);

        System.out.println(port.countryName("FR"));
    }
}
