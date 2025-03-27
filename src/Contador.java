import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        try (Scanner terminal = new Scanner(System.in)) {
            System.out.println("Digite o primeiro parâmetro");
            int parametroUm = terminal.nextInt();

            System.out.println("Digite o segundo parâmetro");
            int parametroDois = terminal.nextInt();

            contar(parametroUm, parametroDois);
        } catch (InputMismatchException exception) {
            System.out.println("Erro: Entrada inválida. Por favor, insira números inteiros.");
        } catch (ParametrosInvalidosException exception) {
            System.out.println("Erro: " + exception.getMessage());
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm < parametroDois) {
            int totalOcorrencias = parametroDois - parametroUm;
            System.out.println("Total de ocorrências: " + totalOcorrencias);

            for (int number = 1; number <= totalOcorrencias; number++) {
                System.out.println("Imprimindo o número: " + number);
            }
        } else {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }
    }

    public static class ParametrosInvalidosException extends Exception {
        public ParametrosInvalidosException(String message) {
            super(message);
        }
    }
}