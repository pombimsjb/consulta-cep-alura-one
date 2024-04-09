package com.pombimsjb.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeradorArquivo {
    private String nomeArquivo;
    private List dados;
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    public GeradorArquivo(String nomeArquivo, List dados) {
        this.nomeArquivo = nomeArquivo;
        this.dados = dados;
    }

    public void gerarArquivo() throws IOException {
        FileWriter escreveArquivo = new FileWriter(nomeArquivo+".txt");
        escreveArquivo.write(gson.toJson(dados));
        escreveArquivo.close();
        System.out.println("Arquivo gerado com sucesso!");
    }
}
