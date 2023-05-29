package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("---------------------------------------------------");
        System.out.println("----------BEM VINDOS A NOSSA AGENCIA---------------");
        System.out.println("---------------------------------------------------");
        System.out.println("*****SELECIONE A OPERAÇAO QUE DESEJA REALIZAR******");
        System.out.println("|   Opçao 1 - Criar conta   |");
        System.out.println("|   Opçao 2 - Depositar     |");
        System.out.println("|   Opçao 3 - Sacar         |");
        System.out.println("|   Opçao 4 - Transferir    |");
        System.out.println("|   Opçao 5 - Listar        |");
        System.out.println("|   Opçao 6 - Sair          |\n");

        int opc = teclado.nextInt();

        switch (opc){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa agencia!");
                System.exit(0);
            default:
                System.out.println("Opçao invalida.");
                operacoes();
                break;
        }
    }
    public static void criarConta(){
        System.out.println("\nNome: ");
        String nome = teclado.next();

        System.out.println("\nCPF: ");
        String cpf = teclado.next();

        System.out.println("\nE-mail: ");
        String email = teclado.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);
        contasBancarias.add(conta);
        System.out.println("Coonta criada com sucesso!");

        operacoes();
    }
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroDaConta() == numeroConta)
                    conta = c;
            }
        }
        return conta;
    }
    public static void depositar(){
        System.out.println("Numero da conta: ");
        int numeroConta = teclado.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Digite o valor para deposito");
            Double valorDeposito = teclado.nextDouble();
            conta.Depositar(valorDeposito);
        }else {
            System.out.println("Conta nao encontrada");
        }
        operacoes();
    }
    public static void sacar(){
        System.out.println("Numero da conta: ");
        int numeroConta = teclado.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Digite o valor para sacar");
            Double valorSaque = teclado.nextDouble();
            conta.Sacar(valorSaque);
        }else {
            System.out.println("Conta nao encontrada");
        }
        operacoes();
    }
    public static void transferir(){
        System.out.println("Digite o numero da sua conta");
        int numeroDaContaRemetente = teclado.nextInt();
        Conta contaRemetente = encontrarConta(numeroDaContaRemetente);


        if (contaRemetente != null) {
            System.out.println("Numero da conta que voce quer fazer a transferencia");
            int numeroContaDestinatario = teclado.nextInt();
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            if (contaDestinatario != null) {
                System.out.println("Digite o valor da tranferencia");
                double valor = teclado.nextDouble();

                contaRemetente.Transferir(contaDestinatario, valor);
            } else {
                System.out.println("Conta para deposito nao encontrada.");
            }
        }else {
            System.out.println("Conta para transferencia nao encontrada.");
        } operacoes();
    }
    public static void listar(){
        if (contasBancarias.size() > 0){
            for (Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else {
            System.out.println("Nao ha contas cadastradas");
        }
        operacoes();
    }


}
