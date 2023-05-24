import java.util.Random;

public class SemHash {
    public static void main(String[] args) {
        Random random = new Random();
        String[][] teste = new String[100000][2];

        final long comecoGeracao = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            String nome = "";
            for (int j = 0; j < 3; j++) {
                int ascii = random.nextInt(65, 91);
                char letra = (char) ascii;
                nome = nome + letra;
            }
            int idade = random.nextInt(0, 100);
            teste[i][0] = nome;
            teste[i][1] = String.valueOf(idade);
        }
        teste[99999][0] = "MMM";
        teste[99999][1] = "19";

        final long finalGeracao = System.nanoTime() - comecoGeracao;

        final long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            System.out.println(teste[i][0] + "=" + teste[i][1]); //printa todos os nomes
        }
        final long duration = System.nanoTime() - startTime;

        final long pesquisaInicio = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            if (teste[i][0] == "MMM") {
                System.out.println("MMM encontrado, idade: " + teste[i][1]);
            }
        }
        final long pesquisaTotal = System.nanoTime() - pesquisaInicio;


        System.out.println("Tempo de geração: " + finalGeracao);
        System.out.println("Tempo de print: " + duration);
        System.out.println("Tempo de pesquisa: " + pesquisaTotal);
    }
}
