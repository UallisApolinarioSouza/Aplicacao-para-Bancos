/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disponibilizado;

/**
 *
 * @author Uallis
 */
import java.util.Calendar;
import java.util.Scanner;

public class AplicacaoBancoInterface {
    private static Banco banco = new BancoImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Menu Banco ---\n");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Mostrar Extrato");
            System.out.println("7. Contas com Saldo Negativo");
            System.out.println("8. Clientes por Renda Mensal");
            System.out.println("9. Contas por Volume de Credito");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: cadastrarConta(); break;
                case 3: depositar(); break;
                case 4: sacar(); break;
                case 5: transferir(); break;
                case 6: mostrarExtrato(); break;
                case 7: contasSaldoNegativo(); break;
                case 8: clientesPorRenda(); break;
                case 9: contasPorVolumeCredito(); break;
                case 0: System.out.println("Encerrando o programa."); break;
                default: System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarCliente() {
        System.out.print("Codigo do cliente: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Renda mensal: ");
        double renda = scanner.nextDouble();

        Cliente cliente = new ClienteImpl(codigo, nome, renda);
        System.out.println("\nCliente cadastrado com sucesso!");
    }

    private static void cadastrarConta() {
        System.out.print("Numero da conta: ");
        String numero = scanner.nextLine();

        System.out.print("Codigo do cliente: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Conta Corrente (1) ou Poupanca (2): ");
        int tipo = scanner.nextInt();

        Calendar dataAbertura = Calendar.getInstance();
        Cliente cliente = new ClienteImpl(codigo, "", 0.0); // Simulação de busca

        Conta conta = (tipo == 1) ? new ContaCorrente(numero, cliente, dataAbertura, senha)
                                   : new ContaPoupanca(numero, cliente, dataAbertura, senha);

        banco.adicionaConta(conta);
        System.out.println("\nConta cadastrada com sucesso!");
    }

    private static void depositar() {
        System.out.print("Numero da conta: ");
        String numero = scanner.nextLine();

        System.out.print("Valor do deposito: ");
        double valor = scanner.nextDouble();

        Conta conta = banco.buscaConta(new ContaCorrente(numero, null, null, ""));
        if (conta != null && conta.depositar(valor)) {
            System.out.println("\nDeposito realizado com sucesso!");
        } else {
            System.out.println("\nErro ao realizar o deposito.");
        }
    }

    private static void sacar() {
        System.out.print("Numero da conta: ");
        String numero = scanner.nextLine();

        System.out.print("Valor do saque: ");
        double valor = scanner.nextDouble();

        System.out.print("Senha: ");
        String senha = scanner.next();

        Conta conta = banco.buscaConta(new ContaCorrente(numero, null, null, senha));
        if (conta != null && conta.sacar(valor, senha)) {
            System.out.println("\nSaque realizado com sucesso!");
        } else {
            System.out.println("\nErro ao realizar o saque.");
        }
    }

    private static void transferir() {
        System.out.print("Conta origem: ");
        String origem = scanner.nextLine();

        System.out.print("Conta destino: ");
        String destino = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        System.out.print("Senha: ");
        String senha = scanner.next();

        Conta contaOrigem = banco.buscaConta(new ContaCorrente(origem, null, null, senha));
        Conta contaDestino = banco.buscaConta(new ContaCorrente(destino, null, null, ""));

        if (contaOrigem != null && contaDestino != null && contaOrigem.transferirPara(valor, contaDestino, senha)) {
            System.out.println("\nTransferencia realizada com sucesso!");
        } else {
            System.out.println("\nErro ao transferir.");
        }
    }

    private static void mostrarExtrato() {
        System.out.print("Numero da conta: ");
        String numero = scanner.nextLine();

        Conta conta = banco.buscaConta(new ContaCorrente(numero, null, null, ""));
        if (conta != null) {
            System.out.println(conta.getExtratoToString());
        } else {
            System.out.println("\nConta nao encontrada.");
        }
    }

    private static void contasSaldoNegativo() {
        Conta[] contas = banco.getContasSaldoNegativo();
        for (Conta conta : contas) {
            System.out.println("Conta: " + conta.getNumero() + " | Saldo: " + conta.getSaldo());
        }
    }

    private static void clientesPorRenda() {
        System.out.print("Renda minima: ");
        double min = scanner.nextDouble();
        System.out.print("Renda maxima: ");
        double max = scanner.nextDouble();

        String[] clientes = banco.getNomesClientesRendaMensal(min, max);
        System.out.println("Clientes na faixa de renda:");
        for (String cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void contasPorVolumeCredito() {
        System.out.print("Montante: ");
        double montante = scanner.nextDouble();

        Calendar data = Calendar.getInstance();
        Conta[] contas = banco.getContasPorVolumeCreditoRecebidoPeriodo(montante, data);
        for (Conta conta : contas) {
            System.out.println("Conta: " + conta.getNumero());
        }
    }
}