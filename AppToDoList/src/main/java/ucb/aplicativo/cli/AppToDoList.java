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

                case 2 -> {
                    List<Tarefas> tarefas = servico.listarTarefas();
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("Lista de tarefas: ");
                        tarefas.forEach(t -> System.out.println(t));
                    }
                }

                case 3 -> {
                    System.out.print("ID da tarefa a atualizar: ");
                    long idTarefaAtualizar = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Novo titulo: ");
                    String novoTitulo = sc.nextLine();
                    System.out.print("Nova descricao: ");
                    String novaDescricao = sc.nextLine();
                    Boolean completa = null;
                    servico.atualizarTarefa(idTarefaAtualizar, novoTitulo, novaDescricao, completa);
                    System.out.println("Tarefa atualizada com sucesso!");
                }


                case 4 -> {
                    System.out.print("ID da tarefa a remover: ");
                    long idRemoverTarefa = sc.nextLong();
                    sc.nextLine();
                    servico.removerTarefa(idRemoverTarefa);
                    System.out.println("Tarefa removida com sucesso!");
                }

                case 5 -> {
                    System.out.print("ID da tarefa a pesquisar: ");
                    long idPesquisarTarefa = sc.nextLong();

                    boolean encontrada = false;
                    for (Tarefas tarefa : servico.listarTarefas()) {
                        if (tarefa.getId().equals(idPesquisarTarefa)) {
                            System.out.println("Tarefa encontrada: " + tarefa);
                            encontrada = true;
                            return;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("Tarefa com o ID " + idPesquisarTarefa + " não encontrada.");
                    }
                }
                    
                case 6 -> {
                    List<Tarefas> concluidas = servico.listarTarefasConcluidas();
                    if (concluidas.isEmpty()) {
                        System.out.println("Nenhuma tarefa concluída.");
                    } else {
                        System.out.println("Tarefas concluídas:");
                        concluidas.forEach(System.out::println);
                        }
                    }

                    case 7 -> {
                        System.out.println("Finalizando sistema...");
                        return;
                    }

                default -> System.out.println("Opção inválida!");
            }

        }

    }
}
