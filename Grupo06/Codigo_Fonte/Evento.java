package Codigo_Fonte;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Evento{
    private Data DataInicio,DataFim;
    private String local,nome;
    private Usuario[] convidados = new Usuario[50];
    private int contadorConvidados;
    private boolean confirmado;
    public Evento(String nome, String local, Data DataInicio, Data DataFim, Usuario[] convidados, int contadorConvidados, boolean confirmado){
        this.nome = nome;
        this.local = local;
        if(validaDatas(DataInicio, DataFim)){
            this.DataInicio = DataInicio;
            this.DataFim = DataFim;
        }
        else throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
        this.confirmado = confirmado;
        this.contadorConvidados = contadorConvidados;
        for(int i=0;i<contadorConvidados;i++){
            this.convidados[i] = convidados[i];
        }
    }
    public void verListaConvidados(){
        for(int i=0;i<contadorConvidados;i++){
            System.out.println("Convidado "+(i+1)+": "+convidados[i].getNome());
        }
    }
    public void DuracaoEvento(){
        LocalDateTime inicio = LocalDateTime.of(DataInicio.getAno(), DataInicio.getMes(), DataInicio.getDia(), DataInicio.getHora(), DataInicio.getMinuto());
        LocalDateTime fim = LocalDateTime.of(DataFim.getAno(), DataFim.getMes(), DataFim.getDia(), DataFim.getHora(), DataFim.getMinuto());
        long diferencaEmDias = ChronoUnit.DAYS.between(inicio, fim);
        long diferencaEmHoras = ChronoUnit.HOURS.between(inicio, fim)%24;
        long diferencaEmMinutos = ChronoUnit.MINUTES.between(inicio, fim)%60;
        System.out.printf("O Evento tem duração de %d dia(s), %d hora(s), %d minuto(s)\n", diferencaEmDias, diferencaEmHoras, diferencaEmMinutos);
    }
    public void VisualizarEvento(){
        System.out.println("Nome do Evento: "+nome);
        System.out.println("Local: "+local);
        System.out.println("Data de Início: "+DataInicio.toString());
        System.out.println("Data de Fim: "+DataFim.toString());
        System.out.println("Confirmado: "+(confirmado ? "Sim" : "Não"));
        System.out.println("Número de Convidados: "+contadorConvidados);
    }
    private boolean validaDatas(Data DataInicio, Data DataFim) {
        LocalDateTime inicio = LocalDateTime.of(DataInicio.getAno(), DataInicio.getMes(), DataInicio.getDia(), DataInicio.getHora(), DataInicio.getMinuto());
        LocalDateTime fim = LocalDateTime.of(DataFim.getAno(), DataFim.getMes(), DataFim.getDia(), DataFim.getHora(), DataFim.getMinuto());
        return inicio.isBefore(fim);
    }
    public String getNome(){
        return nome;
    }
    public String getLocal(){
        return local;
    }
    public Data getDataInicio(){
        return DataInicio;
    }
    public Data getDataFim(){
        return DataFim;
    }
    public Usuario[] getConvidados(){
        return convidados;
    }
    public int getContadorConvidados(){
        return contadorConvidados;
    }
    public boolean getConfirmado(){
        return confirmado;
    }
}