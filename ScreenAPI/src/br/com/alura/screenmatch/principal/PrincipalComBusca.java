package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o filtro da busca: ");
        var busca = scan.nextLine();
        String key = "e163085a";
        String endereço = String.format("https://www.omdbapi.com/?t=%s&apikey=%s", busca, key);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requenst = HttpRequest.newBuilder()
                .uri(URI.create(endereço))
                .build();
        HttpResponse<String> response = client
                .send(requenst, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
