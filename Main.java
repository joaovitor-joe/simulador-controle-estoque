package lacodowhile;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int estoque = 20;
        int estoqueMinimo = 5;
        int totalSaidas = 0;
        int totalReposicoes = 0;
        int unidadesMovimentadas = 0;

        int opcao;

        do {
            System.out.println("1 - Saída, 2 - Reposição, 3 - Consulta, 0 - Encerrar");
            System.out.print("Digite a opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Quantidada para saída: ");
                    int quantidadeSaida = sc.nextInt();

                    if (quantidadeSaida > 0 && quantidadeSaida <= estoque) {
                        estoque -= quantidadeSaida;
                        unidadesMovimentadas += quantidadeSaida;
                        totalSaidas++;
                    } else {
                        System.out.println("Valor insuficiente!");
                    }
                }

                case 2 -> {
                    System.out.print("Quantidade para repor: ");
                    int quantidadeRepor = sc.nextInt();

                    if (quantidadeRepor > 0) {
                        estoque += quantidadeRepor;
                        unidadesMovimentadas += quantidadeRepor;
                        totalReposicoes++;
                    } else {
                        System.out.println("O valor digitado tem que ser maior que zero!");
                    }
                }

                case 3 -> {
                    System.out.println("Estoque: " + estoque);
                    System.out.println("Estoque minimo: " + estoqueMinimo);

                    String consulta = estoque <= estoqueMinimo ? "Status: ALERTA (estoque baixo ou no mínimo" : "Status: NORMAL";
                    System.out.println(consulta);
                }

                default -> {
                    System.out.println("Você digitou uma opção que não tem!");
                    System.out.print("Digite uma opção novamente: ");
                    opcao = sc.nextInt();
                }
            }
        } while (opcao != 0);

        System.out.println("\n===== RELATÓRIO FINAL =====");

        System.out.println("Estoque final: " + estoque);
        System.out.println("Quantidade de saídas: " + totalSaidas);
        System.out.println("Quantidade de reposições: " + totalReposicoes);
        System.out.println("Unidades movimentadas: " + unidadesMovimentadas);

        sc.close();
    }

}
