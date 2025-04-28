public  class Funcionario extends Pessoa {
    public String nome;
    public double salario;
    public String departamento;

    //Construtor padrão com atributos herdados da classe Pai 'Pessoa'
    public Funcionario(String nome, double salario, String departamento, String cpf, String dataNascimento) {
        super(cpf, dataNascimento);
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    
    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: " + salario);
        System.out.println("Departamento: " + departamento);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("---------"); //Interface
    }

    public void baterPonto() {
        System.out.println("\n"+nome + " bateu o ponto."); //Método padrão Funcionario
    }
}

