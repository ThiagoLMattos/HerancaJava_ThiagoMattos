import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFuncionarios {
    
    private ArrayList<Funcionario> funcionarios = new ArrayList<>(); //Criação de uma ArrayLists de objetos da classe 'Funcionario'
    private Scanner scanner = new Scanner(System.in); //Criação de um Scanner para entrada de dados

    public void cadastrarFuncionario() { //Interface
        System.out.println("\n\nEscolha o tipo de funcionário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Desenvolvedor");
        System.out.println("3 - Estagiário");
        //Switch case para definir o tipo do funcionario
        
        int tipo = scanner.nextInt(); 
        scanner.nextLine();  //Reinicia o scanner

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Salário: ");
        double salario = scanner.nextDouble(); 
        scanner.nextLine(); //Reinicia o scanner

        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        Funcionario tipoFuncionario = null; //Váriavel do tipo 'Funcionario' para armazenar o objeto criado conforme o tipo

        switch (tipo) { //Switch case para definir o tipo do funcionario 
            //Com base no tipo de funcionário, armazena o objeto
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
                System.out.println("\nTipo inválido."); 
        }

        if (tipoFuncionario != null) { //Caso 'tipoFuncionario' adquira um valor, criar o objeto por meio do arraylist
            funcionarios.add(tipoFuncionario);
            System.out.println("\nFuncionário cadastrado com sucesso.");
        }
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado."); //Caso não há funcionarios cadastrados, exibir a mensagem
            return;
        }

        int i = 1;

        for (Funcionario tipoFuncionario : funcionarios) { //Foreach que percorre a lista de funcionários e mostra os dados
            System.out.println("\n"+ i+" - ");
            tipoFuncionario.mostrarDados(); //Utilizar o método do classe Pai 'Funcionario' que exibirá os dados de todos funcionários cadastrados, juntamente ao indice
            i++;
        }
    }


    public void executarAcoes() {
        listarFuncionarios(); //Exibe os funcionários cadastrados juntos ao índice
        
        System.out.print("\nEscolha o número do funcionário para realizar a ação: ");
        int escolhaFuncionario = scanner.nextInt();
        scanner.nextLine(); //Reinicia o Scanner

        if (escolhaFuncionario < 1 || escolhaFuncionario > funcionarios.size()) { //Verificação se o índice existe
            System.out.println("\nFuncionário inválido.");
            return;
        }

        Funcionario funcionarioEscolhido = funcionarios.get(escolhaFuncionario - 1); //Seleciona o funcionário pelo índice / Correção do índice na interface para o índice do array

        System.out.println("\n\nEscolha a ação para o funcionário: "); //Opções
        System.out.println("1 - Bater ponto");
        System.out.println("2 - Realizar ação de Gerente");
        System.out.println("3 - Realizar ação de Desenvolvedor");
        System.out.println("4 - Realizar ação de Estagiário");

        int tipo = scanner.nextInt();
        scanner.nextLine();//Reinicia o Scanner

        switch (tipo) { //Switch case para realizar a ação escolhida
            case 1:
                funcionarioEscolhido.baterPonto(); //Método da classe Pai 'Funcionario'
                break;
            case 2:
                if (funcionarioEscolhido instanceof Gerente) { 
                    ((Gerente) funcionarioEscolhido).realizarReuniao(); //Caso o funcionário escolhido seja um Gerente, realiza o método da classe 'Gerente'
                } else {
                    System.out.println("\nEste funcionário não é um Gerente.");
                }
                break;
            case 3:
                if (funcionarioEscolhido instanceof Desenvolvedor) {
                    ((Desenvolvedor) funcionarioEscolhido).programar(); //Caso o funcionário escolhido seja um Desenvolvedor, realiza o método da classe 'Desenvolvedor'
                } else {
                    System.out.println("\nEste funcionário não é um Desenvolvedor.");
                }
                break;
            case 4:
                if (funcionarioEscolhido instanceof Estagiario) {
                    ((Estagiario) funcionarioEscolhido).fazerTarefa(); //Caso o funcionário escolhido seja um Estagiário, realiza o método da classe 'Estagiário'
                } else {
                    System.out.println("\nEste funcionário não é um Estagiário.");
                }
                break;
            default:
                System.out.println("\nAção inválida.");
        }
    }
}
