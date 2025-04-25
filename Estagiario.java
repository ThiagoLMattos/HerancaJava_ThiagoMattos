public class Estagiario extends Funcionario {

    public Estagiario(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(nome, salario, departamento, cpf, dataNascimento);
    }

    public void fazerTarefa() {
        System.out.println("\n"+nome + " está fazendo uma tarefa.");
    }

    @Override
    public void mostrarDados() {
        System.out.println("\n[Estagiário]");
        super.mostrarDados();
    }
}
