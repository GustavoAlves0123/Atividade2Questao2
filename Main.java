class Pessoa {
    String nome;
    int idade;
    String CPF;

    public Pessoa(String nome, int idade, String CPF) {
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
    }

    public void informacoes() {
        System.out.println("Nome: " + nome + " Idade: " + idade + " CPF: " + CPF);
    }
}

class Cliente extends Pessoa {
    private double saldo;

    public Cliente(String nome, int idade, String CPF, double saldoInicial) {
        super(nome, idade, CPF);
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        } else {
            System.out.println("O valor de depósito deve ser positivo.");
        }
    }
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

class Funcionario extends Pessoa {
    public Funcionario(String nome, int idade, String CPF) {
        super(nome, idade, CPF);
    }

    @Override
    public void informacoes() {
        System.out.println("Funcionário genérico.");
    }
}

class Secretario extends Funcionario {
    public Secretario(String nome, int idade, String CPF) {
        super(nome, idade, CPF);
    }
    @Override
    public void informacoes() {
        System.out.println("Secretário.");
    }
}

class Gerente extends Funcionario {
    public Gerente(String nome, int idade, String CPF) {
        super(nome, idade, CPF);
    }
    @Override
    public void informacoes() {
        System.out.println("Gerente autenticado.");
    }
}

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João Silva", 35, "123.456.789-00", 1000.0);
        cliente.informacoes();
        cliente.depositar(500);
        cliente.sacar(200);
        Funcionario novoSecretario = new Secretario("Maria", 30, "987.654.321-00");
        Funcionario novoGerente = new Gerente("Carlos", 45, "111.222.333-44");
        novoSecretario.informacoes();
        novoGerente.informacoes();
    }
}