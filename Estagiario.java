public class Estagiario extends Funcionario {

    public Estagiario(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(nome, salario, departamento, cpf, dataNascimento); // Chama o construtor da classe pai 'Funcionario' para inicializar os atributos herdados
    }

    public void fazerTarefa() {
        System.out.println("\n"+nome + " está fazendo uma tarefa."); //Método padrão Estagiário
    }

    @Override //Sobrescrevendo o método herdado de 'Funcionario', exibindo o tipo do funcionário
    public void mostrarDados() {
        System.out.println("\n[Estagiário]");
        super.mostrarDados();
    }
}
