import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<Tarefa> listaTarefas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            try {
                mostrarMenu();
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarTarefa();
                        break;
                    case 2:
                        removerTarefa();
                        break;
                    case 3:
                        marcarTarefaConcluida();
                        break;
                    case 4:
                        listarTarefas();
                        break;
                    case 5:
                        executando = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Tarefa não encontrada. Insira um índice válido.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Gerenciador de Tarefas ---");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Remover Tarefa");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Listar Tarefas");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        listaTarefas.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void removerTarefa() {
        listarTarefas();
        System.out.print("Digite o número da tarefa a remover: ");
        int indice = scanner.nextInt() - 1;
        Tarefa removida = listaTarefas.remove(indice);
        System.out.println("Tarefa '" + removida.getDescricao() + "' removida com sucesso.");
    }

    private static void marcarTarefaConcluida() {
        listarTarefas();
        System.out.print("Digite o número da tarefa a marcar como concluída: ");
        int indice = scanner.nextInt() - 1;
        listaTarefas.get(indice).marcarComoConcluida();
        System.out.println("Tarefa marcada como concluída!");
    }

    private static void listarTarefas() {
        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            System.out.println("\n--- Lista de Tarefas ---");
            for (int i = 0; i < listaTarefas.size(); i++) {
                System.out.println((i + 1) + ". " + listaTarefas.get(i));
            }
        }
    }
}
