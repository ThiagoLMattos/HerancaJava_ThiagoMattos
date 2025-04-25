import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios(); //Conexão com as funções GerenciadorFuncionarios.java

        
        Scanner scanner = new Scanner(System.in);
        int opcao;

        //Laço de repetição para o menu, que chama os métodos localizados em GerenciadorFuncionarios.java
        do {
            
            System.out.println("\n\nMenu:");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Realizar Ações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); 


            switch (opcao) {
                case 1:
                    gerenciador.cadastrarFuncionario(); 
                    break;
                case 2:
                    gerenciador.listarFuncionarios(); 
                    break;
            
                case 3:
                    gerenciador.executarAcoes();
                    break;
                case 0:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
            }
        } while (opcao != 0); 

        scanner.close();
    }
}
