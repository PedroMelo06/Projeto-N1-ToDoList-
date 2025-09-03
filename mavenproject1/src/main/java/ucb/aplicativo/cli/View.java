/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author paulo
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        TarefaServico servico = new TarefaServico();
        
        do{
            System.out.println("---------------- MENU ----------------");
            System.out.print("1 - Adicionar tarefa");
            System.out.print("2 - Listar tarefas");
            System.out.print("3 - Modificar tarefa");
            System.out.print("4 - Remover tarefa");
            System.out.print("5 - Marcar tarefa como concluida");
            System.out.print("0 - Sair");
            
            int opcao;
            
            System.out.print("Escolha a opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                
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
                    System.out.print("ID da tarefa a modificar: ");
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
                
            } while(opcao != 0);
            
        }
        
    }
}
