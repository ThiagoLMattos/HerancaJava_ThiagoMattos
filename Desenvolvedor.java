public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(nome, salario, departamento, cpf, dataNascimento); // Chama o construtor da classe pai 'Funcionario' para inicializar os atributos herdados
    }

    public void programar() {
        System.out.println("\n"+nome + " está programando."); //Método padrão Desenvolvedor
    }

    @Override //Sobrescrevendo o método herdado de 'Funcionario', exibindo o tipo do funcionário
    public void mostrarDados() {
        System.out.println("\n[Desenvolvedor]");
        super.mostrarDados();
    }
}
