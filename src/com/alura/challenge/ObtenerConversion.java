package com.alura.challenge;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObtenerConversion {

    Divisa convertir(String divisaBase, String divisaDestino, double cantidad) {

        String url = "https://v6.exchangerate-api.com/v6/10e1d162794e7b8318d708e4/pair/" + divisaBase + "/" + divisaDestino + "/" + cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try{
            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);

        }catch (Exception e){
            throw new RuntimeException("No se pudo realizar la conversion: " + e.getMessage());
        }


    }
}
