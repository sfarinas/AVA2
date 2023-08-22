

  import java.util.Scanner;

  public class Aviao extends Veiculo {
      private String prefixo;
      private String dataRevisao;

      public Aviao(String prefixo, int capacidadeTanque, int numeroPassageiros, double preco, String dataRevisao) {
          super(capacidadeTanque, numeroPassageiros, preco);
          this.prefixo = prefixo;
          this.dataRevisao = dataRevisao;
      }

      public String getPrefixo() {
          return prefixo;
      }

      public void setPrefixo(String prefixo) {
          this.prefixo = prefixo;
      }

      public String getDataRevisao() {
          return dataRevisao;
      }

      public void setDataRevisao(String dataRevisao) {
          this.dataRevisao = dataRevisao;
      }

      public void imprimir() {
          System.out.println("Prefixo: " + prefixo);
          super.imprimir(); // Chamar o método imprimir da superclasse
          System.out.println("Data de Revisão: " + dataRevisao);
      }

      public void entrada() {
          Scanner scanner = new Scanner(System.in);

          try {
              System.out.print("Prefixo: ");
              prefixo = scanner.nextLine();

              // Chamar o método entrada da superclasse para os atributos herdados
              super.entrada();

              System.out.print("Data de Revisão: ");
              dataRevisao = scanner.nextLine();

              // Aqui você pode adicionar mais validações de entrada, se necessário

          } catch (Exception e) {
              System.out.println("Entrada inválida. Certifique-se de inserir valores corretos.");
          }
      }

      public void reajustarPreco(double percentual) {
          double novoPreco = getPreco() * (1 + percentual / 100);
          setPreco(novoPreco);
      }

  }


