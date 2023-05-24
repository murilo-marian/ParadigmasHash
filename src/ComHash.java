import java.util.HashMap;
import java.util.Random;

public class ComHash {
    public static void main(String[] args) {
        Random random = new Random();
        HashMap teste = new HashMap();

        final long comecoGeracao = System.nanoTime();
        for (int i = 0; i < 100000; i++) { //gera 10000 nomes e idades aleatórios e os coloca no map
            String nome = "";
            for (int j = 0; j < 3; j++) { //gera 3 letras aleatória para o nome
                int ascii = random.nextInt(65, 91);
                char letra = (char) ascii;
                nome = nome + letra;
            }
            int idade = random.nextInt(0, 100);
            teste.put(nome, idade);
        }
        teste.put("MMM", 19);
        final long finalGeracao = System.nanoTime() - comecoGeracao;

        final long startTime = System.nanoTime();
        System.out.println(teste);
        final long duration = System.nanoTime() - startTime;

        final long pesquisaInicio = System.nanoTime();
        System.out.println("pesquisa");
        System.out.println(teste.get("MMM"));
        final long pesquisaTotal = System.nanoTime() - pesquisaInicio;

        System.out.println("Tempo de geração: " + finalGeracao);
        System.out.println("Tempo de print: " + duration);
        System.out.println("Tempo de pesquisa: " + pesquisaTotal);
    }
}
