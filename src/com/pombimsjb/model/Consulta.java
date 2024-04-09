package com.pombimsjb.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    String busca;

    public Consulta(String busca) throws UnsupportedEncodingException {
        this.busca = busca;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String consumirApi() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(geraLink(busca)))
                .build();
        HttpResponse<String> response = cliente.send(request,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public String geraLink(String buscaCodificada) {
        return "https://viacep.com.br/ws/" + buscaCodificada + "/json/";
    }




}
