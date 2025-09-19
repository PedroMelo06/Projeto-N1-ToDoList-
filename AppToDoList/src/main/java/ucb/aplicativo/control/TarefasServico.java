package ucb.aplicativo.control;

import ucb.aplicativo.model.Tarefas;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TarefasServico {
    private List<Tarefas> tarefas = new ArrayList<>();
    private Long contadorId = 1L;
    
    public Tarefas criarTarefa(String titulo, String descricao){
        
        Tarefas tarefa = new Tarefas(contadorId++, titulo, descricao, false);
        tarefas.add(tarefa);
        return tarefa;
    }    
    public List<Tarefas> listarTarefas() {
        return new ArrayList<>(tarefas);
    }
    
    public void atualizarTarefa(Long id, String novoTitulo, String novaDescricao, Boolean completa){
        for (Tarefas tarefa : tarefas){
            if(Objects.equals(tarefa.getId(), id)){
                if(novoTitulo != null){
                    tarefa.setTitulo(novoTitulo);
                }
                if(novaDescricao != null){
                    tarefa.setDescricao(novaDescricao);
                }
                if(completa != null){
                    tarefa.setCompleta(completa);
                }
                break;
            }
        }
    }
    
    public void removerTarefa(Long id){
        for(int i = 0; i < tarefas.size(); i++){
            if(Objects.equals(tarefas.get(i).getId(), id)){
                tarefas.remove(i);
                break;
            }
        }
    }
}
    