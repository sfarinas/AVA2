

  import java.util.Scanner;

  public class Navio extends Veiculo {
      private String nome;
      private int numeroTripulantes;
      private String dataLancamento;

      public Navio(String nome, int capacidadeTanque, int numeroPassageiros, double preco, int numeroTripulantes, String dataLancamento) {
          super(capacidadeTanque, numeroPassageiros, preco);
          this.nome = nome;
          this.numeroTripulantes = numeroTripulantes;
          this.dataLancamento = dataLancamento;
      }

      public String getNome() {
          return nome;
      }

      public void setNome(String nome) {
          this.nome = nome;
      }

      public int getNumeroTripulantes() {
          return numeroTripulantes;
      }

      public void setNumeroTripulantes(int numeroTripulantes) {
          this.numeroTripulantes = numeroTripulantes;
      }

      public String getDataLancamento() {
          return dataLancamento;
      }

      public void setDataLancamento(String dataLancamento) {
          this.dataLancamento = dataLancamento;
      }

      public void imprimir() {
          System.out.println("Nome: " + nome);
          super.imprimir(); // Chamar o método imprimir da superclasse
          System.out.println("Número de Tripulantes: " + numeroTripulantes);
          System.out.println("Data de Lançamento: " + dataLancamento);
      }

      public void entrada() {
          Scanner scanner = new Scanner(System.in);

          try {
              System.out.print("Nome: ");
              nome = scanner.nextLine();

              // Chamar o método entrada da superclasse para os atributos herdados
              super.entrada();

              System.out.print("Número de Tripulantes: ");
              numeroTripulantes = scanner.nextInt();

              scanner.nextLine(); // Limpar a nova linha pendente

              System.out.print("Data de Lançamento: ");
              dataLancamento = scanner.nextLine();

              // validações de entrada

          } catch (Exception e) {
              System.out.println("Entrada inválida. Certifique-se de inserir valores corretos.");
          }
      }

      public double passageirosPorTripulantes() {
          if (numeroTripulantes != 0) {
              return (double) numeroPassageiros / numeroTripulantes;
          } else {
              return 0.0;
          }
      }
  }



