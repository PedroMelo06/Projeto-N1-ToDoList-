package ucb.aplicativo.cli;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import ucb.aplicativo.model.Tarefas;
import ucb.aplicativo.control.TarefasServico;


public class AppToDoList {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner sc = new Scanner(System.in);
        
        TarefasServico servico = new TarefasServico();

        while(true) {
            System.out.println("---------------- ToDoList ----------------");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Pesquisar tarefa");
            System.out.println("6 - Tarefas concluidas");
            System.out.println("7 - Sair");
            System.out.print("Escolha a opcao: ");
            
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descricao: ");
                    String descricao = sc.nextLine();
                    Tarefas nova = servico.criarTarefa (titulo, descricao);
                    System.out.println("Tarefa criada com sucesso: " + nova.getTitulo());
                }

                case 2 -> servico.listarTarefas();

                case 3 -> {
                    System.out.print("ID da tarefa a modificar: ");
                    int idTarefaAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo titulo: ");
                    String novoTitulo = sc.nextLine();
                    System.out.print("Nova descricao: ");
                    String novaDescricao = sc.nextLine();
                    servico.atualizarTarefa(idTarefaAtualizar, novoTitulo, novaDescricao);
                }

                case 4 -> {
                    System.out.print("ID da tarefa a remover: ");
                    int idRemoverTarefa = sc.nextInt();
                    sc.nextLine();
                    servico.removerTarefa(idRemoverTarefa);
                }

                case 5 -> {
                    System.out.print("ID da tarefa a concluir: ");
                    int idConcluirTarefa = sc.nextInt();
                    sc.nextLine();
                    servico.marcarComoConcluida(idConcluirTarefa);
                }

                case 0 -> System.out.println("Finalizando sistema...");

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
