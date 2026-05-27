package com.stepdefinitions.compras;

import com.models.PlaceOrderData;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTypes {

    @DataTableType
    public PlaceOrderData placeOrderData(Map<String, String> entry) {

        PlaceOrderData data = new PlaceOrderData();

        data.setName(entry.get("name"));
        data.setCountry(entry.get("country"));
        data.setCity(entry.get("city"));
        data.setCreditCard(entry.get("creditCard"));
        data.setMonth(entry.get("month"));
        data.setYear(entry.get("year"));

        return data;
    }
}
