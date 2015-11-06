package com.redhat.gpe.service;

import com.cdyne.ws.weatherws.Weather;
import com.cdyne.ws.weatherws.WeatherReturn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by samueltauil on 11/6/15.
 */
@WebServlet(value="/test")
public class ExampleService extends HttpServlet {
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String zip = request.getParameter("zip");

        Weather weather = new Weather();
        WeatherReturn weatherReturn = weather.getWeatherSoap().getCityWeatherByZIP(zip);

        PrintWriter out = response.getWriter();
        out.println("--------------------------------------------------------------");
        out.println(weatherReturn.getCity() + " - " + weatherReturn.getState());
        out.println("Description: " + weatherReturn.getDescription());
        out.println("Pressure: " + weatherReturn.getPressure());
        out.println("Relative Humidity: " + weatherReturn.getRelativeHumidity() + "%");
        out.println("Temperature: " + weatherReturn.getTemperature() + "°F");
        out.println("Wind: " + weatherReturn.getWind());
        out.println("--------------------------------------------------------------");


    }



}
