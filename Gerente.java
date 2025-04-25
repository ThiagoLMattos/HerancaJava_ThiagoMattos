public class Gerente extends Funcionario {

    public Gerente(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(nome, salario, departamento, cpf, dataNascimento);
    }

    public void realizarReuniao() {
        System.out.println("\n"+nome + " está realizando uma reunião.");
    }

    @Override
    public void mostrarDados() {
        System.out.println("\n[Gerente]");
        super.mostrarDados();
    }
}
