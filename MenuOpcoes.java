import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOpcoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("1 - Verificar PAR ou ÍMPAR");
                System.out.println("2 - Comparar dois números");
                System.out.println("3 - Calculadora");
                System.out.println("4 - Validar nota (0 a 100)");
                System.out.println("5 - Maior e menor número");
                System.out.println("6 - Simulador de Caixa");
                System.out.println("7 - Cálculo de desconto por categoria");
                System.out.println("8 - Contar positivos, negativos e zeros");
                System.out.println("9 - Soma de 1 até N");
                System.out.println("10 - Contagem regressiva e soma");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine(); // LIMPA O BUFFER (Consome o \n)

                switch (opcao) {
                    case 1:
                        System.out.print("Digite um número inteiro: ");
                        int numero = scanner.nextInt();
                        System.out.println(numero % 2 == 0 ? "RESULTADO: PAR" : "RESULTADO: ÍMPAR");
                        break;

                    case 2:
                        System.out.print("Digite o primeiro número: ");
                        int n1 = scanner.nextInt();
                        System.out.print("Digite o segundo número: ");
                        int n2 = scanner.nextInt();
                        if (n1 > n2) System.out.println("O maior é: " + n1);
                        else if (n2 > n1) System.out.println("O maior é: " + n2);
                        else System.out.println("Iguais");
                        break;

                    case 3:
                        System.out.println("1- Somar\n2- Subtrair\n3- Multiplicar\n4- Dividir");
                        System.out.print("Escolha uma opção: ");
                        int opCalc = scanner.nextInt();
                        System.out.print("Digite o primeiro número: ");
                        double a = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        double b = scanner.nextDouble();
                        switch (opCalc) {
                            case 1 -> System.out.println("Resultado: " + (a + b));
                            case 2 -> System.out.println("Resultado: " + (a - b));
                            case 3 -> System.out.println("Resultado: " + (a * b));
                            case 4 -> System.out.println(b != 0 ? "Resultado: " + (a / b) : "Erro: Divisão por zero!");
                            default -> System.out.println("Operação inválida!");
                        }
                        break;

                    case 4:
                        double nota;
                        do {
                            System.out.print("Digite uma nota entre 0 e 100: ");
                            nota = scanner.nextDouble();
                            if (nota < 0 || nota > 100) System.out.println("Nota inválida! Tente novamente.");
                        } while (nota < 0 || nota > 100);
                        System.out.println("Nota validada: " + nota);
                        break;

                    case 5:
                        System.out.print("Digite um número (ou 0 para sair): ");
                        int numInput = scanner.nextInt();
                        if (numInput == 0) System.out.println("Nenhum número foi digitado.");
                        else {
                            int maior = numInput, menor = numInput;
                            while (numInput != 0) {
                                if (numInput > maior) maior = numInput;
                                if (numInput < menor) menor = numInput;
                                System.out.print("Próximo número (ou 0 para sair): ");
                                numInput = scanner.nextInt();
                            }
                            System.out.println("Maior: " + maior + " | Menor: " + menor);
                        }
                        break;

                    case 6:
                        double saldo = 1000.00;
                        int opCaixa = 0;
                        while (opCaixa != 4) {
                            System.out.println("\n--- CAIXA (Saldo: R$ " + saldo + ") ---\n1- Depósito | 2- Saque | 3- Saldo | 4- Voltar");
                            opCaixa = scanner.nextInt();
                            if (opCaixa == 1) {
                                System.out.print("Valor: ");
                                saldo += scanner.nextDouble();
                            } else if (opCaixa == 2) {
                                System.out.print("Valor: ");
                                double saque = scanner.nextDouble();
                                if (saque <= saldo) saldo -= saque; else System.out.println("Saldo insuficiente!");
                            } else if (opCaixa == 3) {
                                System.out.printf("Saldo: R$ %.2f\n", saldo);
                            }
                        }
                        break;

                    case 7:
                        System.out.print("Valor da compra: R$ ");
                        double valorCompra = scanner.nextDouble();
                        System.out.println("1-Comum (5%), 2-Premium (10%), 3-Funcionário (15%)");
                        int categoria = scanner.nextInt();
                        double desc = switch (categoria) {
                            case 1 -> 0.05;
                            case 2 -> 0.10;
                            case 3 -> 0.15;
                            default -> 0.0;
                        };
                        System.out.printf("Total com desconto: R$ %.2f\n", valorCompra * (1 - desc));
                        break;

                    case 8:
                        int pos = 0, neg = 0, zero = 0;
                        for (int i = 1; i <= 10; i++) {
                            System.out.print(i + "º número: ");
                            int n = scanner.nextInt();
                            if (n > 0) pos++; else if (n < 0) neg++; else zero++;
                        }
                        System.out.println("Positivos: " + pos + " | Negativos: " + neg + " | Zeros: " + zero);
                        break;

                    case 9:
                        System.out.print("Digite N: ");
                        int nFim = scanner.nextInt();
                        int somaN = 0;
                        for (int i = 1; i <= nFim; i++) somaN += i;
                        System.out.println("Soma: " + somaN);
                        break;

                    case 10:
                        System.out.print("Digite N: ");
                        int nReg = scanner.nextInt();
                        int somaReg = 0;
                        for (int i = nReg; i >= 1; i--) {
                            System.out.print(i + " ");
                            somaReg += i;
                        }
                        System.out.println("\nSoma total: " + somaReg);
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
                
                if (opcao != 0) {
                    System.out.println("\nPressione ENTER para voltar ao menu...");
                    scanner.nextLine(); // Aguarda o usuário
                    scanner.nextLine();
                }

            } catch (InputMismatchException e) {
                System.err.println("ERRO: Digite apenas números!");
                scanner.nextLine(); // Limpa o erro do scanner
            }
        } while (opcao != 0);

        scanner.close();
    }
}