import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

        
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
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
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0); 

        scanner.close();
    }
}
