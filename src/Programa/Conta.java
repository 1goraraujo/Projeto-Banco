package Programa;

import utilitarios.Uteis;

public class Conta {
    private int NumeroDaConta;
    private Pessoa pessoa;
    private double saldo = 0.0;
    private static int contadorDeContas = 1;

    public Conta(Pessoa pessoa){
        NumeroDaConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }

    public int getNumeroDaConta() {
        return NumeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        NumeroDaConta = numeroDaConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta: \n" +
                "Numero Da Conta: " + NumeroDaConta +
                "\nNome: " + pessoa.getNome() +
                "\nCPF: " + pessoa.getCpf() +
                "\nE-mail: " + pessoa.getEmail() +
                "\nSaldo:" + Uteis.doubleTString(getSaldo()) +
                "\n";

    }

    public void Depositar(Double valor){
        if (valor > 0 ){
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso!");
        }else {
            System.out.println("Nao e possivel realizar o deposito.");
        }
    }
    public void Sacar(Double valor){
        if (valor > 0 && getSaldo() >= valor){
            System.out.println("Saque efetuado!");
        }else {
            System.out.println("Valor indisponivel para sacar.");
        }
    }
    public void Transferir(Conta contaParaDeposito, Double valor){
        if (valor > 0 && getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Deposito realizado com sucesso!");
        }else {
            System.out.println("Nao foi possivel realizar a transferencia.");
        }

    }
}

