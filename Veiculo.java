  import java.util.Scanner;

  public class Veiculo {
      protected int capacidadeTanque;
      protected int numeroPassageiros;
      protected double preco;

      public Veiculo(int capacidadeTanque, int numeroPassageiros, double preco) {
          this.capacidadeTanque = capacidadeTanque;
          this.numeroPassageiros = numeroPassageiros;
          this.preco = preco;
      }

      public int getCapacidadeTanque() {
          return capacidadeTanque;
      }

      public void setCapacidadeTanque(int capacidadeTanque) {
          this.capacidadeTanque = capacidadeTanque;
      }

      public int getNumeroPassageiros() {
          return numeroPassageiros;
      }

      public void setNumeroPassageiros(int numeroPassageiros) {
          this.numeroPassageiros = numeroPassageiros;
      }

      public double getPreco() {
          return preco;
      }

      public void setPreco(double preco) {
          this.preco = preco;
      }

      public void imprimir() {
          System.out.println("Capacidade Tanque em Litros: " + capacidadeTanque);
          System.out.println("Número de Passageiros Unidade: " + numeroPassageiros);
          System.out.println("Preço R$ : " + preco);
      }

      public void entrada() {
          Scanner scanner = new Scanner(System.in);

          try {
              System.out.print("Capacidade Tanque em Litros: ");
              capacidadeTanque = scanner.nextInt();

              System.out.print("Número de Passageiros por Unidade: ");
              numeroPassageiros = scanner.nextInt();

              System.out.print("Preço R$: ");
              preco = scanner.nextDouble();

              // validações de entrada.

          } catch (Exception e) {
              System.out.println("Entrada inválida. Certifique-se de inserir valores numéricos corretos.");
          } finally {
              scanner.nextLine(); // Limpar a nova linha pendente
          }
      }
  }


