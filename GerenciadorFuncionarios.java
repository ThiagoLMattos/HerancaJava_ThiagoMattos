import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFuncionarios {
    
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarFuncionario() {
        System.out.println("Escolha o tipo de funcionário:");
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
            case 1 -> tipoFuncionario = new Gerente(nome, salario, departamento, cpf, dataNascimento);
            case 2 -> tipoFuncionario = new Desenvolvedor(nome, salario, departamento, cpf, dataNascimento);
            case 3 -> tipoFuncionario = new Estagiario(nome, salario, departamento, cpf, dataNascimento); 
            default -> System.out.println("Tipo inválido."); 
        }

        if (tipoFuncionario != null) {
            funcionarios.add(tipoFuncionario);
            System.out.println("Funcionário cadastrado com sucesso.");
        }
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario tipoFuncionario : funcionarios) {
            tipoFuncionario.mostrarDados();
        }
    }

    public void executarAcoes() {
        // Listar funcionários
        listarFuncionarios();
        
        System.out.print("Escolha o número do funcionário para realizar a ação: ");
        int escolhaFuncionario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verifica se a escolha é válida
        if (escolhaFuncionario < 1 || escolhaFuncionario > funcionarios.size()) {
            System.out.println("Funcionário inválido.");
            return;
        }

        Funcionario funcionarioEscolhido = funcionarios.get(escolhaFuncionario - 1); // Seleciona o funcionário

        // Exibe o menu de ações
        System.out.println("Escolha a ação para o funcionário " + funcionarioEscolhido.getNome() + ":");
        System.out.println("1 - Realizar ação de Gerente");
        System.out.println("2 - Realizar ação de Desenvolvedor");
        System.out.println("3 - Realizar ação de Estagiário");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Realiza a ação de acordo com o tipo de funcionário selecionado
        switch (tipo) {
            case 1:
                if (funcionarioEscolhido instanceof Gerente) {
                    ((Gerente) funcionarioEscolhido).realizarReuniao();
                } else {
                    System.out.println("Este funcionário não é um Gerente.");
                }
                break;
            case 2:
                if (funcionarioEscolhido instanceof Desenvolvedor) {
                    ((Desenvolvedor) funcionarioEscolhido).programar();
                } else {
                    System.out.println("Este funcionário não é um Desenvolvedor.");
                }
                break;
            case 3:
                if (funcionarioEscolhido instanceof Estagiario) {
                    ((Estagiario) funcionarioEscolhido).fazerTarefa();
                } else {
                    System.out.println("Este funcionário não é um Estagiário.");
                }
                break;
            default:
                System.out.println("Ação inválida.");
        }
    }
}
