package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * App.
 */
public class App {
  /**
   * Metodo main.
   */
  public static void main(String[] args) {
    App app = new App();
    app.iniciar();
  }

  /**
   * Inicia a aplicação para calcular a média ponderada das atividades.
   */
  public void iniciar() {
    Scanner scanner = new Scanner(System.in);

    int numeroAtividades = obterNumeroAtividades(scanner);

    String[] nomesAtividades = new String[numeroAtividades];
    double[] pesosAtividades = new double[numeroAtividades];
    double[] notasAtividades = new double[numeroAtividades];

    cadastrarAtividades(
        scanner,
        numeroAtividades,
        nomesAtividades,
        pesosAtividades,
        notasAtividades
    );

    double pesoTotal = calcularPesoTotal(pesosAtividades);
    double notaTotal = calcularNotaTotal(pesosAtividades, notasAtividades);
    double media = calcularMedia(pesoTotal, notaTotal);

    exibirResultado(media);

    scanner.close();
  }

  /**
   * Solicita ao usuário que digite a quantidade de atividades a serem cadastradas.
   *
   * @param scanner O Scanner para receber a entrada do usuário.
   * @return A quantidade de atividades a serem cadastradas.
   */
  private int obterNumeroAtividades(Scanner scanner) {
    System.out.println("Digite a quantidade de atividades para cadastrar: ");
    return Integer.parseInt(scanner.nextLine());
  }

  /**
   * Registra as informações das atividades fornecidas pelo usuário.
   *
   * @param scanner O Scanner para receber a entrada do usuário.
   * @param numeroAtividades O número total de atividades a serem cadastradas.
   * @param nomesAtividades Um array para armazenar os nomes das atividades.
   * @param pesosAtividades Um array para armazenar os pesos das atividades.
   * @param notasAtividades Um array para armazenar as notas das atividades.
   */
  private void cadastrarAtividades(Scanner scanner, int numeroAtividades, String[] nomesAtividades,
      double[] pesosAtividades, double[] notasAtividades) {
    for (int i = 0; i < numeroAtividades; i++) {
      System.out.println("Digite o nome da atividade " + (i + 1) + ": ");
      nomesAtividades[i] = scanner.nextLine();
      System.out.println("Digite o peso da atividade " + (i + 1) + ": ");
      pesosAtividades[i] = Double.parseDouble(scanner.nextLine());
      System.out.println("Digite a nota obtida para " + nomesAtividades[i] + ": ");
      notasAtividades[i] = Double.parseDouble(scanner.nextLine());
    }
  }

  /**
   * Calcula o peso total das atividades.
   *
   * @param pesosAtividades Um array contendo os pesos das atividades.
   * @return O peso total das atividades.
   */
  private double calcularPesoTotal(double[] pesosAtividades) {
    double pesoTotal = 0;
    for (double peso : pesosAtividades) {
      pesoTotal += peso;
    }
    return pesoTotal;
  }

  /**
   * Calcula a nota total das atividades.
   *
   * @param pesosAtividades Um array contendo os pesos das atividades.
   * @param notasAtividades Um array contendo as notas das atividades.
   * @return A nota total das atividades.
   */
  private double calcularNotaTotal(double[] pesosAtividades, double[] notasAtividades) {
    double notaTotal = 0;
    for (int i = 0; i < pesosAtividades.length; i++) {
      notaTotal += (pesosAtividades[i] * notasAtividades[i]) / 100;
    }
    return notaTotal;
  }

  /**
   * Calcula a média ponderada das notas das atividades.
   *
   * @param pesoTotal O peso total das atividades.
   * @param notaTotal A nota total das atividades.
   * @return A média ponderada das notas das atividades.
   */
  private double calcularMedia(double pesoTotal, double notaTotal) {
    if (pesoTotal != 100) {
      System.out.println("A soma dos pesos é diferente de 100!");
    }

    return (notaTotal * 100) / pesoTotal;
  }

  /**
   * Exibe o resultado da análise das notas, indicando se o aluno foi aprovado ou não.
   *
   * @param media A média ponderada das notas das atividades.
   */
  private void exibirResultado(double media) {
    if (media >= 85.0) {
      System.out.printf("Parabéns! Você alcançou %.1f%%! E temos o prazer "
          + "de informar que você obteve aprovação!%n", media);
    } else {
      System.out.printf("Lamentamos informar que, com base na sua pontuação"
          + " alcançada neste período, %.1f%%, você não atingiu a pontuação "
          + "mínima necessária para sua aprovação.%n", media);
    }
  }
}
