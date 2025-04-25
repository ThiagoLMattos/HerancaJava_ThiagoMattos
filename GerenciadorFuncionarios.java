import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFuncionarios {
    
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarFuncionario() {
        System.out.println("\n\nEscolha o tipo de funcionário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Desenvolvedor");
        System.out.println("3 - Estagiário");
        
        int tipo = scanner.nextInt(); 
        scanner.nextLine(); 

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Salário: ");
        double salario = scanner.nextDouble(); 
        scanner.nextLine(); 

        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        Funcionario tipoFuncionario = null;

        switch (tipo) {
            case 1:
                tipoFuncionario = new Gerente(nome, salario, departamento, cpf, dataNascimento);
                break;
            case 2:
                tipoFuncionario = new Desenvolvedor(nome, salario, departamento, cpf, dataNascimento);
                break;
            case 3:
                tipoFuncionario = new Estagiario(nome, salario, departamento, cpf, dataNascimento);
                break; 
            default:
                System.out.println("znTipo inválido."); 
        }

        if (tipoFuncionario != null) {
            funcionarios.add(tipoFuncionario);
            System.out.println("\nFuncionário cadastrado com sucesso.");
        }
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado.");
            return;
        }

        int i = 1;

        for (Funcionario tipoFuncionario : funcionarios) {
            System.out.println("\n"+ i+" - ");
            tipoFuncionario.mostrarDados();
            i++;
        }
    }


    public void executarAcoes() {
        // Listar funcionários
        listarFuncionarios();
        
        System.out.print("\nEscolha o número do funcionário para realizar a ação: ");
        int escolhaFuncionario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verifica se a escolha é válida
        if (escolhaFuncionario < 0 || escolhaFuncionario > funcionarios.size()) {
            System.out.println("\nFuncionário inválido.");
            return;
        }

        Funcionario funcionarioEscolhido = funcionarios.get(escolhaFuncionario - 1); // Seleciona o funcionário

        // Exibe o menu de ações
        System.out.println("\n\nEscolha a ação para o funcionário: ");
        System.out.println("1 - Bater ponto");
        System.out.println("2 - Realizar ação de Gerente");
        System.out.println("3 - Realizar ação de Desenvolvedor");
        System.out.println("4 - Realizar ação de Estagiário");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Realiza a ação de acordo com a escolha do usuário
        switch (tipo) {
            case 1:
                // Bate ponto para o funcionário selecionado
                funcionarioEscolhido.baterPonto();
                break;
            case 2:
                if (funcionarioEscolhido instanceof Gerente) {
                    ((Gerente) funcionarioEscolhido).realizarReuniao();
                } else {
                    System.out.println("\nEste funcionário não é um Gerente.");
                }
                break;
            case 3:
                if (funcionarioEscolhido instanceof Desenvolvedor) {
                    ((Desenvolvedor) funcionarioEscolhido).programar();
                } else {
                    System.out.println("\nEste funcionário não é um Desenvolvedor.");
                }
                break;
            case 4:
                if (funcionarioEscolhido instanceof Estagiario) {
                    ((Estagiario) funcionarioEscolhido).fazerTarefa();
                } else {
                    System.out.println("\nEste funcionário não é um Estagiário.");
                }
                break;
            default:
                System.out.println("\nAção inválida.");
        }
    }
}
