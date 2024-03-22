package Codigo_Fonte;


public class Data {

    private int dia;
    private int mes;
    private int ano;

    private int hora;
    private int minuto;

    //construtor
    public Data(int dia, int mes, int ano, int hora, int minuto){
        if (validaData(dia, mes, ano)) {
            
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else throw new IllegalArgumentException("A Data inseria está inválida");

        if (validaHora(hora, minuto)) {
            this.hora = hora;
            this.minuto = minuto;
        } else throw new IllegalArgumentException("A Hora inserida está inválida");

    }

    //toString
    public String toString() {
        String dataFormatada = String.format("%02d/%02d/%04d", dia, mes, ano);
        String horaFormatada = String.format("%02d:%02d", hora, minuto);
        return String.format("Data: %s | Hora: %s", dataFormatada, horaFormatada);
    }


    //validação
    private boolean validaData(int dia, int mes, int ano){
        if(ano < 2024) return false;
        else if(mes < 1 || mes > 12) return false; //valida se o mes está dentro o intervalo
        else if(dia < 1 || dia > diasNoMes(dia, mes)) return false; // valida se o dia é maior que 1 e se está dentro do intervalos de dia do mes inserido

        return true;
    }

    private int diasNoMes(int dia, int mes){
        if(mes == 2){
            if(validaBissexto(mes)) return 29; // se for bissexto fev tem 29 dias
            else return 28;
        } // se for fevereiro retorna 28 dias
        else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) return 30; // se for abril, junho, setembro ou novembro retorna 30 dias
        else return 31; // se não for nenhum desses, retorna 31
    }

    private boolean validaHora(int hora, int minuto){
        return ((hora < 1 || hora > 60) && (minuto < 0 || minuto > 60));//verifica se a hora e os minutos são validos;
    }

    private boolean validaBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    //getters e setters
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        if(validaData(dia, this.mes, this.ano)){
            this.dia = dia;
        } else throw new IllegalArgumentException("O dia inserido está inválido");
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        if(validaData(this.dia, this.mes, ano)){
            this.ano = ano;
        } else throw new IllegalArgumentException("O ano inserido está inválido");
    }

    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        if (validaData(this.dia, mes, this.ano)) {
            this.mes = mes;
        } else throw new IllegalArgumentException("O mês inserido está inválido");
    }

    public int getHora() {
        return hora;
    }
    public void setHora(int hora) {
        if (validaHora(hora, this.minuto)) {
            this.hora = hora;
        } else throw new IllegalArgumentException("A hora inserida está inválida");
    }

    public int getMinuto() {
        return minuto;
    }
    public void setMinuto(int minuto) {
        if (validaHora(this.hora, minuto)) {
            this.minuto = minuto;
        } else throw new IllegalArgumentException("O minuto inserido está inválido");
    }

    
    
    

}