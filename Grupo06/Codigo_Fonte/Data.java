package Codigo_Fonte;


public class Data {

    private int dia;
    private int mes;
    private int ano;

    private int hora;
    private int minuto;

    //construtor
    public Data(int dia, int mes, int ano, int hora, int minuto){
        if (validaEntradaDia(dia, mes, ano, hora, minuto)) {
            if (validaMes(dia, mes)) {
                this.dia = dia;
                this.mes = mes;
                this.ano = ano;

                this.hora = hora;
                this.minuto = minuto;
            }
        } else throw new IllegalArgumentException("A Data inseria está inválida");

    }

    //toString
    public String toString() {
        String dataFormatada = String.format("%02d/%02d/%04d", dia, mes, ano);
        String horaFormatada = String.format("%02d:%02d", hora, minuto);
        return String.format("Data: %s | Hora: %s", dataFormatada, horaFormatada);
    }


    //validação
    private boolean validaEntradaDia(int dia, int mes, int ano, int hora, int minuto){
        return ((dia < 1 || dia > 31) && (mes < 1 || mes > 31) && (ano < 2024 || ano > 2025) && (hora < 1 || hora > 60) && (minuto < 1 || minuto > 60));
    }
    private boolean validaMes(int dia, int mes){
        return ((dia > 28 && mes == 2) || (dia > 30 && mes == 4) || (dia > 30 && mes == 6) || (dia > 30 && mes == 9) || (dia > 30 && mes == 11));
    }

    //getters e setters
    public int getAno() {
        return ano;
    }
    public int getDia() {
        return dia;
    }
    public int getHora() {
        return hora;
    }
    public int getMes() {
        return mes;
    }
    public int getMinuto() {
        return minuto;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }public void setMes(int mes) {
        this.mes = mes;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    
    
    

}