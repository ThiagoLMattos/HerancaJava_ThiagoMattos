public class Gerente extends Funcionario {

    public Gerente(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(nome, salario, departamento, cpf, dataNascimento); // Chama o construtor da classe pai 'Funcionario' para inicializar os atributos herdados
    }

    public void realizarReuniao() {
        System.out.println("\n"+nome + " está realizando uma reunião."); //Método padrão Gerente
    }

    @Override //Sobrescrevendo o método herdado de 'Funcionario', exibindo o tipo do funcionário
    public void mostrarDados() {
        System.out.println("\n[Gerente]");
        super.mostrarDados();
    }
}
