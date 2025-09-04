package ucb.aplicativo.cli;

import java.util.Scanner;

public class AppToDoList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TarefasServico servico = new TarefasServico();
        int opcao;

        do {
            System.out.println("---------------- MENU ----------------");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Modificar tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Marcar tarefa como concluída");
            System.out.println("0 - Sair");

            System.out.print("Escolha a opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descricao: ");
                    String descricao = sc.nextLine();
                    servico.adicionarTarefa(titulo, descricao);
                    break;

                case 2:
                    servico.listarTarefas();
                    break;

                case 3:
                    System.out.print("ID da tarefa a modificar: ");
                    int idTarefaAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo titulo: ");
                    String novoTitulo = sc.nextLine();
                    System.out.print("Nova descricao: ");
                    String novaDescricao = sc.nextLine();
                    servico.atualizarTarefa(idTarefaAtualizar, novoTitulo, novaDescricao);
                    break;

                case 4:
                    System.out.print("ID da tarefa a remover: ");
                    int idRemoverTarefa = sc.nextInt();
                    sc.nextLine();
                    servico.removerTarefa(idRemoverTarefa);
                    break;

                case 5:
                    System.out.print("ID da tarefa a concluir: ");
                    int idConcluirTarefa = sc.nextInt();
                    sc.nextLine();
                    servico.marcarComoConcluida(idConcluirTarefa);
                    break;

                case 0:
                    System.out.println("Finalizando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
