
  import java.util.Scanner;
  import java.io.PrintWriter;
  import java.io.FileWriter;
  import java.io.IOException;

  public class Aplicacao {
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          Veiculo[] veiculos = new Veiculo[10]; // Utilizando a superclasse como tipo do vetor

          for (int i = 0; i < veiculos.length; i++) {
              System.out.println();
              System.out.println("Preencha os atributos do veículo " + (i + 1) + ":");

              String tipo;
              do {
                  System.out.print("Tipo de veículo (A para Avião / N para Navio): ");
                  tipo = scanner.nextLine();
              } while (!tipo.equalsIgnoreCase("A") && !tipo.equalsIgnoreCase("N"));


              if (tipo.equalsIgnoreCase("A")) {
                  Aviao aviao = criarAviao(scanner);
                  veiculos[i] = aviao;

                  System.out.print("Informe o percentual de reajuste: ");
                  double percentual = scanner.nextDouble();
                  aviao.reajustarPreco(percentual);

                  System.out.println("Preço do avião reajustado com sucesso.");
                  scanner.nextLine();
              }
              else if (tipo.equalsIgnoreCase("N")) {
                  veiculos[i] = criarNavio(scanner);
              }
          }



          // Criar o arquivo de relatório
          try (PrintWriter writer = new PrintWriter(new FileWriter("relatorio.txt"))) {
              for (Veiculo veiculo : veiculos) {
                  if (veiculo != null) {
                      writer.println("Tipo de Veículo: " + (veiculo instanceof Aviao ? "Avião" : "Navio")); // Utilizado instanceof, para verificacao do tipo de veiculo

                      if (veiculo instanceof Aviao){
                          writer.println("Prefixo: " + ((Aviao) veiculo).getPrefixo());
                      }else {
                          writer.println("Nome: "+ ((Navio) veiculo).getNome());
                      }
                      writer.println("Capacidade Tanque em Litros: " + veiculo.getCapacidadeTanque());
                      writer.println("Número de Passageiros Unidade: " + veiculo.getNumeroPassageiros());
                      writer.println("Preço R$ : " + veiculo.getPreco());

                      if (veiculo instanceof Navio) {
                          double passageirosPorTripulantes = calcularPassageirosPorTripulantes((Navio) veiculo);
                          writer.println("Passageiros por Tripulantes: " + passageirosPorTripulantes);
                      }

                      writer.println();
                  }
              }

              System.out.println("=======================================================");
              System.out.println("Relatório gerado com sucesso no arquivo 'relatorio.txt'");
              System.out.println("=======================================================");
          } catch (IOException e) {
              System.out.println("Erro ao gerar o relatório: " + e.getMessage());
          }

          // Imprimir os atributos dos veículos no console
          for (Veiculo veiculo : veiculos) {
              if (veiculo != null) {
                  System.out.println("Tipo de Veículo: " + (veiculo instanceof Aviao ? "Avião" : "Navio"));
                  veiculo.imprimir();
                  System.out.println();
                  if (veiculo instanceof Navio) {
                      double passageirosPorTripulantes = calcularPassageirosPorTripulantes((Navio) veiculo);
                      System.out.println("Passageiros por Tripulantes: " + passageirosPorTripulantes);
                  }
                  System.out.println();
              }
          }

          scanner.close();
      }

      public static Aviao criarAviao(Scanner scanner) {
          System.out.print("Prefixo: ");
          String prefixo = scanner.nextLine();

          int capacidadeTanque = lerInteiro(scanner, "Capacidade Tanque em Litros: ");
          int numeroPassageiros = lerInteiro(scanner, "Número de Passageiros em Unidade: ");
          double preco = lerDouble(scanner, "Preço R$: ");
          scanner.nextLine(); // Limpar a nova linha pendente

          String dataRevisao = lerData(scanner, "Data de Revisão (DD/MM/AAAA): ");

          return new Aviao(prefixo, capacidadeTanque, numeroPassageiros, preco, dataRevisao);

      }


      public static Navio criarNavio(Scanner scanner) {
          System.out.print("Nome: ");
          String nome = scanner.nextLine();

          int capacidadeTanque = lerInteiro(scanner, "Capacidade Tanque em Litros: ");
          int numeroPassageiros = lerInteiro(scanner, "Número de Passageiros em Unidade: ");
          double preco = lerDouble(scanner, "Preço R$: ");
          scanner.nextLine(); // Limpar a nova linha pendente

          int numeroTripulantes = lerInteiro(scanner, "Número de Tripulantes em Unidade: ");
          scanner.nextLine(); // Limpar a nova linha pendente

          String dataLancamento = lerData(scanner, "Data de Lançamento (DD/MM/AAAA): ");

          return new Navio(nome, capacidadeTanque, numeroPassageiros, preco, numeroTripulantes, dataLancamento);
      }

      public static int lerInteiro(Scanner scanner, String mensagem) {
          while (true) {
              try {
                  System.out.print(mensagem);
                  return scanner.nextInt();
              } catch (Exception e) {
                  System.out.println("Entrada inválida. Certifique-se de inserir um número inteiro válido.");
                  scanner.nextLine(); // Limpar a entrada inválida
              }
          }
      }

      public static double lerDouble(Scanner scanner, String mensagem) {
          while (true) {
              try {
                  System.out.print(mensagem);
                  return scanner.nextDouble();
              } catch (Exception e) {
                  System.out.println("Entrada inválida. Certifique-se de inserir um número válido.");
                  scanner.nextLine(); // Limpar a entrada inválida
              }
          }
      }

      public static String lerData(Scanner scanner, String mensagem) {
          while (true) {
              System.out.print(mensagem);
              String data = scanner.nextLine();

              if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
                  String[] partes = data.split("/");
                  int dia = Integer.parseInt(partes[0]);
                  int mes = Integer.parseInt(partes[1]);
                  int ano = Integer.parseInt(partes[2]);

                  if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1000) {
                      return data;
                  }
              }

              System.out.println("Formato de data inválido ou valores fora do intervalo permitido (DD/MM/AAAA).");
          }
      }

      public static double calcularPassageirosPorTripulantes(Navio navio) {
          if (navio.getNumeroTripulantes() != 0) {
              return (double) navio.getNumeroPassageiros() / navio.getNumeroTripulantes();
          } else {
              return 0.0;
          }
      }
  }



