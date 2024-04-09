import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pombimsjb.model.Cep;
import com.pombimsjb.model.CepViaCep;
import com.pombimsjb.model.Consulta;
import com.pombimsjb.model.GeradorArquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);

        List<Cep> pesquisas = new ArrayList<>();
        String busca = "";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o cep para efetuar a busca: Ex. 14600000");
            busca = leitor.nextLine();

            if(busca.equalsIgnoreCase("sair")) {
                break;
            }
            Consulta conexao = new Consulta(busca);
            String json = conexao.consumirApi();
            CepViaCep dadosCep = gson.fromJson(json, CepViaCep.class);


            Cep consultaCep = new Cep(dadosCep);
            pesquisas.add(consultaCep);

        }
        System.out.println("Digite o nome do arquivo para gerar.");
        var nomeArquivo = leitor.next();
        GeradorArquivo geradorArquivo = new GeradorArquivo(nomeArquivo, pesquisas);
        geradorArquivo.gerarArquivo();


    }
}
