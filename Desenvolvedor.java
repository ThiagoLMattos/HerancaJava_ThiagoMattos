public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(nome, salario, departamento, cpf, dataNascimento);
    }

    public void programar() {
        System.out.println("\n"+nome + " está programando.");
    }

    @Override
    public void mostrarDados() {
        System.out.println("\n[Desenvolvedor]");
        super.mostrarDados();
    }
}
